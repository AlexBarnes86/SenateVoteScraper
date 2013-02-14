package com.toastedbits.vote.datainserter;
import gov.senate.rollcallvote.Amendment;
import gov.senate.rollcallvote.Document;
import gov.senate.rollcallvote.Member;
import gov.senate.rollcallvote.RollCallVote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import javax.sql.DataSource;
import javax.xml.transform.stream.StreamSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.Unmarshaller;

import com.toastedbits.vote.datainserter.messages.BeginParsingMessage;
import com.toastedbits.vote.datainserter.messages.EndParseFolderMessage;
import com.toastedbits.vote.datainserter.messages.ParseFileMessage;
import com.toastedbits.vote.datainserter.messages.ParseFolderMessage;
import com.toastedbits.vote.models.AmendmentModel;
import com.toastedbits.vote.models.DocumentModel;
import com.toastedbits.vote.models.MemberModel;
import com.toastedbits.vote.models.MemberPartyMapModel;
import com.toastedbits.vote.models.PartyModel;
import com.toastedbits.vote.models.RollCallVoteModel;
import com.toastedbits.vote.models.VoteModel;
import com.toastedbits.vote.oxm.MatchingMember;
import com.toastedbits.vote.tables.AmendmentTable;
import com.toastedbits.vote.tables.DocumentTable;
import com.toastedbits.vote.tables.MemberPartyMapTable;
import com.toastedbits.vote.tables.MemberTable;
import com.toastedbits.vote.tables.PartyTable;
import com.toastedbits.vote.tables.RollCallVoteTable;
import com.toastedbits.vote.tables.VoteTable;

public class DataInserter extends Observable {
	private static Map<Member, String> addedMembers = new HashMap<Member, String>();
	private static Map<Member, List<String>> memberParties = new HashMap<Member, List<String>>();
	private static ArrayList<String> addedParties = new ArrayList<String>();
	
	//TODO: Turn on annotation scanning and Autowire these service classes
	private MemberTable memberTable = new MemberTable();
	private RollCallVoteTable rollCallVoteTable = new RollCallVoteTable();
	private VoteTable voteTable = new VoteTable();
	private DocumentTable documentTable = new DocumentTable();
	private AmendmentTable amendmentTable = new AmendmentTable();
	private PartyTable partyTable = new PartyTable();
	private MemberPartyMapTable memberPartyMapTable = new MemberPartyMapTable();
	
	private JdbcTemplate jdbcTemplate;
	private Unmarshaller unmarshaller;
	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void setUnmarshaller(Unmarshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}
	
	public void dropTables() throws SQLException {
		voteTable.drop(jdbcTemplate);
		rollCallVoteTable.drop(jdbcTemplate);
		memberTable.drop(jdbcTemplate);
		documentTable.drop(jdbcTemplate);
		amendmentTable.drop(jdbcTemplate);
		partyTable.drop(jdbcTemplate);
		memberPartyMapTable.drop(jdbcTemplate);
	}
	
	public void createTables() throws SQLException {
		partyTable.create(jdbcTemplate);
		memberTable.create(jdbcTemplate);
		memberPartyMapTable.create(jdbcTemplate);
		rollCallVoteTable.create(jdbcTemplate);
		documentTable.create(jdbcTemplate);
		amendmentTable.create(jdbcTemplate);
		voteTable.create(jdbcTemplate);
	}
	
	private void changeAndNotify(Object msg) {
		setChanged();
		notifyObservers(msg);
	}
	
	private List<DocumentModel> getDocuments(RollCallVote rollCallVote) {
		List<DocumentModel> documentModels = new ArrayList<DocumentModel>();
		
		if(rollCallVote != null && rollCallVote.getDocument() != null) {
			for(Document document : rollCallVote.getDocument()) {
				DocumentModel model = new DocumentModel();
				model.setDocumentName(document.getName());
				model.setDocumentNumber(document.getNumber());
				model.setDocumentShortTitle(document.getShortTitle());
				model.setDocumentTitle(document.getTitle());
				model.setDocumentType(document.getType());
				
				documentModels.add(model);
			}
		}
		
		return documentModels;
	}
	
	private List<AmendmentModel> getAmendments(RollCallVote rollCallVote) {
		List<AmendmentModel> amendmentModels = new ArrayList<AmendmentModel>();
		
		if(rollCallVote != null && rollCallVote.getAmendment() != null) {
			for(Amendment amendment : rollCallVote.getAmendment()) {
				AmendmentModel model = new AmendmentModel();
				model.setAmendmentNumber(amendment.getNumber());
				model.setAmendmentPurpose(amendment.getPurpose());
				model.setAmendmentToAmendmentNumber(amendment.getToAmendmentToAmendmentNumber());
				model.setAmendmentToDocumentNumber(amendment.getToDocumentNumber());
				model.setAmendmentToDocumentShortTitle(amendment.getToDocumentShortTitle());
				
				amendmentModels.add(model);
			}
		}
		
		return amendmentModels;
	}
	
	private void parseFile(File rollCallFile) throws IOException {
		int session = Integer.parseInt(rollCallFile.getName().substring(9, 10));
		RollCallVote rollCall = (RollCallVote)unmarshaller.unmarshal(new StreamSource(new FileInputStream(rollCallFile)));
		String rollCallVoteId = RollCallVoteModel.insert(rollCall, session, jdbcTemplate);
		
		for(AmendmentModel model : getAmendments(rollCall)) {
			model.insert(rollCallVoteId, jdbcTemplate);
		}
		
		for(DocumentModel model : getDocuments(rollCall)) {
			model.insert(rollCallVoteId, jdbcTemplate);
		}
		
		for(Member member : rollCall.getMembers().getMembers()) {
			member.setParty(member.getParty() == null ? "" : member.getParty().trim());
			
			if(!addedParties.contains(member.getParty())) {
				PartyModel.insert(member.getParty(), jdbcTemplate);
				addedParties.add(member.getParty());
			}
			
			if(!addedMembers.containsKey(new MatchingMember(member, true, true, false))) {
				String memberId = MemberModel.insert(member, jdbcTemplate);
				addedMembers.put(new MatchingMember(member, true, true, false), memberId);
				
				List<String> parties = new ArrayList<String>();
				parties.add(member.getParty());
				memberParties.put(new MatchingMember(member, true, true, false), parties);
				MemberPartyMapModel.insert(memberId, member.getParty(), null, null, jdbcTemplate);
			}
			
			if(!memberParties.get(new MatchingMember(member, true, true, false)).contains(member.getParty())) {
				memberParties.get(new MatchingMember(member, true, true, false)).add(member.getParty());
				MemberPartyMapModel.insert(addedMembers.get(member), member.getParty(), null, null, jdbcTemplate);
			}
			
			VoteModel.insert(rollCallVoteId, addedMembers.get(member), member.getVoteCast(), jdbcTemplate);
		}
		changeAndNotify(ParseFileMessage.MSG);
	}
	
	public void parseFolders(File[] dataFolders) throws IOException {
		changeAndNotify(new BeginParsingMessage(dataFolders));
		for(File data : dataFolders) {
			File[] dataFiles = data.listFiles();
			changeAndNotify(new ParseFolderMessage(data.getName(), dataFiles.length));
			for(File rollCallFile : dataFiles) {
				parseFile(rollCallFile);
			}
			changeAndNotify(new EndParseFolderMessage());
		}
	}
}
package gov.senate.rollcallvote;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("roll_call_vote")
public class RollCallVote {
	@XStreamAlias("congress") private String congress; //int
	@XStreamAlias("session") private String session; //int
	@XStreamAlias("congress_year") private String congressYear; //int
	@XStreamAlias("vote_number") private String voteNumber; //int
	@XStreamAlias("vote_date") private String voteDate;
	@XStreamAlias("modify_date") private String modifyDate;
	@XStreamAlias("vote_question_text") private String voteQuestionText;
	@XStreamAlias("vote_document_text") private String voteDocumentText;
	@XStreamAlias("vote_result_text") private String voteResultText;
	@XStreamAlias("question") private String question;
	@XStreamAlias("vote_title") private String voteTitle;
	@XStreamAlias("majority_requirement") private String majorityRequirement;
	@XStreamAlias("vote_result") private String voteResult;
	
	@XStreamImplicit @XStreamAlias("document") private List<Document> document;
	@XStreamImplicit @XStreamAlias("amendment") private List<Amendment> amendment;
	@XStreamAlias("count") private Count count;
	@XStreamAlias("tie_breaker") private TieBreaker tieBreaker;
	@XStreamAlias("members") private Members members;
	
	public String getCongress() {
		return congress;
	}
	public void setCongress(String congress) {
		this.congress = congress;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getCongressYear() {
		return congressYear;
	}
	public void setCongressYear(String congressYear) {
		this.congressYear = congressYear;
	}
	public String getVoteNumber() {
		return voteNumber;
	}
	public void setVoteNumber(String voteNumber) {
		this.voteNumber = voteNumber;
	}
	public String getVoteDate() {
		return voteDate;
	}
	public void setVoteDate(String voteDate) {
		this.voteDate = voteDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getVoteQuestionText() {
		return voteQuestionText;
	}
	public void setVoteQuestionText(String voteQuestionText) {
		this.voteQuestionText = voteQuestionText;
	}
	public String getVoteDocumentText() {
		return voteDocumentText;
	}
	public void setVoteDocumentText(String voteDocumentText) {
		this.voteDocumentText = voteDocumentText;
	}
	public String getVoteResultText() {
		return voteResultText;
	}
	public void setVoteResultText(String voteResultText) {
		this.voteResultText = voteResultText;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getVoteTitle() {
		return voteTitle;
	}
	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}
	public String getMajorityRequirement() {
		return majorityRequirement;
	}
	public void setMajorityRequirement(String majorityRequirement) {
		this.majorityRequirement = majorityRequirement;
	}
	public String getVoteResult() {
		return voteResult;
	}
	public void setVoteResult(String voteResult) {
		this.voteResult = voteResult;
	}
	public List<Document> getDocument() {
		return document;
	}
	public void setDocument(List<Document> document) {
		this.document = document;
	}
	public List<Amendment> getAmendment() {
		return amendment;
	}
	public void setAmendment(List<Amendment> amendment) {
		this.amendment = amendment;
	}
	public Count getCount() {
		return count;
	}
	public void setCount(Count count) {
		this.count = count;
	}
	public TieBreaker getTieBreaker() {
		return tieBreaker;
	}
	public void setTieBreaker(TieBreaker tieBreaker) {
		this.tieBreaker = tieBreaker;
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
}

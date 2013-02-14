package gov.senate.rollcallvote;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("member")
public class Member {
	@XStreamAlias("member_full") private String full;
	@XStreamAlias("last_name") private String lastName;
	@XStreamAlias("first_name") private String firstName;
	@XStreamAlias("party") private String party;
	@XStreamAlias("state") private String state;
	@XStreamAlias("vote_cast") private String voteCast;
	@XStreamAlias("lis_member_id") private String lisMemberId;
	
	public String getFull() {
		return full;
	}
	public void setFull(String full) {
		this.full = full;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getVoteCast() {
		return voteCast;
	}
	public void setVoteCast(String voteCast) {
		this.voteCast = voteCast;
	}
	public String getLisMemberId() {
		return lisMemberId;
	}
	public void setLisMemberId(String lisMemberId) {
		this.lisMemberId = lisMemberId;
	}
}

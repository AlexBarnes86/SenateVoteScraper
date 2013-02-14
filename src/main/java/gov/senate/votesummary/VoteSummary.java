package gov.senate.votesummary;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("vote_summary")
public class VoteSummary {
	@XStreamAlias("congress") private String congress;
	@XStreamAlias("session") private String session;
	@XStreamAlias("congress_year") private String congressYear;
	@XStreamAlias("votes") private List<Vote> votes;
	
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
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}

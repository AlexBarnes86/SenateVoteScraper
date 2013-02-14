package gov.senate.rollcallvote;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("tie_breaker")
public class TieBreaker {
	@XStreamAlias("by_whom") private String byWhom;
	@XStreamAlias("tie_breaker_vote") private String vote;
	
	public String getByWhom() {
		return byWhom;
	}
	public void setByWhom(String byWhom) {
		this.byWhom = byWhom;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
}

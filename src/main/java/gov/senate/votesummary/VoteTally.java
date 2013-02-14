package gov.senate.votesummary;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("vote_tally")
public class VoteTally {
	@XStreamAlias("yeas") private String yeas;
	@XStreamAlias("nays") private String nays;
	
	public String getYeas() {
		return yeas;
	}
	public void setYeas(String yeas) {
		this.yeas = yeas;
	}
	public String getNays() {
		return nays;
	}
	public void setNays(String nays) {
		this.nays = nays;
	}
}

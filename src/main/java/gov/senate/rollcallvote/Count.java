package gov.senate.rollcallvote;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Count {
	@XStreamAlias("yeas") private String yeas; //int
	@XStreamAlias("nays") private String nays; //int
	@XStreamAlias("present") private String present; //int
	@XStreamAlias("absent") private String absent; //int
	
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
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getAbsent() {
		return absent;
	}
	public void setAbsent(String absent) {
		this.absent = absent;
	}
}

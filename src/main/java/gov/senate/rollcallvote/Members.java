package gov.senate.rollcallvote;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("members")
public class Members {
	@XStreamImplicit(itemFieldName="member") List<Member> members;
	
	public List<Member> getMembers() {
		return members;
	}
	
	public void setMembers(List<Member> members) {
		this.members = members;
	}
}

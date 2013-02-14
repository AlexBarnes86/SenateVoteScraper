package gov.senate.votesummary;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("issue")
public class Issue {
	@XStreamAlias("A") private A a;
	
	public A getA() {
		return a;
	}
	
	public void setA(A a) {
		this.a = a;
	}
}

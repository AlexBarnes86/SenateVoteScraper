package com.toastedbits.vote.oxm;

import gov.senate.rollcallvote.Member;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class MatchingMember extends Member {
	private final boolean matchByName;
	private final boolean matchByState;
	private final boolean matchByParty;
	
	public MatchingMember(final Member member) {
		this(member, true, true, true);
	}
	
	public MatchingMember(final Member member, boolean matchByName, boolean matchByState, boolean matchByParty) {
		this.setFirstName(member.getFirstName());
		this.setLastName(member.getLastName());
		this.setFull(member.getFull());
		this.setLisMemberId(member.getLisMemberId());
		this.setParty(member.getParty());
		this.setState(member.getState());
		this.setVoteCast(member.getVoteCast());
		
		this.matchByName = matchByName;
		this.matchByState = matchByState;
		this.matchByParty = matchByParty;
		
		if(matchByName == false && matchByState == false && matchByParty == false) {
			throw new IllegalArgumentException("At least one match property must be true");
		}
	}
	
	private int PRIME1 = 7, PRIME2 = 31;
	
	@Override
	public int hashCode() {
		HashCodeBuilder hcb = new HashCodeBuilder(PRIME1, PRIME2);
		if(matchByName) {
			hcb.append(this.getFirstName());
			hcb.append(this.getLastName());
		}
		if(matchByState) {
			hcb.append(this.getState());
		}
		if(matchByParty) {
			hcb.append(this.getParty());
		}
		
		return hcb.toHashCode();
	}
	
	@Override
	public boolean equals(Object rhs) {
		if(rhs == null) {return false;}
		if(rhs == this) {return true;}
		//TODO: figure this bit out
//		if(!Member.class.isAssignableFrom(rhs.getClass())) {return false;}
		
		Member m = (Member) rhs;
		EqualsBuilder eb = new EqualsBuilder();
		if(matchByName) {
			eb.append(this.getFirstName(), m.getFirstName());
			eb.append(this.getLastName(), m.getLastName());
		}
		if(matchByState) {
			eb.append(this.getState(), m.getState());
		}
		if(matchByParty) {
			eb.append(this.getParty(), m.getParty());
		}
		
		return eb.isEquals();
	}
}

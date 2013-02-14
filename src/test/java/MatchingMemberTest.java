import gov.senate.rollcallvote.Member;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import com.toastedbits.vote.oxm.MatchingMember;

public class MatchingMemberTest {
	@Test
	public void testMatchAllMember() {
		Map<Member, String> map = new HashMap<Member, String>();
		
		Member member = new Member();
		member.setFirstName("Alex");
		member.setLastName("Barnes");
		member.setState("Texas");
		member.setParty("D");
		
		Member member2 = new Member();
		member2.setFirstName("Alex");
		member2.setLastName("Barnes");
		member2.setState("Texas");
		member2.setParty("D");
		
		Member member3 = new Member();
		member3.setFirstName("Alex");
		member3.setLastName("Barnes");
		member3.setState("Texas");
		member3.setParty("R");
		
		map.put(new MatchingMember(member), "1");
		
		assertEquals(new MatchingMember(member).hashCode(), new MatchingMember(member2).hashCode());
		assertEquals(new MatchingMember(member), new MatchingMember(member2));
		assertNotNull(map.get(new MatchingMember(member2)));
		assertNull(map.get(new MatchingMember(member3, true, true, false)));
	}
}

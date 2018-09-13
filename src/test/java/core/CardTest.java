package core;

import junit.framework.*;

public class CardTest extends TestCase {

	public void testEqual() {
		//Card A is a King of Hearts 
		Card cardA = new Card("KH");
		//Card B is a King of Spades
		Card cardB = new Card("KS");
		
		assertEquals(false, cardA.equals(cardB));
	}
	

}

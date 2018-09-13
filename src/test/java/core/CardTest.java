package core;

import junit.framework.*;

public class CardTest extends TestCase {

	public void testEqual() {
		//Card A is a King of Hearts 
		Card cardA = new Card("KH", 10);
		//Card B is a King of Spades
		Card cardB = new Card("KS", 10);
		//These two cards aren't not the same
		assertEquals(false, cardA.equals(cardB));
	}
	
	public void testValue() {
		//Card A is a King of Hearts 
		Card cardA = new Card("KH", 10);
		//A king should equate to 10
		assertEquals(10, cardA.value());
	}
	
	

}

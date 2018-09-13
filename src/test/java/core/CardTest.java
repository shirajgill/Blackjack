package core;

import junit.framework.*;

public class CardTest extends TestCase {

	public void testNotEqual() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEART, Ranks.KING);
		//Card B is a King of Spades
		Card cardB = new Card(Suits.SPADES, Ranks.KING);
		//These two cards aren't not the same
		assertEquals(false, cardA.equals(cardB));
	}
	
	public void testEqual() {
		//Card A is a 5 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.FIVE);
		//Card B is a 5 of Hearts
		Card cardB = new Card(Suits.HEARTS, Ranks.FIVE);
		//These two cards are the same
		assertEquals(true, cardA.equals(cardB));
	}
	
	
	public void testValue() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEART, Ranks.KING);
		//A king should equate to 10
		assertEquals(10, cardA.value());
	}

}

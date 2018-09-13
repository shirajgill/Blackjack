package core;

import blackjack.Card;
import blackjack.Ranks;
import blackjack.Suits;
import junit.framework.*;

public class CardTest extends TestCase {

	public void testNotEqual() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.KING);
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
	
	
	public void testValueKing() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.KING);
		//A king should equate to 10
		assertEquals(10, cardA.getValue());
	}

	public void testValueSeven() {
		//Card A is a 7 of clubs 
		Card cardA = new Card(Suits.CLUBS, Ranks.SEVEN);
		//A seven should equate to 7
		assertEquals(7, cardA.getValue());
	}
}

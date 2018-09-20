package core;

import blackjack.Card;
import blackjack.Ranks;
import blackjack.Suits;
import junit.framework.*;

public class CardTest extends TestCase {

	public void testNotEqual() throws Exception {
		//Card A is a 5 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.FIVE);
		//Card B is a King of Spades
		Card cardB = new Card(Suits.SPADES, Ranks.KING);
		//These two cards aren't not the same
		assertEquals(false, cardA.equals(cardB));
	}
	
	public void testRankEqual() throws Exception {
		//Card A is a 5 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.FIVE);
		//Card B is a 5 of Clubs
		Card cardB = new Card(Suits.CLUBS, Ranks.FIVE);
		//These two cards are the same
		assertEquals(true, cardA.rankEquals(cardB));
		//Card C is a 4 of Clubs
		Card cardC = new Card(Suits.CLUBS, Ranks.FOUR);
		//These Card A and Card C are not same
		assertEquals(false, cardA.rankEquals(cardC));
	}
	
	public void testCardCreateFromSymbol() throws Exception {
		//Symbols for the 7 of hearts 
		String suit = "H";
		String rank = "7";
		//Create the card with these two values 
		Card cardA = new Card(suit, rank);
		//Assert that both the suit and rank are HEARTS and SEVEN respectively
		assertEquals(Suits.HEARTS, cardA.getSuit());
		assertEquals(Ranks.SEVEN, cardA.getRank());
	}
	
	public void testValueKing() throws Exception {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.KING);
		//A king should equate to 10
		assertEquals(10, cardA.getValue());
	}

	public void testValueSeven() throws Exception{
		//Card A is a 7 of clubs 
		Card cardA = new Card(Suits.CLUBS, Ranks.SEVEN);
		//A seven should equate to 7
		assertEquals(7, cardA.getValue());
	}
}

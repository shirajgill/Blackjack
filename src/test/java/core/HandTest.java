package core;

import static org.junit.Assert.assertArrayEquals;

import blackjack.Card;
import blackjack.Ranks;
import blackjack.Suits;
import blackjack.Hand;
import junit.framework.*;

public class HandTest extends TestCase {

	public void testHandValue() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.KING);
		//Card B is a 8 of Spades
		Card cardB = new Card(Suits.SPADES, Ranks.EIGHT);
		
		//Construct the hand with these 2 cards
		Hand hand = new Hand(cardA, cardB);
		//These values should equate to 18
		assertEquals("The value of a face card and a numeric card", 18, hand.valueOfHand());
	}
	
	public void testIsBustTrue() {
		//Card A is a 10 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.TEN);
		//Card B is a 10 of Spades
		Card cardB = new Card(Suits.SPADES, Ranks.TEN);
	  //Card B is a 10 of Clubs
		Card cardC = new Card(Suits.CLUBS, Ranks.TEN);
		//Construct the hand with these 3 cards
		Hand hand = new Hand(cardA, cardB, cardC);
		//The value is over 21 so bust 
		assertEquals(true, hand.isBust());
	}
	
	
	public void testIsBustFalse() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.CLUBS, Ranks.QUEEN);
		//Construct the hand with A card
		Hand hand = new Hand(cardA);
	  //The value is under 21 so no bust
		assertEquals(false, hand.isBust());
	}
	
	public void testIsBlackjack() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.KING);
		//Card B is a 6 of Spades
		Card cardB = new Card(Suits.SPADES, Ranks.SIX);
		//Card C is a 5 of Clubs
		Card cardC = new Card(Suits.CLUBS, Ranks.FIVE);
		//Construct the hand with the 3 cards 
		Hand hand = new Hand(cardA, cardB, cardC);
		  
		//The hand equates to a 21 so it's a blackjack
		assertEquals(true, hand.isBlackjack());
	}
	
	public void testAddCardToHand() {
		//Card A is a King of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.KING);
		//Make the hand such that it has only 1 card
		Hand hand = new Hand(cardA);
		//Ensure the value is 10 which the kings's associated value 
		if (hand.valueOfHand() != 10) {
			//If it's not then fail the test 
			fail("Failed because the intitial value was not correct");
		}
		
		//Make a new card and add it to the hand
		//Card B is a 3 of Diamonds 
		Card cardB = new Card(Suits.DIAMONDS, Ranks.THREE);
		hand.add(cardB);	
		//The total value of the hand should be 13
		assertEquals(13, hand.valueOfHand());
	}
	
	public void testAceValues() {
		//Card A is a 7 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.SEVEN);
		//Card B is a Ace of Hearts 
		Card cardB = new Card(Suits.HEARTS, Ranks.ACE);
		//Make the hand such that it has 2 card
		Hand hand = new Hand(cardA, cardB);
		//Ensure the value is 18 since Ace in this case counts as 11 
		if (hand.valueOfHand() != 18) {
			//If it's not then fail the test 
			fail("Failed because the Ace value was not 11");
		}
		
		//Make a new card and add it to the hand
		//Card C is a 7 of Spades
		Card cardC = new Card(Suits.SPADES, Ranks.SEVEN);
		hand.add(cardC);	
		//The total value of the hand should now be 15 as the ace now counts as 1 
		assertEquals(15, hand.valueOfHand());
	}
	
	public void testCanSplit() {
		//Card A is a 7 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.SEVEN);
		//Card B is a 7 of Spades 
		Card cardB = new Card(Suits.SPADES, Ranks.SEVEN);
		//Make the hand such that it has 2 card
		Hand hand = new Hand(cardA, cardB);
		//Since this hand has 2 identical cards, we should be able to split
		assertEquals(true, hand.canSplit());
	}
	
	public void testSplit() {
		//Card A is a 7 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.SEVEN);
		//Card B is a 7 of Spades 
		Card cardB = new Card(Suits.SPADES, Ranks.SEVEN);
		//Make the hand such that it has 2 card
		Hand hand = new Hand(cardA, cardB);
		//The resulting hand should have 2 hands with card A and card B
		Hand[] resultingHands = {new Hand(cardA), new Hand(cardB)};
		//The returned array should be card A in one hand and Card B in the other
		assertArrayEquals(resultingHands, hand.split());
	}
	
	public void testCompareHands() {
		//Card A is a 7 of Hearts 
		Card cardA = new Card(Suits.HEARTS, Ranks.SEVEN);
		//Card B is a 7 of Spades 
		Card cardB = new Card(Suits.SPADES, Ranks.SEVEN);
		//Make the hand such that it has 2 card
		Hand handA = new Hand(cardA, cardB);
		
		//Card C is a Ace of Hearts 
		Card cardC = new Card(Suits.HEARTS, Ranks.SEVEN);
		//Card D is a 7 of Spades 
		Card cardD = new Card(Suits.SPADES, Ranks.SEVEN);
		//Make the hand such that it has 2 card
		Hand handB = new Hand(cardC, cardD);
		
		//Hand A = 14, Hand B = 18 so Hand B is better
		assertEquals("TRUE", true, handB.isBetterOrSameHand(handA));

		//Adding a 4 to hand A makes it also 18 so Hand A = B
		handA.add(new Card(Suits.CLUBS, Ranks.FOUR));
		//Hand A = 18, Hand B = 18 so Hand A is better or same
		assertEquals("TRUE",true, handA.isBetterOrSameHand(handB));
		
		//Adding a 4 to hand A makes it also 22 so Hand A is a bust
		handA.add(new Card(Suits.HEARTS, Ranks.FOUR));
		//Hand A = 22, Hand B = 18 so Hand A is bust so false
		assertEquals("TRUE",false, handA.isBetterOrSameHand(handB));
	}
	
	
	
}

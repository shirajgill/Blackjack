package core;

import blackjack.Card;
import blackjack.Dealer;
import junit.framework.*;

public class DealerTest extends TestCase {
	
	public void testSplit() throws Exception{
		//This splits the dealers hand in 2 hands 
		Dealer dealer = new Dealer(); 
		//Get the current hand for the dealer
		//Add 2 cards to that are the same 
		dealer.getCurrentHand().add(new Card("S","7"));
		dealer.getCurrentHand().add(new Card("C","7"));
		//Split the hands into 2 
		dealer.split();
		//Now the current hand should only have S7
		assertEquals("S7", dealer.getCurrentHand().toString());
	}
	
	public void testAddToHand()throws Exception {
		//This adds a card to the Dealers current hand
		Dealer dealer = new Dealer();
		//Get the current hand for the dealer
		//Add 2 cards to that are the same 
		dealer.getCurrentHand().add(new Card("S","7"));
		dealer.getCurrentHand().add(new Card("C","7"));
		//Split the hands into 2 
		dealer.split();
		//Now the current hand should only have S7 and adding king should give the value of the hand to 17
		dealer.addToHand(new Card("C","K"));
		assertEquals(17, dealer.getCurrentHand().valueOfHand());
		
	}
	
	public void testGetBestHand()throws Exception {
		//This gets the best hand
		Dealer dealer = new Dealer();
		//Get the current hand for the dealer
		//Add 2 cards to that are the same 
		dealer.getCurrentHand().add(new Card("S","7"));
		dealer.getCurrentHand().add(new Card("C","7"));
		//Dealer best hand currently is the hand with just S7, C7 
		//Now the current hand should only have S7 and c7
		assertEquals("S7, C7", dealer.getBestHand().toString());
		//The case for a valid second hand is handled by the function: testCompareHands() in HandTest 
	}
	
	public void testHandPrint()throws Exception {
		Dealer dealer = new Dealer();
		//Get the current hand for the player
		//Add 2 cards to that are the same 
		dealer.getCurrentHand().add(new Card("S","7"));
		dealer.getCurrentHand().add(new Card("C","7"));
		//Dealer's hand currently is the hand with just S7, C7 
		//Now the current hand should only have S7
		assertEquals("Dealer: S7, C7", dealer.printHand(false));
		//If we try to print with the dealer's hand but pass true that means hide the first card
		assertEquals("Dealer: XX, C7", dealer.printHand(true));
	}
	
	public void testShouldDealerHit() throws Exception{
		Dealer dealer = new Dealer();
		//Add 2 cards to that are the same 
		dealer.getCurrentHand().add(new Card("S","4"));
		dealer.getCurrentHand().add(new Card("C","2"));
		//The dealer hand is only 6 so it should hit 
		assertEquals(true, dealer.shouldDealerHit());
		//Add an an ace so that total value is 17 with an Ace so soft 17
		dealer.getCurrentHand().add(new Card("C","A"));
		//Since the hand is still a soft 17 it should still hit 
		assertEquals(true, dealer.shouldDealerHit());
		//Add a 2 
		dealer.getCurrentHand().add(new Card("S","2"));
		//Since the hand is 19 it should NOT hit 
		assertEquals(false, dealer.shouldDealerHit());
	}
	
	public void testShouldDealerSplit() throws Exception{
		Dealer dealer = new Dealer();
		//Add 2 cards to that are the same 
		dealer.getCurrentHand().add(new Card("S","7"));
		dealer.getCurrentHand().add(new Card("C","7"));
		//The dealer hand is only 14 so it should split  
		assertEquals(true, dealer.shouldDealerSplit());
		//Make a second dealer to test for not splitting
		Dealer dealer2 = new Dealer();
		//Add 2 cards to that are the same 
		dealer2.getCurrentHand().add(new Card("S","9"));
		dealer2.getCurrentHand().add(new Card("C","9"));
		//The dealer hand is 18 so it should not split 
		assertEquals(false, dealer2.shouldDealerSplit());
	}
}
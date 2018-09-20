package core;

import blackjack.Card;
import blackjack.Player;
import junit.framework.*;

public class PlayerTest extends TestCase {
	
	public void testSplit() throws Exception {
		//This splits the players hand in 2 hands 
		Player player = new Player();
		//Get the current hand for the player
		//Add 2 cards to that are the same  
		player.getCurrentHand().add(new Card("S","7"));
		player.getCurrentHand().add(new Card("C","7"));
		//Split the hands into 2 
		player.split();
		//Now the current hand should only have S7
		assertEquals("S7", player.getCurrentHand().toString());
	}
	
	public void testAddToHand()throws Exception {
		//This adds a card to the player's current hand
		Player player = new Player();
		//Get the current hand for the player
		//Add 2 cards to that are the same 
		player.getCurrentHand().add(new Card("S","7"));
		player.getCurrentHand().add(new Card("C","7"));
		//Split the hands into 2 
		player.split();
		//Now the current hand should only have S7 and adding king should give the value of the hand to 17
		player.addToHand(new Card("C","K"));
		assertEquals(17, player.getCurrentHand().valueOfHand());
		
	}
	
	public void testGetBestHand() throws Exception {
		//This gets the best hand
		Player player = new Player();
		//Get the current hand for the player
		//Add 2 cards to that are the same 
		player.getCurrentHand().add(new Card("S","7"));
		player.getCurrentHand().add(new Card("C","7"));
		//Player best hand currently is the hand with just S7, C7 
		//Now the current hand should only have S7 and c7
		assertEquals("S7, C7", player.getBestHand().toString());
		//The case for a valid second hand is handled by the function: testCompareHands() in HandTest 
	}
	
	public void testHandPrint() throws Exception {
		//This gets the best hand
		Player player = new Player();
		//Get the current hand for the player
		//Add 2 cards to that are the same 
		player.getCurrentHand().add(new Card("S","7"));
		player.getCurrentHand().add(new Card("C","7"));
		//Player best hand currently is the hand with just S7, C7 
		//Now the current hand should print the expected value
		assertEquals("Player: S7, C7", player.printHand());
	}
}
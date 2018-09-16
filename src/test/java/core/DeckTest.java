package core;

import static org.junit.Assert.assertArrayEquals;

import blackjack.Card;
import blackjack.Ranks;
import blackjack.Suits;
import junit.framework.*;

public class HandTest extends TestCase {

	public void testDeckCreation() {
		//Create new deck
		Deck deck = new Deck();
		//Make an array of 52 cards 
		String[] cards = new String[52];
		
		int index = 0;
		//For every suit
		for (Suits suit : Suits.values()) {
			//For every rank
			for (Ranks rank : Ranks.values()) {
				//Add a new card as the symbol representation to the array of cards
				cards[index] = suit.getSymbol() + rank.getSymbol();
				index++;
			}
		}
		
		//Get the top card of the deck 52 times 
		for (int i = 0; i < 52; i++) {
			boolean cardFound = false;
			//Loop over the card symbols
			for (String card : cards) {
				//IF the card is in our deck remove it from our deck by making it empty string
				if (card == deck.drawTopCard().toString()) {
					card = "";
					cardFound = true;
				} 
			}
			//IF the card was not found once 
			if (!cardFound) {
				fail("Card not found or duplicate card in deck");
			}
		}
	}
	
	public void testDeckShuffle() {
		int gotNewCard = 0;
		//For 100 loops		
		for (int i = 0; i < 100; i++) {
			//Create new deck
			Deck deck = new Deck();
			//Get the top card (not draw) and compare it after the deck is shuffled to ensure the card is different  
			Card card = deck.getTopCard();
			deck.shuffle();
			if (deck.getTopCard() != card) {
				gotNewCard++;
			}
		}
		//IF the deck failed to get a new card 80 times out of the 100, fail this test 
		if (gotNewCard < 80) {
			fail("Failed to get new cards 80 times");
		}
	}
	
}

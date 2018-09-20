package core;

import blackjack.Card;
import blackjack.Ranks;
import blackjack.Deck;
import blackjack.Suits;
import junit.framework.*;

public class DeckTest extends TestCase {

	public void testDeckCreation()throws Exception {
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
			String cardFromDeck = deck.drawFromTop().toString();
			//Loop over the card symbols
			for (String card : cards) {
				//IF the card is in our deck remove it from our deck by making it empty string
				if (card.equals(cardFromDeck)) {
					card = "";
					cardFound = true;
					break;
				} 
			}
			//IF the card was not found once 
			if (!cardFound) {
				fail("Card not found or duplicate card in deck");
			}
		}
	}
	
	public void testDeckShuffle() throws Exception{
		int gotNewCard = 0;
		//For 100 loops		
		for (int i = 0; i < 100; i++) {
			//Create new deck
			Deck deck = new Deck();
			//Get the top card (not draw) and compare it after the deck is shuffled to ensure the card is different  
			Card card = deck.getFromTop();
			deck.shuffle();
			if (deck.getFromTop() != card) {
				gotNewCard++;
			}
		}
		//IF the deck failed to get a new card 80 times out of the 100, fail this test 
		if (gotNewCard < 80) {
			fail("Failed to get new cards 80 times");
		}
	}
	
	public void testDeckHaveCard() throws Exception{ 
		Deck deck = new Deck();
		//Get the card from the top 
		Card cardOnTop = deck.getFromTop();
		//Currently the card is in the deck
		assertEquals(true, deck.isCardInDeck(cardOnTop));
		//Draw the card from the top so we remove it 
		Card cardFromDeck = deck.drawFromTop();
		//Now that the card is removed we should get back false
		assertEquals(false, deck.isCardInDeck(cardFromDeck));
	}
	
	public void testRemoveCard()throws Exception {
		Deck deck = new Deck();
		//Check if the Ace of clubs is in the deck
		assertEquals(true, deck.isCardInDeck(new Card("C", "A")));
		//Now remove it 
		deck.removeCard(new Card("C", "A"));
		//Now that the card is removed we should get back false
		assertEquals(false, deck.isCardInDeck(new Card("C", "A")));
	}
	
}

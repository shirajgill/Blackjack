package blackjack;

import java.util.ArrayList;
import java.util.Collections;

import blackjack.Card;


public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		//For every suit
		for (Suits suit : Suits.values()) {
			//For every rank
			for (Ranks rank : Ranks.values()) {
				//Add this card to the list of cards
				this.cards.add(new Card(suit, rank));
			}
		}
	}
	
	public Card drawFromTop() {
		//Remove and return the first card (ie from the top)
		return this.cards.remove(0);
	}
	
	public Card getFromTop() {
		//Return the first card (ie from the top)
		return this.cards.get(0);
	}

	public void shuffle() {
		//Shuffle the deck
		Collections.shuffle(this.cards);
	}
}
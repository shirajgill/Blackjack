package blackjack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import blackjack.Card;

public class Hand {
	//Blackjack value indicating a winning a hand  
	static final int BLACKJACK = 21;
	//The max value is 11   
	static final int ACE_MAX = 11;
	//The min value is 1   
	static final int ACE_MIN = 1;
	
	//The cards the hand has 
	private Deque<Card> cards = new ArrayDeque<Card>();

	//Constructor 
	public Hand(Card...cards) {
		//Loop over all the cards cards that are passed as arguments 
		for (Card card: cards) {
			//Add them to the cards in the hand
			this.cards.add(card);
		}
		//Once all cards have been added, we can modify the Ace card's value if it needs to be changed
		this.modifyAce();
	}
	 
	private boolean modifyAce() {
		//Track if Aces have been modified 
		boolean modifyAce = false;

		//Loop through all cards 
		for (Card card : this.cards) {		
      //If this card is an ace then
			if (card.getRank() == Ranks.ACE) {
				//Check if the value of the ace is it's minimum value and the hand is not bust hand
				if (card.getValue() == ACE_MIN) {
					//If it is try seeing if the value of the hand plus the difference 
					//of the min and max value of the ace put it to <= to BLACKJACK
					//If this is true then we can make the ace to 11
					if ((this.valueOfHand() +  (ACE_MAX - ACE_MIN)) <= BLACKJACK) {
						card.setValue(ACE_MAX);
						//The ace was modified so set it to be true 
						modifyAce = true;
					}
				} 
				//Otherwise if the value of the ace is the maximum value and the hand is a bust 
				else if (card.getValue() == ACE_MAX && this.valueOfHand() > BLACKJACK) {
					//Set the value of ace to it's lowest hand
					card.setValue(ACE_MIN);
					//The ace was modified so set it to be true 
					modifyAce = true;
				}
      }
    }
		
		//Return if the ace was modified
		return modifyAce;
	}

	public int valueOfHand() {
		
		int valueOfHand = 0;
		//Loop through all cards 
		for (Card card : this.cards) {
			valueOfHand += card.getValue();
		}
		
		return valueOfHand;
	}

	public boolean isBust() {
		//Modify the ace before checking value
		this.modifyAce(); 
		//Return if the value of the hand is over BLACKJACK
		return this.valueOfHand() > BLACKJACK;
	}

	public boolean isBlackjack() {
		//Modify the ace before checking value
		this.modifyAce();
		//Return if the value of the hand is equal to BLACKJACK
		return this.valueOfHand() == BLACKJACK;
	}

	public void add(Card card) {
		//Add the card to the hand 
		this.cards.add(card);
		//Once all cards have been added, we can modify the Ace card's value if it needs to be changed
		this.modifyAce();
	}

	public boolean canSplit() {
		//Split is only when hand has 2 identical cards
		if (this.cards.size() == 2) {
			//Compare the first and second cards 
			//If they're the same card return true 
			if (this.cards.getFirst().rankEquals(this.cards.getLast())) {
				return true;
			}
		}
		return false;
	}

	public Hand[] split() {
		//Assumes this hand can be split 
		//Return the hand with the first and second card in this hand
		return new Hand[] {new Hand(this.cards.getFirst()), new Hand(this.cards.getLast())};
	}

	public boolean isBetterOrSameHand(Hand hand) {
		//Modify the ace before checking value
		this.modifyAce();
		//If the this hand is blackjack return true 
		if (this.isBlackjack()) {
			return true;
		}
		
		//If the other hand is a bust return true 
		if (hand.isBust()) {
			return true;
		}
		
		//If this hand is a bust return false
		if (this.isBust()) {
			return false;
		}
		
		//If this hand is higher or the same then return true
		if (this.valueOfHand() >= hand.valueOfHand()) {
			return true;
		}
		
		return false;
	}
	
	public Deque<Card> getCards() {
		return this.cards;
	}
	
	public String toString() {
		
		String cardsString = "";
		//Loop through all cards 
    Iterator<Card> it = this.cards.iterator();
		while (it.hasNext()) {
			cardsString += it.next().toString();
			//Add the "," only if there's another item
			if (it.hasNext()) {
				cardsString += ", ";
			}
		}
		return cardsString;
	}
}
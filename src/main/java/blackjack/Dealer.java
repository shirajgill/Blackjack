package blackjack;

import java.util.ArrayList;
import blackjack.Hand;

public class Dealer {
 
	//Used to point at which index the current hand is 
	private int currentHand;
 
	private ArrayList<Hand> hands = new ArrayList<Hand>();
 
	public Dealer() {
		this.currentHand = 0;
		//Add a new empty hand to the hands
		this.hands.add(new Hand());
	}
	
	public Hand getCurrentHand() {
		//Return the current hand 
		return hands.get(this.currentHand);
	}
	
	public Hand getBestHand() {
		//If there's only 1 hand return it 
		if (this.hands.size() == 1) {
			return this.getCurrentHand();
		}
		
		//return the best hand either hand at 0 or hand at 1 
		if (this.hands.get(0).isBetterOrSameHand(this.hands.get(1))) {
			return this.hands.get(0);
		} else {
			return this.hands.get(1);
		}
	}
	
	public void split() {
		Hand[] hands = this.getCurrentHand().split();
		this.hands.set(0, hands[0]);
		this.hands.add(hands[0]);
	}
	
	public void switchCurrentHand() {
		this.currentHand = (this.currentHand == 0) ? 1 : 0;
	}
	
	public boolean canSplit() {
		return this.getCurrentHand().canSplit();
	}

	public void addToHand(Card card) {
		this.getCurrentHand().add(card);
	}

	public String printHand(boolean hideFirstCard) {
		String handString = this.getCurrentHand().toString();
		//If we're not showing the first card
		if (hideFirstCard) {
			//replace the first 2 characters with XX 
			 handString = "XX" + handString.substring(2); 
		}
		
		return "Dealer: " + handString;
	}

	public boolean shouldDealerHit() {
		//Get value of hand 
		int valueOfHand = this.getCurrentHand().valueOfHand();
	  //Flag for if ace is present
		boolean hasAce = false;
		//Loop over all the cards cards that are in current hand  
		for (Card card: this.getCurrentHand().getCards()) {
			//Add them to the cards in the hand
			if (card.getRank() == Ranks.ACE) {
				hasAce = true;
			}
		}
		//Return true if value is less or equal the 16 or if ace is present and value is 17 
		return (valueOfHand <= 16 || (hasAce && valueOfHand == 17));
	}

	public boolean shouldDealerSplit() {
		//Return true if value is less or equal to 17 and if dealer can split
		return this.canSplit() && this.getCurrentHand().valueOfHand() <= 17;
	}	
	
	public int getHandCount( ) {
		return this.hands.size();
	}
}

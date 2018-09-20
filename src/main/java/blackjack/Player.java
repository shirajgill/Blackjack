package blackjack;

import java.util.ArrayList;
import blackjack.Hand;

public class Player {
 
	//Used to point at which index the current hand is 
	private int currentHand;
 
	private ArrayList<Hand> hands = new ArrayList<Hand>();
 
	public Player() {
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
		this.hands.add(hands[1]);
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
	
	public String printHand() {
		String handString = this.getCurrentHand().toString();
		return "Player: " + handString;
	}
	
	public int getHandCount( ) {
		return this.hands.size();
	}
}

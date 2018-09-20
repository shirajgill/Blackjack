package blackjack;

import blackjack.Deck;

import java.util.Scanner;

import blackjack.Dealer;
import blackjack.Player;

public class Blackjack {
	private Deck deck;
	public Player player;
	public Dealer dealer;

	public Blackjack() throws Exception {
		
		this.deck = new Deck();
		this.player = new Player();
		this.dealer = new Dealer();
		//Get Initial cards for dealer and player
		this.getCards();
	}

	private void getCards() throws Exception {
		//For player 2 cards 
		this.hitPlayer(this.deck.drawFromTop());
		this.hitPlayer(this.deck.drawFromTop());
		//Get 2 cards for Dealer
		this.hitDealer(this.deck.drawFromTop());
		this.hitDealer(this.deck.drawFromTop());
	}


	public void play() throws Exception {
		 System.out.println(this.player.printHand());
		 System.out.println(this.dealer.printHand(true)); 
		
		int playerHandPlayed = 0;
		 Scanner sc = new Scanner(System.in);
     String command;
		//Player is first 
		while (!((command = sc.nextLine().toUpperCase()).equals("S") 
					|| !this.player.getCurrentHand().isBust())
	        ||  this.player.getHandCount() > playerHandPlayed && !this.player.getBestHand().isBlackjack()) {
			if (command.equals("H")) {
				hitPlayer(this.deck.drawFromTop());
			} else if (command.equals("D")) {
				this.player.split();
				hitPlayer(this.deck.drawFromTop());
			}
			else if (command.equals("S") || this.player.getCurrentHand().isBust()) {
				if (this.player.getHandCount() == 2 && playerHandPlayed == 0) {
					this.player.switchCurrentHand();
					hitPlayer(this.deck.drawFromTop());
				} else {
					break;
				}
				
				playerHandPlayed++;
			}
			else {
				throw new Exception("Incorrect Command Used");
			}
			 System.out.println(this.player.printHand());

		}
		 System.out.println(this.player.printHand());

		boolean playerBust;
		if (!player.getBestHand().isBust()) {
		 playerBust = false;
			int dealerHand = 0;
			//Player is first 
			while (this.dealer.shouldDealerHit() || this.dealer.shouldDealerSplit() 
					|| this.dealer.getHandCount() > dealerHand) {
				if (this.dealer.shouldDealerSplit()) {
					this.dealer.split();
				} else if (this.dealer.shouldDealerHit()) {
					hitDealer(this.deck.drawFromTop());
				} else {
					if (this.dealer.getHandCount() == 2) {
						this.dealer.switchCurrentHand();
					}
					dealerHand++;
				}
			}		
		} else {
		 playerBust = true;
		}
		
		//Once it's done print out the winner 
		if (!playerBust && this.getWinner() =="p") {
		 System.out.println("(Winner) " + this.player.printHand() + "[" + this.player.getBestHand().valueOfHand() + "]");
		 System.out.println(" " + this.dealer.printHand(false) + "[" + this.dealer.getBestHand().valueOfHand() + "]");
		} else {
				System.out.println("" + this.player.printHand() + "[" + this.player.getBestHand().valueOfHand() + "]");
			 System.out.println("(Winner) " + this.dealer.printHand(false) + "[" + this.dealer.getBestHand().valueOfHand() + "]");
			}
	}
	

	public String getWinner() {
		return this.dealer.getBestHand().isBetterOrSameHand(this.player.getBestHand()) ? "d" : "p";
	}


	public void hitDealer(Card card) throws Exception {
		this.dealer.addToHand(card);
	}
	
	public void hitPlayer(Card card) throws Exception {
		this.player.addToHand(card);
	}
}

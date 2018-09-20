package blackjack;

import blackjack.Deck;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import blackjack.Dealer;
import blackjack.Player;

public class FileInput {
	private Deck deck;
	public Player player;
	public Dealer dealer;
	
	private ArrayList<String> commandsFromFile = new ArrayList<String>();

	public FileInput(String fileName) throws Exception {
		//System.out.println(("src/main/java/blackjack/files/" + fileName));
		//System.out.println(new File("src/main/java/blackjack/files/" + fileName).isFile());
		getCommandsFromFile("src/main/java/blackjack/files/" + fileName);
		this.deck = new Deck();
		this.player = new Player();
		this.dealer = new Dealer();
		this.getCards();
	}

	private void getCards() throws Exception {
		//For player 2 cards 
		String [] card = this.splitCard(this.commandsFromFile.remove(0)); 
		this.hitPlayer(new Card(card[0], card[1]));
		
		card = this.splitCard(this.commandsFromFile.remove(0)); 
		this.hitPlayer(new Card(card[0], card[1]));
		
		//For dealer 2 cards 
		card = this.splitCard(this.commandsFromFile.remove(0)); 
		this.hitDealer(new Card(card[0], card[1]));
		
		card = this.splitCard(this.commandsFromFile.remove(0)); 
		this.hitDealer(new Card(card[0], card[1]));
	}

	private void getCommandsFromFile(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			this.commandsFromFile = new ArrayList<String>(Arrays.asList(reader.readLine().split(" ")));
			reader.close();
		} catch (Exception e) {
			System.out.println("File could not be read");
			return;
		}
	}
	
	private String[] splitCard(String string) {
		return new String[] {string.substring(0, 1), string.substring(1)};
	}

	public void play() throws Exception {
		 System.out.println(this.player.printHand());
		 System.out.println(this.dealer.printHand(true)); 
		
		String command;
		int playerHandPlayed = 0;
		//Player is first 
		while (!((command = this.commandsFromFile.get(0).toUpperCase()).equals("S") 
					|| !this.player.getCurrentHand().isBust())
	        ||  this.player.getHandCount() > playerHandPlayed) {
			//System.out
			if (command.equals("H")) {
				this.commandsFromFile.remove(0);
				String[] card = this.splitCard(this.commandsFromFile.remove(0)); 
				hitPlayer(new Card(card[0], card[1]));
				
			} else if (command.equals("D")) {
				this.commandsFromFile.remove(0);
				this.player.split();
				String[] card = this.splitCard(this.commandsFromFile.remove(0)); 
				hitPlayer(new Card(card[0], card[1]));
			}
			else if (command.equals("S") || this.player.getCurrentHand().isBust()) {
				this.commandsFromFile.remove(0);
				if (this.player.getHandCount() == 2 && playerHandPlayed == 0) {
					this.player.switchCurrentHand();
					String[] card = this.splitCard(this.commandsFromFile.remove(0)); 
					hitPlayer(new Card(card[0], card[1]));
				}
				
				playerHandPlayed++;
			}
			else {
				throw new Exception("Incorrect Command Used");
			}
			
			if (this.commandsFromFile.size() == 0) {
				break;
				
			}
		}
		System.out.println("" + this.player.printHand());
	
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
					String[] card = this.splitCard(this.commandsFromFile.remove(0)); 
					hitDealer(new Card(card[0], card[1]));
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
		if (!this.deck.isCardInDeck(card)) {
			throw new Exception("Card Already Used");
		}
		this.deck.removeCard(card);
		this.dealer.addToHand(card);
	}
	
	public void hitPlayer(Card card) throws Exception {
		//System.out.println("F");
		if (!this.deck.isCardInDeck(card)) {
			throw new Exception("Card Already Used");
		}
		
		this.deck.removeCard(card);
		this.player.addToHand(card);
	}
}

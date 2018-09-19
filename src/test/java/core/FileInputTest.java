package core;

import blackjack.Card;
import blackjack.Dealer;
import blackjack.Player;
import junit.framework.*;

public class FileInputTest extends TestCase {
	
	public void testFileInititalCards() {
		//Test the initial cards being dealt to the player and dealer 
		//New fileGame with the textInput.txt file as the to read file
		FileInput fileGame = new FileInput("testInput.txt");
		//The testInput.txt has S10 D3 SQ C5 as the cards to deal to the different people
		//At this point the cards should've been read so we will test the dealer and players hand 
		//Now the player's hand should be S10, CA
		assertEquals("S10, CA", fileGame.player.getCurrentHand().toString());
		//Now the dealer's hand should be SQ, C5  
		assertEquals("SQ, C5", fileGame.dealer.getCurrentHand().toString());
		//While we're testing this, let's also test if the cards player print both the cards 
		assertEquals("Player: S10, CA", fileGame.player.printHand());
		//Ensure that only 1 of the dealer's card is shown
		assertEquals("Dealer: XX, CA", fileGame.dealer.printHand());
	}
	
	public void testInitialWin() {
		//Test the initial cards being dealt to the player and dealer 
		//New fileGame with the textInput.txt file as the to read file
		FileInput fileGame = new FileInput("testInput.txt");
		//The testInput.txt has S10 D3 SQ C5 as the cards to deal to the different people
		//Dealer has no win but the player does so it should return "p" 
		assertEquals("p", fileGame.getWinner());
		//We will hit the dealer with 6 so that he gets a win
		fileGame.hit(fileGame.dealer, new Card("S", "6"));
		//Now we get the dealer as the winner
		assertEquals("d", fileGame.getWinner());
		//We'll also test the values of the cards at the end of the game...they should both be 21
		assertEquals(21, fileGame.player.getBestHand().getValueOfHand());
		assertEquals(21, fileGame.dealer.getBestHand().getValueOfHand());
	}
	
	public void testFilePlay() {
		//This should test all the private functions within the fileGame
		FileInput fileGame = new FileInput("testInput.txt");
		//The file has S10 D3 SQ C5 H H5 H SA S CA D2
		fileGame.play();
		//The winner of this game should be the "p"
		assertEquals("p", fileGame.getWinner());
	}
	
	public void testIncorrectInputs() {
		//This should test the incorrect command
		FileInput fileGame = new FileInput("incorrectCommand.txt");
		try {
			//The file has S10 D3 SQ C5 T H5 H SA S CA D2
			fileGame.play();
			fail("Game played perfectly so fail");
		} catch (Exception ex) {
			//We should end up here so we pass
		}
	}
	
	public void testIncorrectCard() {
		//This should test the incorrect card (incorrect suit/rank)
		FileInput fileGame = new FileInput("incorrectCard.txt");
		try {
			//The file has Q10 D3 SQ C5 T H5 H SA S CA D2
			fileGame.play();
			fail("Game played perfectly so fail");
		} catch (Exception ex) {
			//We should end up here so we pass
		}
	}
	
	public void testCardAlreadyUsed() {
		//This should test the card already played
		FileInput fileGame = new FileInput("cardAlreadyPlayed.txt");
		try {
			//The file has S10 S10 SQ C5 T H5 H SA S CA D2
			fileGame.play();
			fail("Game played perfectly so fail");
		} catch (Exception ex) {
			//We should end up here so we pass
		}
	}
}
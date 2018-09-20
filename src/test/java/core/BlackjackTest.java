package core;


import blackjack.Blackjack;
import blackjack.Card;
import junit.framework.*;

public class BlackjackTest extends TestCase {
	
 //We can test if the game starts up but everything after that is just I/o so can't test
	public void testPlay() {
		try {
		Blackjack blackjack = new Blackjack();
		}  catch (Exception ex) {
		 fail(ex.getMessage());
		}
	} 
	
public void testPlayerBust() {
	try {
	Blackjack blackjack = new Blackjack();
	//Hit player with 3 queens so that they bust 
	blackjack.hitPlayer(new Card("S", "Q"));
	blackjack.hitPlayer(new Card("C", "Q"));
	blackjack.hitPlayer(new Card("H", "Q"));
	assertEquals("d", blackjack.getWinner());
	}  catch (Exception ex) {
	 fail(ex.getMessage());
	}
} 

public void testDealerBust() {
	try {
	Blackjack blackjack = new Blackjack();
	//Hit dealer with 3 queens so that they bust 
	blackjack.hitDealer(new Card("S", "Q"));
	blackjack.hitDealer(new Card("C", "Q"));
	blackjack.hitDealer(new Card("H", "Q"));
	assertEquals("p", blackjack.getWinner());
	}  catch (Exception ex) {
	 fail(ex.getMessage());
	}
} 
	
	
}
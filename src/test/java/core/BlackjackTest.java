package core;

import blackjack.Card;
import blackjack.Dealer;
import blackjack.Player;
import blackjack.FileInput;
import junit.framework.*;

public class BlackjackTest extends TestCase {
	
 //We can test if the game starts up but everything after that is just I/o so can't test
	public void testPlay() {
		try {
		Blackjack blackjack = new Blackjack();
		blackjack.play();
		}  catch (Exception ex) {
		 fail(ex.getMessage());
		}
	} 
	
	
}
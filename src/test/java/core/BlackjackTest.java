package core;


import blackjack.Blackjack;
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
	
	
}
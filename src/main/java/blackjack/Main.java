package blackjack;

import blackjack.FileInput;

import java.util.Scanner;

import blackjack.Blackjack;

public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Select c for console and f for file");
		 String command = sc.nextLine();
		 try {
			 if (command.toLowerCase().equals("c")) {
				Blackjack game = new Blackjack();
				game.play();
			 } else if (command.toLowerCase().equals("f")) {
				 FileInput fileGame;
				
					fileGame = new FileInput("testSplit.txt");
					fileGame.play();
			 }
			} catch (Exception e) {
				System.out.println("Unable to start the game");
				e.printStackTrace();
			}
			 
	}

}

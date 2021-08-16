package com.skilldistillery.app;


import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	

	public static void main(String[] args) {
		BlackjackApp twentyone = new BlackjackApp();
		twentyone.run();
		
	
	}



	public void run () {
		Scanner sc = new Scanner(System.in);
		String playerName = "";
		int deckAmount = 1;
		String shuffleDeck = "";
		
		System.out.println("🂡Welcome to the SD30 Blackjack table!🂾");
		System.out.println("What is your name?");
		playerName = sc.nextLine();
		System.out.println("How many decks would you like to play with?");
		deckAmount = sc.nextInt();
//		System.out.println("Would you like to shuffle the deck prior to playing? Y/N");
//		shuffleDeck = sc.nextLine();
//		
//		if(shuffleDeck == "Y") {
//			return true;
//		}
		
		Deck decks = new Deck(deckAmount, true);
		
		Player player = new Player(playerName);
		Dealer dealer = new Dealer("Dealer");
		
		player.addCard(decks.dealCard());
		dealer.addCard(decks.dealCard());
		player.addCard(decks.dealCard());
		dealer.addCard(decks.dealCard());
		
		System.out.println("Cards are dealt");
		player.printHand(true);
		dealer.printHand(false);
		System.out.println("\n\n");
		
		boolean playerStand = false;
		boolean dealerStand = false;
		String choice;
		
		while (!playerStand || !dealerStand) {
			if (!playerStand) {
				System.out.println("(H)it or (S)tand? ");
				choice = sc.next();
				System.out.println();
				
				if(choice.equalsIgnoreCase("H")) {
					playerStand = !player.addCard(decks.dealCard());
					player.printHand(true);
				} else {
					playerStand = true;
				}
			} 
			
			if (!dealerStand) {
				if (dealer.addCard() < 17) {
					System.out.println("The Dealer hits\n");
					dealerStand = !dealer.addCard(decks.dealCard());
					dealer.printHand(false);
				} else {
					dealerStand = true;
				}
			}
			
			System.out.println();
		}
		
		sc.close();
		//need a dealerSt
		//need a player
		//rules of the game
		player.printHand(true);
		dealer.printHand(true);
		
		//int playerValue =  ;
		//int dealerValue = ;
		
//		if ((playerValue > dealerValue && playerValue <= 21) || dealerValue>21) {
//			System.out.println("Winner!");
//		} else {
//			System.out.println("You busted! Dealer wins!");
//		}
	}
	
	
	
	
	
}

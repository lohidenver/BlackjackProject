package com.skilldistillery.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp jackBlack = new BlackjackApp();
		jackBlack.run();
	}


	public void run () {
		Scanner sc = new Scanner(System.in);
		String playerName = "";
				
		System.out.println("🂡Welcome to the SD30 Blackjack table!🂾");
		System.out.println("What is your name?");
		playerName = sc.nextLine();
		

		
		Deck playingDeck = new Deck();
		playingDeck.fullDeck();
		playingDeck.shuffle();
		//System.out.println(playingDeck);
		
		Deck playerD = new Deck();
		Deck dealerD = new Deck();
		
		double betMoney = 20.00;
		//Scanner sc = new Scanner(System.in);
		
		while(betMoney > 0) {
			System.out.println(playerName + ", you have $" + betMoney + 
					", what's your wager?");
			double playerBet = sc.nextDouble();
			if(playerBet>betMoney) {
				System.out.println("You think you can take advantage of me?");
				System.out.println("You can't bet more than you have.");
				System.out.println("My good friend Knuckles will escort you out.");
				break;
			}
			
			playerD.draw(playingDeck);
			playerD.draw(playingDeck);
			dealerD.draw(playingDeck);
			dealerD.draw(playingDeck);
			
			boolean roundOver = false;
			
			while(true) {
				System.out.println(playerName + "'s hand: ");
				System.out.print(playerD.toString());
				System.out.println(playerName + "'s deck is valued at: " + playerD.cardsValue());
				
				System.out.println("Dealer's hand: [hidden] + " + dealerD.getCard(0).toString());
			
				System.out.println("What would you like to do?\n1. Hit\n2. Stand");
				int choice = sc.nextInt();
				if(choice==1) {
					playerD.draw(playingDeck);
					System.out.println(playerName + " drew a " + 
					playerD.getCard(playerD.checkDeckSize()-1).toString());
					if (playerD.cardsValue() > 21) {
						System.out.println("You busted. You went " + (playerD.cardsValue()-21) 
								+ " over" );
						betMoney -= playerBet;
						roundOver=true;
						break;
					}
				}
				
				if (choice == 2) {
					break;
				}
			}
			
			System.out.println("Dealer Cards: " + dealerD.toString());
			
			if ((dealerD.cardsValue()>=17) &&  (dealerD.cardsValue()>playerD.cardsValue() && roundOver == false)) {
				System.out.println("Dealer wins.");
				betMoney -= playerBet;
				roundOver=true;
			}
			
			while (dealerD.cardsValue()<17 && roundOver ==false) {
				dealerD.draw(playingDeck);
				System.out.println("Dealer Draws: " + 
				dealerD.getCard(dealerD.checkDeckSize()-1).toString());
			}
			
			System.out.println("Dealer has " + dealerD.cardsValue());
			if((dealerD.cardsValue()>21) && roundOver == false) {
				System.out.println("Dealer busts! " + playerName + " wins!");
				betMoney += playerBet;
				roundOver =true;
			}
			
			if((playerD.cardsValue() == dealerD.cardsValue()) && roundOver == false) {
				System.out.println("Push");
				roundOver = true;
			}
			
			if ((playerD.cardsValue()>dealerD.cardsValue())&& roundOver == false ) {
				System.out.println(playerName + " wins!");
				betMoney += playerBet;
				roundOver = true;
			} else if (roundOver == false) {
				System.out.println("Dealer wins.");
				betMoney -= playerBet;
				roundOver=true;
			}
			
			
			playerD.moveAll(playingDeck);
			dealerD.moveAll(playingDeck);
			
			System.out.println("End of hand");
		}
		
		System.out.println("You are broke! Maybe you can sell a kidney?");
	}		

	
}//endBlackjackApp

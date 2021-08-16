package com.skilldistillery.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Deck;

public class GameLoop {

	public void gameLoop() {
		Scanner sc = new Scanner(System.in);
		String playerName = "";
				
		System.out.println(" 🂠 🂠 🂡 🂮 🂭 🂫 🂪 🂩 🂨 🂧 🂦 🂥 🂤 🂣 🂢 🂠 🂠");
		System.out.println("🃁Welcome to the SD30 Blackjack table!🃑");
		System.out.println(" 🂠 🂠 🂱 🂾 🂽 🂻 🂺 🂹 🂸 🂷 🂶 🂵 🂴 🂳 🂲 🂠 🂠\n\n");
		System.out.println("What is your name?");
		playerName = sc.nextLine();
		
		Deck playingDeck = new Deck();
		playingDeck.fullDeck();
		playingDeck.shuffle();
		//System.out.println(playingDeck);
		
		Deck playerHand = new Deck();
		Deck dealerHand = new Deck();
		
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
			
			playerHand.draw(playingDeck);
			playerHand.draw(playingDeck);
			dealerHand.draw(playingDeck);
			dealerHand.draw(playingDeck);
			
			boolean roundOver = false;
			
		while(true) {
			System.out.println(playerName + "'s hand: ");
			System.out.print(playerHand.toString());
			System.out.println("\n" +playerName + "'s deck is valued at: " + playerHand.cardsValue());
			
			System.out.println("Dealer's hand: [hidden] + " + dealerHand.getCard(0).toString());
		
			System.out.println("What would you like to do?\n1. Hit\n2. Stand");
			int choice = sc.nextInt();
			if(choice==1) {
				playerHand.draw(playingDeck);
				System.out.println(playerName + " drew a " + 
				playerHand.getCard(playerHand.checkDeckSize()-1).toString());
				if (playerHand.cardsValue() > 21) {
					System.out.println("You busted. You went " + (playerHand.cardsValue()-21) 
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
		
		System.out.println("Dealer Cards: " + dealerHand.toString());
		
		if ((dealerHand.cardsValue()>=17) &&  (dealerHand.cardsValue()>playerHand.cardsValue() && roundOver == false)) {
			System.out.println("Dealer wins.");
			betMoney -= playerBet;
			roundOver=true;
		}
		
		while (dealerHand.cardsValue()<17 && roundOver ==false) {
			dealerHand.draw(playingDeck);
			System.out.println("Dealer Draws: " + 
			dealerHand.getCard(dealerHand.checkDeckSize()-1).toString());
		}
		
		System.out.println("Dealer has " + dealerHand.cardsValue());
		if((dealerHand.cardsValue()>21) && roundOver == false) {
			System.out.println("Dealer busts! " + playerName + " wins!");
			betMoney += playerBet;
			roundOver =true;
		}
		
		if((playerHand.cardsValue() == dealerHand.cardsValue()) && roundOver == false) {
			System.out.println("Push");
			roundOver = true;
		}
		
		if ((playerHand.cardsValue()>dealerHand.cardsValue())&& roundOver == false ) {
			System.out.println(playerName + " wins!");
			betMoney += playerBet;
			roundOver = true;
		} else if (roundOver == false) {
			System.out.println("Dealer wins.");
			betMoney -= playerBet;
			roundOver=true;
		}
		
		
		playerHand.moveAll(playingDeck);
		dealerHand.moveAll(playingDeck);
		
		System.out.println("End of hand");
	}
	
	System.out.println("You are broke! Maybe you can sell a kidney?");
	sc.close();
}	
	

}//end GameLoop

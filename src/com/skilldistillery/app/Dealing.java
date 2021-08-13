package com.skilldistillery.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class Dealing {

	public static void main(String[] args) {
		Dealing doug = new Dealing();
		doug.run();
	}

	private void run () {
		Deck deck = new Deck();
		Scanner uI = new Scanner(System.in);
		System.out.println("How many cards do you want? ");
		
		try {
			int numCards = uI.nextInt();
			if (numCards > 52) {
				throw new InputMismatchException();
			}
			
			List<Card> hand = new ArrayList<>(numCards);
			int totalValue = 0;
			for(int i= 0; i < numCards; i++) {
			Card card = deck.dealCard();
			totalValue += card.getValue();
			hand.add(card);
		}
			printHandValue(hand, totalValue);
		}
		catch(InputMismatchException e){
			System.err.println("WTF bro?");
		}

	finally
	{
		uI.close();
	}

}

	  private void printHandValue(List<Card> hand, int value) {
		    for (Card card : hand) {
		      System.out.println(card);
		    }
		    System.out.println("Total value: " + value);
		  }

}
// End Dealing

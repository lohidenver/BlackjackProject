package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private String name;
	
	private Card hand;
	
	private int numCards;
	private int maxNumCards = 10;
	
	public Dealer(String playerName) {
		
		this.name = playerName;
		
		this.emptyhand();
		
		
	}

	public void emptyhand() {
		
		for (int i = 0; i<maxNumCards; i++) {
			this.hand = null;
		}
			this.numCards = 0;
		
	}
	
	
	public boolean addCard(Card card) {
		
		Deck deck = new Deck();
		List<Card> hand = new ArrayList<>(numCards);
		int totalValue = 0;
		for(int i= 0; i < numCards; i++) {
		Card card1 = deck.dealCard();
		totalValue += card1.getValue();
		hand.add(card1);}
		
		return (totalValue <= 21);

	}
	
	public void printHand(boolean showFirstCard) {
		System.out.println(this.name + "'s cards: \n");
		for (int i = 0; i < this.numCards; i++) {
			if ( i == 0 && !showFirstCard) {
				System.out.println("[hidden card]");	
			} else {
				System.out.println(this.hand.toString());
			}
		}
	}
	
	
	
	
}//end dealer class

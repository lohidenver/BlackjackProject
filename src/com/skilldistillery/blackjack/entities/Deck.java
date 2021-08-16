package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
		private List<Card> cards;
		private int numCards;
	
	public Deck() {
			this(1, false);
		}
	public Deck(int numDecks, boolean shuffle) {
		this.numCards = numDecks * 52;
		cards = createDeck(this.numCards);	//()
		
		if (shuffle) {
			this.shuffle();
		}
	}
	
	
	
	private List<Card> createDeck(int numCards){		//()
		List<Card> deck = new ArrayList<>(numCards);	//52
		for (Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
		return deck;
	}
	
	
	
	public int checkDeckSize () {
		if (cards.size()<5) {						
			Collections.shuffle(cards);
			System.out.println("Deck has been shuffled.");
		}
		return cards.size();
	}
	
	public Card dealCard () {
		return cards.remove(0);
	}
	
	public void shuffle () {
		Collections.shuffle(cards);
	}
	
	
	public void printDeck(int numToPrint) {
		for (int i = 0; i <numToPrint; i++) {
			System.out.printf("% 3d/%d %s\n", i+1, this.numCards,
			this.dealCard().toString());
			System.out.printf("\t\t [%d other]\n", this.numCards -numToPrint);;
		}
	}
}

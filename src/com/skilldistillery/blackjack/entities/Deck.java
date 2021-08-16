package com.skilldistillery.blackjack.entities;
import com.skilldistillery.blackjack.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private ArrayList<Card> cards;

	public Deck() {
		this.cards = new ArrayList<Card>();
	}

	public List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize() {
		return this.cards.size();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void fullDeck() {
		for(Suit s: Suit.values()) {
			for(Rank v: Rank.values()) {
				this.cards.add(new Card(v, s));
			}
		}
	}
	
	public String toString() {
		String deck = "";
		int i = 0;
		for (Card card : cards) {
			deck += "\n" + card.toString();
			i++;
		}
		return deck;
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}
	
	public Card getCard(int i) {
		return this.cards.get(i);
	}
	
	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}
	
	public void draw(Deck full) {
		this.cards.add(full.getCard(0));
		full.removeCard(0);
	}
	
	public int cardsValue() {
		int totalValue = 0;
		int ace1or11 = 0;
		
		for (Card acard : this.cards) {
			switch(acard.getRank()) {
			case TWO: 	totalValue += 2; break;
			case THREE: totalValue += 3; break;
			case FOUR: 	totalValue += 4; break;
			case FIVE:	totalValue += 5; break;
			case SIX: 	totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE:	totalValue += 9; break;
			case TEN: 	totalValue += 10; break;
			case JACK:	totalValue += 10; break;
			case QUEEN: totalValue += 10; break;
			case KING: 	totalValue += 10; break;
			case ACE: 	ace1or11 += 1; break;
			}
		}
		
		for(int i=0; i<ace1or11;i++) {
			if (totalValue > 10) {
				totalValue +=1;
			} else {
				totalValue +=11;
			}
		}
		return totalValue;
	}
	
	public void moveAll(Deck move) {
		int thisDeck = this.cards.size();
		for(int i =0; i < thisDeck ; i++) {
			move.addCard(this.getCard(i));
		}
		
		for(int i =0; i < thisDeck ; i++) {
			this.removeCard(0);;
		}
	}
	
}//end Deck.java

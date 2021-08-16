package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class Card {
	private Rank rank; //Ace->King
	private Suit suit; //♥ ♠ ♣ ♦
	private boolean isFaceUp;
	
	
	public Card(Rank rank, Suit suit) { //Card Constructor
		this.rank = rank; //Ace->King
		this.suit = suit; //♥ ♠ ♣ ♦
		isFaceUp = true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

	@Override
	public String toString() {
		String cardString = "";
	
		if (isFaceUp) {
		return rank + "-" + suit;
	} else {
		cardString = "Card is Face Down.";
		}
		return cardString;
	}
	
	
	public String getSuit() {
		return suit.sName();
	}
	
	public int getValue() {				//returns card rank
		return rank.getValue();
	}
	public Rank getRank() {				//returns card rank
		return this.rank;
	}
	
}//End Card Class

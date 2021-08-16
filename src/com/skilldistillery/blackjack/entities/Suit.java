package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts ♥ "),
	SPADES("Spades ♠ "),
	CLUBS("Clubs ♣ "),
	DIAMONDS("Diamonds ♦ ");
	
	private String suitName;
	
	private Suit(String suitName) {
		this.suitName = suitName;
	}
	
	public String sName () {
		return suitName;
	}
	
	@Override
	public String toString() {
		return suitName;
	}
}

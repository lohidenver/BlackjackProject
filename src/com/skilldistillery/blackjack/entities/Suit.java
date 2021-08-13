package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
	private String suitName;
	
	Suit(String suitName) {
		this.suitName = suitName;
	}
	
	@Override
	public String toString() {
		return suitName;
	}
}

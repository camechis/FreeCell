package org.camechis.freecell;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {
	private ArrayList<Card> deck;
	private int count;

	public CardDeck() {
		deck = new ArrayList<Card>();
		count = 0;
	}

	public void Shuffle() {
		Collections.shuffle(deck);
	}

	public void AddCard(Card card) {
		deck.add(card);
	}

	public Card RemoveTopCard() {
		if (deck.size() == 0)
			return null;

		Card card = deck.get(deck.size() - 1);
		deck.remove(deck.size() - 1);
		return card;
	}

	public int GetDeckSize() {
		return deck.size();
	}

	public Card GetCard(int index) {
		if (deck.size() == 0)
			return null;
		else
			return deck.get(index);
	}

	public boolean IsEmpty() {
		if (deck.size() == 0) {
			return true;
		} else
			return false;
	}
}

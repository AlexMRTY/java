package utils;

import java.util.ArrayList;

public class Pile {

    private final ArrayList<Card> myPile;

    public Pile() {
        myPile = new ArrayList<>();
    }
    public Pile (ArrayList<Card> initialCards) {
        // We are making a copy since initialCards could be manipulated outside this class.
        this.myPile = new ArrayList<>(initialCards);
    }

    public int getSize() {
        return myPile.size();
    }

    public void clear() {
        myPile.clear();
    }

    public void add(Card card) {
        myPile.add(card);
    }

    public void add(ArrayList<Card> cards) {
        myPile.addAll(cards);
    }

    public Card get(int index) {
        return myPile.get(index);
    }

    public ArrayList<Card> getCards() {
        return new ArrayList<>(myPile);
    }

    public Card remove(int index) {
        return myPile.remove(index);
    }

    public boolean remove(Card card) {
        return myPile.remove(card);
    }

    public boolean remove(ArrayList<Card> cardsToRemove) {
        return remove(cardsToRemove);
    }

    public boolean contains(Card card) {
        return myPile.contains(card);
    }

    public int nrOfSuits(Suit suit) {
        int count = 0;
        for (Card card : myPile) {
            if (card.getSuit() == suit) count++;
        }
        return count;
    }
    public int nrOfRanks(Rank rank) {
        int count = 0;
        for (Card card : myPile) {
            if (card.getRank() == rank) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (myPile.size() > 0) {
            builder.append(myPile.get(0).toShortString());
            for (int i = 1; i < myPile.size(); i++) {
                builder.append(", ").append(myPile.get(i).toShortString());
            }
        }
        builder.append("]");
        return builder.toString();
    }

}

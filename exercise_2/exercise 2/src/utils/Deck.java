package utils;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private static final ArrayList<Card>protoDeck = new ArrayList<>();
    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                protoDeck.add(new Card(rank, suit));
            }
        }
    }

    private final ArrayList<Card> cards;
    public Deck() {
        cards = new ArrayList<>();
        fill();
    }

    public int getSize() {
        return cards.size();
    }

    public void fill() {
        cards.clear();
        cards.addAll(protoDeck);
    }

    public Card dealCard () {
        return cards.remove(cards.size()-1);
    }

    public void shuffleCards () {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if (cards.size() > 0) {
            builder.append(cards.get(0).toShortString());
            for (int i = 1; i < cards.size(); i++) {
                builder.append(", ").append(cards.get(i).toShortString());
            }
        }
        builder.append("]");
        return builder.toString();
    }


}

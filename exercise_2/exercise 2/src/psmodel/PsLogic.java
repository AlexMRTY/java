package psmodel;

import utils.Card;
import utils.Deck;
import utils.Pile;

import java.util.ArrayList;
import java.util.List;

public class PsLogic implements IPsLogic {
    private Card nextCard;
    private Deck deck;
    private Pile[] piles;


    public PsLogic () {
        deck = new Deck();
//        deck.shuffleCards();
        nextCard = null;
        initPiles();
        fillPiles();
    }

    private void fillPiles() {
        for (Pile pile : piles) {
            pile.add(deck.dealCard());
        }
    }

    private void initPiles () {
        piles = new Pile[5];
        for (int i=0 ; i<piles.length ; i++){
            piles[i] = new Pile();
        }
    }

    @Override
    public void initNewGame() {
        deck.fill();
        deck.shuffleCards();
        clearPiles();
        fillPiles();
        nextCard = null;
    }

    private void clearPiles() {
        for (Pile pile : piles) {
            pile.clear();
        }
    }

    @Override
    public Card pickNextCard() throws IllegalStateException {
        if (isGameOver()) throw new IllegalStateException("Game Over");
        if (nextCard != null) throw new IllegalStateException("Please add previous card to a pile before drawing next card.");
        nextCard = deck.dealCard();
        return nextCard;
    }

    @Override
    public void addCardToPile(int n) throws IllegalStateException {
        if (n < 0 || n > 5) throw new IllegalStateException("Please choose a pile between 0-4");
        if (nextCard == null) throw new IllegalStateException("Please draw a card first.");
        if (piles[n].getSize() == 5) throw new IllegalStateException(String.format("Pile %d is already full. Please choose another one.", n));
        piles[n].add(nextCard);
        nextCard = null;
    }

    @Override
    public boolean isGameOver() {
        return getCardCount() > 24;
    }

    @Override
    public int getCardCount() {
        return 52 - deck.getSize(); // Maybe not the most elegant solution XD.
    }

    @Override
    public Pile[] getPiles() {

        Pile[] copy = new Pile[5];
        for (int i=0 ; i< piles.length ; i++) {
            copy[i] = piles[i];
        }
        return copy;
    }

    @Override
    public int getPoints() {
        int totalPoints = 0;
        for (Pile pile : piles) {
            PokerCombo pokerCombo = PokerHands.getPokerCombos(pile);
            totalPoints += pokerCombo.getValue();
        }
        return totalPoints;
    }
}

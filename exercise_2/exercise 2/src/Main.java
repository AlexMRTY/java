import psmodel.PokerHands;
import psmodel.PsLogic;
import utils.Card;
import utils.Deck;
import utils.Pile;
import utils.Suit;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        PsLogic game = new PsLogic();
        PsUserInterface menu = new PsUserInterface(game);

        Card card;
        for (int i=0 ; i<4 ; i++) {
            for (int j=0 ; j<4 ; j++) {
                card = game.pickNextCard();
                game.addCardToPile(i);
            }
        }

        menu.run();
        
//        Deck myDeck = new Deck();
//        myDeck.shuffleCards();
//
//        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(myDeck.dealCard(), myDeck.dealCard(), myDeck.dealCard(), myDeck.dealCard()));
//
//        Pile pile = new Pile();
//        pile.add(cards);
//
//        PokerHands hand = new PokerHands();
//        System.out.println(hand.sortPileCards(pile));


//        System.out.println(myDeck);
//        System.out.println(pile);
//        System.out.println(pile.nrOfSuits(Suit.DIAMONDS));
    }
}
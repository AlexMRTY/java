package psmodel;

import utils.Card;
import utils.Pile;
import utils.Rank;
import utils.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHands {

    private PokerHands() {};

    public static PokerCombo getPokerCombos(Pile pile) {
        PokerCombo combo = PokerCombo.NONE;
        if (isFlush(pile)) return PokerCombo.FLUSH;
        if (isFourOfAKind(pile)) return PokerCombo.FOUR_OF_A_KIND;
        if (isThreeOfAKind(pile)) return PokerCombo.THREE_OF_A_KIND;

        int nrOfPairs = nrOfPairs(pile);
        if (nrOfPairs == 2) return PokerCombo.TWO_PAIR;
        if (nrOfPairs == 1) return PokerCombo.ONE_PAIR;
        return PokerCombo.NONE;
    }

    private static boolean isFlush(Pile pile) {
        for (Suit suit : Suit.values()) {
            if (pile.nrOfSuits(suit) == 5) return true;
//                return !isSequenceOfFive(pile);
        }
        return false;
    }

//    private ArrayList<Card> sortPile(Pile pile) {
//        ArrayList<Card> sorted = new ArrayList<>(pile.getCards());
//        Collections.sort(sorted);
//        return sorted;
//    }


//    private boolean isSequenceOfFive(Pile pile) {
//        ArrayList<Card> cards = sortPile(pile);
//        int tmp = pile.get(0).getRankValue();
//        for (int i=1 ; i<pile.getSize() ; i++) {
//            if (pile.get(i).getRankValue() == tmp+1 ) {
//                if (i == pile.getSize()-1) return true;
//                tmp = pile.get(i).getRankValue();
//            }
//        }
//        return false;
//    }

    private static boolean isFourOfAKind(Pile pile) {
        for (Rank rank : Rank.values()) {
            if (pile.nrOfRanks(rank) == 4) return true;
        }
        return false;
    }

    private static boolean isThreeOfAKind(Pile pile) {
        for (Rank rank : Rank.values()) {
            if (pile.nrOfRanks(rank) == 3) return true;
        }
        return false;
    }

    private static int nrOfPairs(Pile pile) {
        int nrOfPairs = 0;
        for (Rank rank : Rank.values()) {
            if (pile.nrOfRanks(rank) == 2) nrOfPairs++;
        }
        return nrOfPairs;
    }
}

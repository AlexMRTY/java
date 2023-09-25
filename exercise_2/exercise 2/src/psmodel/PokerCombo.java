package psmodel;

public enum PokerCombo {
    NONE(0), ONE_PAIR(1), TWO_PAIR(3), THREE_OF_A_KIND(6), FOUR_OF_A_KIND(16), FLUSH(5);

    public int getValue() {
        return score;
    }
    private final int score;

    private PokerCombo (int score) {
        this.score = score;
    }
}



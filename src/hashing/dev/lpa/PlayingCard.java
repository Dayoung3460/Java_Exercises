package hashing.dev.lpa;

public class PlayingCard {
    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
        this.internalHash = 1;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}

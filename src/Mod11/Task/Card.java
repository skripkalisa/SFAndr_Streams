package Mod11.Task;

import java.util.Objects;

public final class Card {

    private final String rank;
    private final String suit;
    private final boolean guess;


    public Card(String rank, String suit) {
        if (rank == null || suit == null) {
            throw new IllegalArgumentException(); // бросаем ошибку при создания карты с нулевыми значениями
        }
        this.rank = rank;
        this.suit = suit;
        guess = false;
    }
    public Card(String rank, String suit, boolean guess) {
        if (rank == null || suit == null) {
            throw new IllegalArgumentException(); // бросаем ошибку при создания карты с нулевыми значениями
        }
        this.rank = rank;
        this.suit = suit;
        this.guess = guess;
    }

    @Override
    public boolean equals(Object o) { // карты равны если равны их масти и ранк
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank.equals(card.rank) &&
                suit.equals(card.suit);
    }

    @Override
    public int hashCode() { // hashCode считаем по неизменяемым полям rank и suit
        return Objects.hash(rank, suit);
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isGuess() {
        return guess;
    }
}

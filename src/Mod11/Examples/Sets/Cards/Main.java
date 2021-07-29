package Mod11.Examples.Sets.Cards;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Card> deck = new HashSet<>();
        String[] rank = {"6","7","8","9","10","Jack","Queen","King","Ace"};
        String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String s : suit) {
            for (String value : rank) {
                deck.add(new Card(value, s));
            }
        }
//        // черви
//        deck.add(new Card("6", "черви"));
//        deck.add(new Card("7", "черви"));
//        deck.add(new Card("8", "черви"));
//        deck.add(new Card("9", "черви"));
//        deck.add(new Card("10", "черви"));
//        deck.add(new Card("валет", "черви"));
//        deck.add(new Card("дама", "черви"));
//        deck.add(new Card("король", "черви"));
//        deck.add(new Card("туз", "черви"));
//
//        // бубны
//        deck.add(new Card("6", "бубны"));
//        deck.add(new Card("7", "бубны"));
//        deck.add(new Card("8", "бубны"));
//        deck.add(new Card("9", "бубны"));
//        deck.add(new Card("10", "бубны"));
//        deck.add(new Card("валет", "бубны"));
//        deck.add(new Card("дама", "бубны"));
//        deck.add(new Card("король", "бубны"));
//        deck.add(new Card("туз", "бубны"));
//
//        // крести
//        deck.add(new Card("6", "крести"));
//        deck.add(new Card("7", "крести"));
//        deck.add(new Card("8", "крести"));
//        deck.add(new Card("9", "крести"));
//        deck.add(new Card("10", "крести"));
//        deck.add(new Card("валет", "крести"));
//        deck.add(new Card("дама", "крести"));
//        deck.add(new Card("король", "крести"));
//        deck.add(new Card("туз", "крести"));
//
//        // пики
//        deck.add(new Card("6", "пики"));
//        deck.add(new Card("7", "пики"));
//        deck.add(new Card("8", "пики"));
//        deck.add(new Card("9", "пики"));
//        deck.add(new Card("10", "пики"));
//        deck.add(new Card("валет", "пики"));
//        deck.add(new Card("дама", "пики"));
//        deck.add(new Card("король", "пики"));
//        deck.add(new Card("туз", "пики"));

        // добавим лишние карты в полную колоду
        deck.add(new Card("Jack", "Hearts"));
        deck.add(new Card("Jack", "Clubs"));
        deck.add(new Card("7", "Diamonds"));
        deck.add(new Card("Ace", "Spades"));
//        deck.add(new Card("валет", "черви"));
//        deck.add(new Card("валет", "крести"));
//        deck.add(new Card("7", "бубны"));
//        deck.add(new Card("туз", "пики"));

        System.out.println(deck.size()); // 36
    }
}

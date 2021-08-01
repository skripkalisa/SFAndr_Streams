package Mod11.Task;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Игра \"Верю-неверю\"");
        System.out.println("Компьютер  случайным образом выбирает карту из колоды" +
                " и назначает ей флаг true или false тоже случайным образом. " +
                "Если пользователь угадал - он получает балл, если не угадал, " +
                "то балл получает компьютер, пользователь теряет балл. " +
                "В обоих случаях карта убирается из колоды.");
        Set<Card> deck = new HashSet<>();
        String[] rank = {"6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};
        Random guess = new Random();
        for (String s : suit) {
            for (String value : rank) {
                deck.add(new Card(value, s, guess.nextBoolean()));
            }
        }
//        for(Card card : deck)
//        System.out.println(card.getRank() +" of "
//                + card.getSuit() + " = " + card.isGuess());
        System.out.println("Как играть");
        System.out.println("Компьютер называет карту. Если Вы верите - введите 1");
        System.out.println("В противном случае введите 0. Для выхода введит символ минус '-'");
        char choice;
        int Player = 0, Computer = 0;
        Iterator<Card> card = deck.iterator();
        System.out.println(card.next().getRank() +" of "
                + card.next().getSuit());
        Scanner input = new Scanner(System.in);
        choice = input.next().charAt(0);
        switch (choice){
            case '0'-> System.out.println(++Player);
            case '1' -> System.out.println(++Computer);
            default -> System.out.println("Try again");
        }

// ToDo
    }
}

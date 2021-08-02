package Mod11.Task;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        System.out.println("Simple card game \"I doubt it\"");
        System.out.println("Computer picks a random card \n" + "and randomly sets it to be \"True\" of \"False\". \n"
                + "If you guess it, you get one point, \n" + "while computer looses one point. And vice-versa. \n"
                + "The game continues until there are no cards left.\n");

        System.out.println("How to play.");
        System.out.println("Computer names a card.\n");
        // showRules(); //console in not cleared in IDEA. Weird.
        Set<Card> deck = getCards();
        // for (Card card : deck) // uncomment to see the deck before the game
        // System.out.println(card.getRank() + " of "
        // + card.getSuit() + " = " + card.isGuess());

        int playerScore = 0;
        int computerScore = 0;
        playTheGame(deck, playerScore, computerScore);
    }

    private static Set<Card> getCards() {
        Set<Card> deck = new HashSet<>();
        String[] rank = { "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        String[] suit = { "Hearts", "Diamonds", "Clubs", "Spades" };
        Random guess = new Random();
        for (String s : suit) {
            for (String value : rank) {
                deck.add(new Card(value, s, guess.nextBoolean()));
            }
        }
        return deck;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void playTheGame(Set<Card> deck, int playerScore, int computerScore) {
        char choice;
        boolean move;
        Iterator<Card> card = deck.iterator();
        Scanner input = new Scanner(System.in);
        while (card.hasNext()) {
            Card cardCall = card.next();
            System.out.println("Next card is: " + cardCall.getRank() + " of " + cardCall.getSuit());
            showRules();
            choice = getChoice(input);
            move = checkMove(cardCall.isGuess(), choice);
            if (move) {
                playerScore++;
                computerScore--;
                rightGuess(playerScore, computerScore);
            } else {
                playerScore--;
                computerScore++;
                wrongGuess(playerScore, computerScore);
            }
            clearConsole();
        }
        finalScore(playerScore, computerScore);
    }

    private static void showRules() {
        System.out.print("If you trust it, enter '1'. Otherwise enter '0'. To quit the game, enter '-': ");
    }

    private static char getChoice(Scanner input) {
        char symbol = input.next().charAt(0);
        while (symbol != '0' && symbol != '1' && symbol != '-') {
            System.out.println("Wrong input. Try again: ");
            symbol = input.next().charAt(0);
        }
        return symbol;
    }

    public static boolean checkMove(boolean cardFlag, char choice) {
        switch (choice) {
            case '0' -> {
                return !cardFlag;
            }
            case '1' -> {
                return cardFlag;
            }
            case '-' -> {
                System.out.println("Exit...");
                System.exit(0);
            }
            default -> System.out.println("You can do it!");
        }
        return cardFlag;
    }

    private static void rightGuess(int playerScore, int computerScore) {
        System.out.println("You're right!");
        getScore(playerScore, computerScore);
    }

    private static void wrongGuess(int playerScore, int computerScore) {
        System.out.println("You're wrong!");
        getScore(playerScore, computerScore);
    }

    private static void finalScore(int playerScore, int computerScore) {
        if (playerScore > computerScore) {
            System.out.println("Game over. You win!");
        } else {
            System.out.println("Game over. You loose!");
        }
        getScore(playerScore, computerScore);
    }

    private static void getScore(int playerScore, int computerScore) {
        System.out.println("Your score: " + playerScore + ". Computer score : " + computerScore + "\n");
    }
}

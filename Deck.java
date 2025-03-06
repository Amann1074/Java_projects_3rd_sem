import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    // Constructor to create a deck of cards
    public Deck() {
        createDeck();
    }

    // Method to create a deck of 52 cards
    public void createDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        cards = new ArrayList<>();

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Method to print the entire deck
    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    // Method to print a specific card
    public void printCard(int index) {
        if (index >= 0 && index < cards.size()) {
            System.out.println(cards.get(index));
        } else {
            System.out.println("Invalid card index.");
        }
    }

    // Method to check if two cards are of the same suit
    public boolean sameCard(Card card1, Card card2) {
        return card1.getSuit().equals(card2.getSuit());
    }

    // Method to check if two cards have the same rank
    public boolean compareCard(Card card1, Card card2) {
        return card1.getRank().equals(card2.getRank());
    }

    // Method to find a specific card in the deck
    public void findCard(String rank, String suit) {
        for (Card card : cards) {
            if (card.getRank().equals(rank) && card.getSuit().equals(suit)) {
                System.out.println("Found: " + card);
                return;
            }
        }
        System.out.println("Card not found.");
    }

    // Method to deal 5 random cards
    public void dealCard() {
        Collections.shuffle(cards);
        for (int i = 0; i < 5; i++) {
            System.out.println(cards.get(i));
        }
    }

    // Method to shuffle the deck
    public void shuffleDeck() {
        Collections.shuffle(cards);
        System.out.println("Deck shuffled.");
    }
}

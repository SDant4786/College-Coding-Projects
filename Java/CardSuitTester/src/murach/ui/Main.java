package murach.ui;

import murach.card.Card;

/**
 *
 * @author sdant
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Suit Tester\n");
        /**Creates new card
         * 
         */
        Card card = new Card();
        card.setSuit(Card.Suit.hearts);
        card.setNumber(10);

        displayCard(card);
    }
    
    /**
     *displays the card based on its vales 
     * @param card
     */
    public static void displayCard(Card card) {
        if (card.getNumber() == 1) {
            System.out.print("Ace");
        } else if (card.getNumber() == 11) {
            System.out.print("Jack");            
        } else if (card.getNumber() == 12) {
            System.out.print("Queen");            
        } else if (card.getNumber() == 13) {
            System.out.print("King");            
        } else if (card.getNumber() > 13) {
            System.out.print("????");            
        } else {
            System.out.print(card.getNumber());
        }
        
        System.out.print(" of ");
       
        if (card.getSuit() == Card.Suit.spades) {
            System.out.print("spades");            
        } else if (card.getSuit() == Card.Suit.hearts) {
            System.out.print("hearts");            
        } else if (card.getSuit() == Card.Suit.clubs) {
            System.out.print("clubs");            
        } else if (card.getSuit() == Card.Suit.diamonds) {
            System.out.print("diamonds");            
        } else {
            System.out.print("????");            
        }       
        
        System.out.println("!");        
    }
}
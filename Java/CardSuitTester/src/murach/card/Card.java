
package murach.card;

/**
 *
 * @author sdant
 * 
 * Represents a card is is used in the main function 
 */
public class Card {

    /**
     *Enumeration to store the 4 suites
     */
    public enum Suit{

        spades,

        hearts,

        diamonds,

        clubs
    }

    /**
     *Variables
     */
    Suit suit;
    private int number;
    
    /**
     *
     * @param suit
     * @return
     */
    public  Suit setSuit(Suit suit) {
        this.suit = suit;
        return suit;
    }    
    
    /**
     *
     * @return
     */
    public Suit getSuit() {
        return suit;
    }
    
    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }    
    
    /**
     *
     * @return
     */
    public int getNumber() {
        return this.number;
    }
}
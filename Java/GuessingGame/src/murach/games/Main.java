package murach.games;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        NumberGame game = new NumberGame();
        System.out.println("I have selected a number between 0 and " +
                game.getUpperLimit());
        System.out.println();
        
       
        System.out.print("Enter your guess: ");
        int guess = Integer.parseInt(sc.nextLine()); 
        game.setDateTimeStart();
        while (guess != game.getNumber()) {
            if (guess < game.getNumber()) {
                System.out.println("Your guess is too low.\n");
            } else if (guess > game.getNumber()) {
                System.out.println("Your guess is too high.\n");
            }
            game.incrementGuessCount();
            System.out.print("Enter your guess: ");
            guess = Integer.parseInt(sc.nextLine());
        }        
        System.out.println("Correct!\n");
        game.setDateTimeEnd();
        long temp = game.getSecondsTime();
        System.out.println("You guessed the correct number in " +
                game.getGuessCount() + " guesses.\n" + "and it only took "+
                 temp+ " seconds");
        System.out.println("Bye!");
    }
}
package murach.circle;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Circle Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        ArrayList<Circle> circles = new ArrayList<>();
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            System.out.print("Enter radius:  ");
            double radius = Double.parseDouble(sc.nextLine());


            // create the Circle object
            Circle circle = new Circle(radius);
            circles.add(circle);
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
            // format and display output
            

            // see if the user wants to continue5
            
        }
        int size = circles.size();
        for(int i = 0; i<size; i++){
        String message = 
                "Radius:        " + circles.get(i).getRadius() + "\n" +
                "Area:          " + circles.get(i).getArea() + "\n" +
                "Circumference: " + circles.get(i).getCircumference() + "\n" +
                "Diameter:      " + circles.get(i).getDiameter() + "\n";
            System.out.println(message);
        System.out.println("Bye!");
    }   
}
}
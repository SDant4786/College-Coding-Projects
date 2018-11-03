/*Project 17-2: Conversions from file
Author: Spencer Dant
11/3/2018

Console class
*/
package project172.pkg;

import java.util.Scanner;

public class Console {
    private static Scanner sc = new Scanner(System.in);
    
    public static void displayLine(){
        System.out.println();
    }
    
    public static void display(String s) {
        System.out.println(s);
    }
    
    public static String getString(String prompt){
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }
    
    public static int getInt(String prompt){
        int i = 0;
        while(true) {
            System.out.print(prompt);
            try{
                i = Integer.parseInt(sc.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Error! Invaild integer.Try again.");
            }
        }
        return i;
    }
    
    public static double getDouble(String prompt){
        double d = 0;
        while (true){
            System.out.print(prompt);
            try{
                d= Double.parseDouble(sc.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Error! Invalid decimal. Try again.");
            }
        }
        return d;
    }
}

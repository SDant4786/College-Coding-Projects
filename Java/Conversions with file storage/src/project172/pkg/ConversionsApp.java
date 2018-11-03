/*Project 17-2: Conversions from file
Author: Spencer Dant
11/3/2018

Display/user interface class
*/
package project172.pkg;

import java.util.ArrayList;
import static project172.pkg.ConversionIO.*;

public class ConversionsApp {
public static ArrayList<Conversion>conversionsList = new ArrayList<Conversion>();
    public static void mainMenu(){

        //Menu display
        Console.display("");
        Console.display("1 - Convert a length");
        Console.display("2 - Add a type of converions");
        Console.display("3 - Delete a type of converions");
        Console.display("4 - Exit \n");
        
        //Sends to other functions depending on input
        int selection = 0;
        while (true){
        selection = Console.getInt("Enter menu number: ");
        if (selection <0 || selection >4){
            Console.display("Input out of range");
        }
        else 
            break;
        }
        if (selection == 1){
            convertMenu();
        }
        if (selection ==2 ){
            addMenu();
        }
        if (selection == 3){
            deleteMenu();
        }
        //saves data to file before app closes
        if (selection == 4){
            saveConversions();
            System.exit(0);
        }
    }
    
    public static void convertMenu(){
        //creates current list of conversions
        conversionsList = getConversions();
       
       int length = conversionsList.size();

       if (length == 0){
           Console.display("No conversions on file");
           mainMenu();
    }
       //Displays list
       for(int i = 0; i<length; i++){
           int number = i+1;
           Conversion c = getConversion(i);
           Console.display(number+" - " + c.getToUnit() + " to "
                   + "" + c.getFromUnit() + ": " + 
                   c.getConversionRatio());
       }
       
       //Selection is based on position in list
       int selection;
       while (true){
       selection = Console.getInt("Enter Conversion number: ")-1;
       if (selection <0 || selection > conversionsList.size()) {
           Console.display("Input out of range: ");
       }
       else 
       break;
       }
    
    
       //Does conversions and displays results 
       Conversion c = getConversion(selection);
       Console.display("");
       double input = Console.getDouble("Enter "+c.getFromUnit()+ ": ");
       c.setFromValue(input);
       double converted = c.convert();
       Console.display(input + " " + c.getToUnit() + " = " + converted + " " + c.getFromUnit());
       
       //goes back to main menu function
       mainMenu();
    }   
    
    public static void addMenu(){
        
        //Gets input
        String fromUnit = Console.getString("Enter 'From' unit: ");
        String toUnit = Console.getString("Enter 'To' unit: ");
        Double conversionRatio = Console.getDouble("Enter the conversion ratio: ");
        
        //create new conversion object and assigns values
        Conversion c = new Conversion();
        c.setFromUnit(fromUnit);
        c.setToUnit(toUnit);
        c.setConversionRatio(conversionRatio);
        
        
        //adds to arraylist
        addConversion(c);
        Console.display("Conversion Added");
        //goes back to main menu function
        mainMenu();
    }
    
    public static void deleteMenu(){
          //creates current list of conversions
        conversionsList = getConversions();
       int length = conversionsList.size();
       
       if (length == 0){
           Console.display("No conversions to delete.");
           mainMenu();
       }
       
       //Displays list
       for(int i = 0; i<length; i++){
           int number = i+1;
           Conversion c = getConversion(i);
           Console.display(number+" - " + c.getToUnit() + " to "
                   + "" + c.getFromUnit());
       }
       int delete = 0;
       while (true){
       delete = Console.getInt("Enter the number of the conversion to delete: ")-1;
       if (delete <0 || delete > conversionsList.size()){
           Console.display("Input out of range");
       }
       else
           break;
    }
    //Deletes the conversion
    deleteConversion(getConversion(delete));
    Console.display("Conversion deleted");

    //returns to main menu
    mainMenu();
    }
    
    
}

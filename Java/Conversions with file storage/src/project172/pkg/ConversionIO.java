/*Project 17-2: Conversions from file
Author: Spencer Dant
11/3/2018

IO class
*/
package project172.pkg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class ConversionIO {
    private static final String FIELD_SEP = "\t";
    private static ArrayList<Conversion> conversionsList;
    private static String fileName = "conversion_type.txt";
    private static File conversionsFile = new File(fileName);
    
    private ConversionIO(){}
    public static ArrayList<Conversion> getConversions() {

        //Stops reading if arraylist is already populated from file
        if(conversionsList != null){
            return conversionsList;
        }
        else
        conversionsList = new ArrayList<Conversion>();
        
        //creates file if there isn't one
        try {
            conversionsFile.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
        
        //reads file to arraylist for program to use
            try {
                BufferedReader in = new BufferedReader(
                    new FileReader(fileName));
                String line;
                while((line = in.readLine()) != null){
                    String [] columns = line.split(FIELD_SEP);
                    Double fromValue = Double.parseDouble(columns[0]);
                    Double toValue = Double.parseDouble(columns[1]);
                    Double conversionRatio = Double.parseDouble(columns[2]);
                    String fromUnit = columns[3];
                    String toUnit = columns[4];
                    
                    Conversion c = new Conversion(fromValue,toValue,conversionRatio
                    ,fromUnit, toUnit);
                    conversionsList.add(c);

                }
                in.close();
            }
            catch(IOException e) {
                System.out.println(e);
                return null;
            }
            return conversionsList;
        }
  
        
    
    public static Conversion getConversion(int i){
        return conversionsList.get(i);
    }
    
    public static void addConversion (Conversion c){
        conversionsList.add(c);
    }
    
    public static void deleteConversion(Conversion c){
        conversionsList.remove(c);
    }
    public static void saveConversions(){
        //creates lines of data to save to file
         try {
             PrintWriter out = new PrintWriter(
                                new BufferedWriter(
                                new FileWriter(fileName,false)));
             for (int i = 0; i<conversionsList.size(); i++){
                 Conversion c = getConversion(i);
                 out.println(c.getFromValue() + FIELD_SEP +c.getToValue() +FIELD_SEP +
                         c.getConversionRatio()+FIELD_SEP+ c.getFromUnit()+FIELD_SEP+
                         c.getToUnit()+FIELD_SEP);
             }
             out.close();
         }
         catch (IOException e){
             System.out.println(e);
         }  
    }
}

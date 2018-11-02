/*Project 17-1 : Check if a path exists
Author: Spencer Dant
11/2/2018
*/
package Project171CheckIfPathExists.pkg;

import java.util.Scanner;
import java.io.File;

public class Project171CheckIfAPathExists {

    public static void main(String[] args) {
        char endCheck = 'y';
        while(endCheck!= 'n'){
        //scanner to read input
        Scanner reader = new Scanner(System.in);
        
        //get input
        System.out.println("Enter a path: ");
        String path = reader.next();
        
        //create file
        File file2 = new File(path);
        
        //Check for file or direcotry 
        if (file2.isDirectory()){
            System.out.println("This points to a directory.");
        }
        else if(file2.isFile()){
            System.out.println("This points to a file.");
        }
        else 
            System.out.println("Path does not exist.");

        //continue loop
        System.out.println("Continue? y/n");
        endCheck = reader.next().charAt(0);
        
    }
    }
}

package murach.ui;

import murach.business.Product;

public class Main {

    public static void main(String[] args) {
        String productString = "java:Murach's Java Programming:57.50";
        String[] productArray = productString.split("\\:");
        String tempCode = productArray[0];
        String tempDescription = productArray[1];
        String tempPrice= productArray[2];
        double tempP= Double.parseDouble(tempPrice);
        Product product = new Product(tempCode,tempDescription,tempP);
        
        //TODO: process productString and populate fields of product object
        
        System.out.println("Code:        " + product.getCode());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price:       " + product.getPriceFormatted());
    }    
}
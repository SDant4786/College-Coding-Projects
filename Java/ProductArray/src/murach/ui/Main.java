package murach.ui;

import murach.business.Product;
import murach.db.ProductDB;

public class Main {

    public static void main(String[] args) {
        Product product = ProductDB.getProductByCode("jsp");
        System.out.println("PRODUCT BY CODE");
        System.out.println("Code:        "+ product.getCode());
        System.out.println("Description: "+ product.getDescription());
        System.out.println("Price:       "+ product.getPriceFormatted());
        System.out.println("----------------------------------------------");
        
        product = ProductDB.getProductByIndex(0);
        System.out.println("PRODUCT BY INDEX");
        System.out.println("Code:        "+ product.getCode());
        System.out.println("Description: "+ product.getDescription());
        System.out.println("Price:       "+ product.getPriceFormatted());
        System.out.println("----------------------------------------------");
        
        Product[] products = ProductDB.getAllProducts();
        System.out.println("LIST OF ALL PRODUCTS");
        for (int i = 0; i < 3; i++) {
            System.out.println("Code:        "+products[i].getCode());
            System.out.println("Description: "+products[i].getDescription());
            System.out.println("Price:       "+products[i].getPriceFormatted());        
            System.out.println();
        }            
        System.out.println("----------------------------------------------");        
    }    
}
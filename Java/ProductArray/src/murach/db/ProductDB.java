package murach.db;

import murach.business.Product;

public class ProductDB {
    private static String[][] productsArray = {
        {"java", "Murach's Java Programming", "57.50"},
        {"jsp", "Murach's Java Servlets and JSP", "57.50"},
        {"mysql", "Murach's MySQL", "54.50"}
    };
    
    public static Product getProductByIndex(int i) {
       return new Product(productsArray[i][0],productsArray[i][1],Double.parseDouble(productsArray[i][2]));
    }
    
    public static Product getProductByCode(String code) {
        for(int i = 0; i <productsArray.length; i++){
            if (code.equals(productsArray[i][0])){
                return new Product(productsArray[i][0],productsArray[i][1],Double.parseDouble(productsArray[i][2]));
            }
        }
        return null;
    }
    
    public static Product[] getAllProducts() {
        Product[] Product = new Product[productsArray.length];
        for (int i = 0; i < productsArray.length; i++){
            Product [i] = new Product(productsArray[i][0],productsArray[i][1],Double.parseDouble(productsArray[i][2]));
        }
        return Product;
    }    
}
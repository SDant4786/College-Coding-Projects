package murach.db;

import murach.business.Product;

public class ProductDB2 implements IProductDB {
    
    private String[][] productsArray = {
        {"java", "Murach's Java Programming", "57.50"},
        {"jsp", "Murach's Java Servlets and JSP", "57.50"},
        {"android", "Murach's Android Programming", "57.50"},
        {"mysql", "Murach's MySQL", "54.50"}
    };
    @Override
    public Product get(String productCode) {
        for (String[] row : productsArray) {
            String code = row[0];
            if (productCode.equals(code)) {
                String description = row[1];
                String price = row[2];        
                Product p = new Product(
                        code, description, Double.parseDouble(price));                
                return p;
            }
        }
        return null;
    }
}
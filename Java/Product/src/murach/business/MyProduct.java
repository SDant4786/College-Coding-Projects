/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.business;
import murach.business.Product;

/**
 *
 * @author sdant
 */
public class MyProduct extends Product{
    public MyProduct(){
        super();
    }
    public String getPrice2(){
        return super.getPriceFormatted();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package murach.db;
import murach.business.Product;
/**
 *
 * @author sdant
 */
public interface IProductDB {
    public abstract Product get(String productCode);
}

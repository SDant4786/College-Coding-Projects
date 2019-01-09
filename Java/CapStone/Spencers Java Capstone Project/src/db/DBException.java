/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author sdant
 */
public class DBException extends Exception {
    private DBException() {}
    
    public DBException(Exception e) {
        super(e);
    }
}

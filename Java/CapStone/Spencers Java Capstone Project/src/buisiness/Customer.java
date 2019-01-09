/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buisiness;

/**
 *
 * @author sdant
 */
public class Customer {
    
    private String email, first, last;
    
    public Customer(){
        email = "";
        first = "";
        last ="";
    }
    public Customer(String email, String first, String last){
        this.email = email;
        this.first = first;
        this.last = last;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getFirst(){
        return first;
    }
    
    public void setFirst(String first){
        this.first = first;
    }
    
    public String getLast(){
        return last;
    }
    
    public void setLast(String last){
        this.last = last;
    }
}

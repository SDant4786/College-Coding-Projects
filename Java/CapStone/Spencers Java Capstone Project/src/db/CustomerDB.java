/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import buisiness.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import util.DBUtil;

/**
 *
 * @author sdant
 */
public class CustomerDB {
    private static ArrayList<Customer> customerList;
    private static Connection connection;
    
    private CustomerDB(){}
    
    //Method to create an array list from the database
    public static ArrayList list(){
        //Open Connection
        try{
        connection = DBUtil.getConnection();
        }
        catch(DBException e){
            System.out.println(e);
        }
        //Prepared statements
        String sql = "SELECT * FROM Customers ORDER BY Email";
        customerList = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //Loop through and populate customerList from database
            while(rs.next()){
                Customer c = new Customer();
                c.setEmail(rs.getString(1));
                c.setFirst(rs.getString(2));
                c.setLast(rs.getString(3));
                customerList.add(c);
            }
            //close everything up
            rs.close(); 
            //Exception handling
        } catch (SQLException e){
            System.out.println("DataBase Error Listing");
        }
        return customerList; //REturn the newly formed list
    }
    
    //Method to add customer to the ArrayList
    public static void add(Customer customer){
        //Open Connection
        try{
        connection = DBUtil.getConnection();
        }
        catch(DBException e){
            System.out.println(e);
        }
        //Prepared statements
        String sql = "INSERT INTO Customers (Email, First, Last)"+
                "VALUES (?,?,?)";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            //Seting values to be added 
            ps.setString(1,customer.getEmail());
            ps.setString(2,customer.getFirst());
            ps.setString(3,customer.getLast());
            ps.executeUpdate(); //add to database
            //catch exceptions
        } catch (SQLException e){
            System.out.println("DataBase Error Adding");
        }
    }
    
    //Method to delete customer from ArrayList
    public static void delete(int i){
        //Open Connection
        try{
        connection = DBUtil.getConnection();
        }
        catch(DBException e){
            System.out.println(e);
        }
        customerList = list();
        String email = customerList.get(i).getEmail(); //Creating variable here so its easy to work with
        //Prepare statement
        String sql = "DELETE FROM Customers "
                + "WHERE Email = ?";
        //Execute statment
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email); //set email to be deleted
            ps.executeUpdate(); //delete
            //cathc exceptions
        } catch (SQLException e){
            System.out.println("DataBase Error Deleting");
        }
    }
    
    public static void update(Customer customer){
        //Open Connection
        try{
        connection = DBUtil.getConnection();
        }
        catch(DBException e){
            System.out.println(e);
        }
        //Prepared statements
        String sql = "UPDATE Customers SET "
                + "First = ?, Last = ? WHERE Email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,customer.getFirst());
            ps.setString(2,customer.getLast());
            ps.setString(3, customer.getEmail());
            ps.executeUpdate();
        } catch (SQLException e){
            System.out.println("DataBase Error Updating");
        }
    }
    
    public static void createTable (Connection connection){
               try{
            Statement statement = connection.createStatement();
            String create = "CREATE TABLE IF NOT EXISTS Customers(\n "
                    + "Email VARCHAR (255) PRIMARY KEY,"
                    + "First VARCHAR (255),"
                    + "Last VARCHAR (255));";
            statement.executeUpdate(create);
        }
        catch (SQLException e){
            System.out.println("Database error Creating");
    }
    }
}

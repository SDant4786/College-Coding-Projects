package gui;

import db.CustomerDB;
import db.DBException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import util.DBUtil;


public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Opens connection for program
        Connection connection = null;
        try{
        connection = DBUtil.getConnection();
        }
        catch(DBException e){
            System.out.println(e);
        }
        //creates table if one doesnt exists
        CustomerDB.createTable(connection);
        JFrame mainFrame = new CustomerManagerFrame();
    }

}

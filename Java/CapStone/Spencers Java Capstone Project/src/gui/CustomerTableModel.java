
package gui;

import buisiness.Customer;
import db.CustomerDB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CustomerTableModel extends DefaultTableModel {

private static ArrayList<Customer> customerList; //array list from database
private static final String[] COLUMN_NAMES = {"Email", "First Name", "Last Name"}; //names for columns

public CustomerTableModel(){ //initial creation of table and adding in customers
    this.setColumnCount(3);
    this.setColumnIdentifiers(COLUMN_NAMES);
    
    customerList = CustomerDB.list();
    for (int i = 0; i<customerList.size();i++) {
        Customer c = customerList.get(i);
        this.addRow(new Object[]{c.getEmail(), c.getFirst(), c.getLast()});
    }
}
public void updateTable(){ //called everytime something changes to keep things working properly
    customerList = CustomerDB.list();
    for (int i = 0; i<customerList.size();i++) {
        Customer c = customerList.get(i);
        this.setValueAt(c.getEmail(), i, 0);
        this.setValueAt(c.getFirst(), i, 1);
        this.setValueAt(c.getLast(), i, 2);
}
}
@Override
public boolean isCellEditable (int row, int column){
    return false;
}
}
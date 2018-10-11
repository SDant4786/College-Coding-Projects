package murach.io;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import murach.business.Customer;

public class CustomerTextFile {
    private static final String FIELD_SEP = "\t";
    private static final Path customersPath = Paths.get("customers.txt");
    private static final File customersFile = customersPath.toFile();
    private static List<Customer> customers;

    // prevent instantiation of the class
    private CustomerTextFile() {}

    public static List<Customer> getCustomers() {
        // if the customers file has already been read, don't read it again
        if (customers != null) {
            return customers;
        }
        

        try (BufferedReader in = new BufferedReader(
                                 new FileReader(customersFile))) {
            
            // read all customers stored in the file
            // into the array list
            customers = new ArrayList<>();
            
            String line;
            while ((line = in.readLine()) != null) {
                String[] columns = line.split(FIELD_SEP);
                String firstName = columns[0];
                String lastName = columns[1];
                String email = columns[2];

                Customer p = new Customer(
                        firstName, lastName, email);

                customers.add(p);
            }
            return customers;
            
        } catch (IOException e) {
            System.out.println(e);
            throw new DBException("DataBase Error");
            return null;
        }
    }

    public static Customer getCustomer(String email) {
        customers = getCustomers();
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public static boolean addCustomer(Customer c) {
        customers = getCustomers();
        customers.add(c);
        return saveCustomers();
    }

    public static boolean deleteCustomer(Customer c) {
        customers = getCustomers();
        customers.remove(c);
        return saveCustomers();
    }

    private static boolean saveCustomers() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(customersFile)))) {

            // write all customers in the array list
            // to the file
            for (Customer c : customers) {
                out.print(c.getFirstName() + FIELD_SEP);
                out.print(c.getLastName() + FIELD_SEP);
                out.println(c.getEmail());
            }
        } catch (IOException e) {
            System.out.println(e);
            throw new DBException("DataBase Error");
            return false;
        }

        return true;
    }
}
//Author: Spencer Dant
//C# Proramming
//7/26/2018
//Customer storage/parsing/sorting
using System;
using System.Collections.Generic;

namespace Module6Exercise6
{
    class Program
    {
        static void Main(string[] args)
        {
            //Strings to hold inputs
            String Name, Date, Month, Zip;

            //List to store objects
            List<CustomerClass> customerStorage = new List<CustomerClass>();
            while (true)
            {
                //Get input for the customer object
                Console.WriteLine("Enter the customers name, First then last name seperated by a ' ': ");
                Name = Console.ReadLine();
                Console.WriteLine("Enter the birthday in the format mm/dd/yyyy: ");
                Date = Console.ReadLine();
                Console.WriteLine("Enter the number of the month subscribed: ");
                Month = Console.ReadLine();
                Console.WriteLine("Enter the zip code: ");
                Zip = Console.ReadLine();

                //builds object and adds to list
                customerStorage.Add(new CustomerClass(Name, Date, Month, Zip));

                Console.WriteLine();
                //Loop for more customer inputs
                Console.WriteLine("Enter 'y' to enter new customer, 'p' to print");
                char key = Console.ReadKey().KeyChar;
                if (key == 'y')
                {
                    Console.Clear();
                }
                //prints the list using the SortAndPrint function form CustomerClass
                else if (key == 'p')
                {
                    Console.Clear();
                    CustomerClass.SortAndPrint(customerStorage);
                    Console.WriteLine("Press enter to exit");
                    Console.ReadLine();
                    break;
                }
                        
            }
        }
    }
}

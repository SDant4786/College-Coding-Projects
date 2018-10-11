//Author: Spencer Dant
//C# Proramming
//7/26/2018
//Customer storage/parsing/sorting
using System;
using System.Collections.Generic;

//All exceptions are handled in this class. throws a simple custom handler
public class CustomerClass
{
    public String FirstN, LastN, CC,SubMonth, BirthY;
    int BirthD, BirthM, ZipCode, FirstNLength, ZipDigits, BirthYShort, LastNLength, NameLength;
    String[] Months = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                                    "Aug", "Sep","Oct", "Nov", "Dec" };
    public List<CustomerClass> customerStorage = new List<CustomerClass>();
    
    //Constructor
	public CustomerClass(String Name, String Date, String Month, String Zip)
	{

        this.ZipCodeProcessing(Zip);
        this.NameParse(Name);
        this.BirthdayParse(Date);
        this.NumToMonth(Month);
        this.CustomerCode();
        
	}
    //Parses the first and last name
    public void NameParse(String s)
    {
       String[] names = s.Split(' ');
        if (names.Length != 2) { throw new Exceptions("Invalid name input"); }
        FirstN = names[0];
        LastN = names[1];
        FirstNLength = FirstN.Length;
        LastNLength = LastN.Length;
        NameLength = FirstNLength + LastNLength+1;
    }
    //Parses the birthday input 
    public void BirthdayParse(String s)
    {
        String[] date = s.Split('/');
        if (date.Length != 3) { throw new Exceptions("Invalid Date Input"); }

        if (Int32.TryParse(date[0], out BirthM)) {
            BirthM = Int32.Parse(date[0]);
        }
        else { throw new Exceptions("Invalid Date Input"); }
        if (Int32.TryParse(date[1], out BirthD))
        {
            BirthD = Int32.Parse(date[1]);
        }
        else { throw new Exceptions("Invalid Date Input"); }
        BirthY = date[2];
        if (BirthY.Length != 4) { throw new Exceptions("Invalide Date Input"); }
        if (Int32.TryParse((BirthY.Remove(0, 2)), out BirthYShort)) { BirthYShort = Int32.Parse(BirthY.Remove(0, 2)); }
        else { throw new Exceptions("Invalid Date Input"); }
        }
    //Turns month number into name
    public void NumToMonth(String s)
    {
        int num;
        if (Int32.TryParse(s, out num))
        {
            num = Int32.Parse(s);
            if ((num < 0) || (num > 11)) {
                throw new Exceptions("Invalid month input");
            }
            else {
                SubMonth = Months[(num - 1)]; }
            
        }else { throw new Exceptions("Invalid month input"); } }
    //Changes the zip code around for easier usage
    public void ZipCodeProcessing(String s)
    {
        if (s.Length != 5) { throw new Exceptions("Invalid zip code input"); }
        String ZipDigitsS = s.Substring(3, 2);
        if (Int32.TryParse(s, out ZipCode))
        {
            ZipCode = Int32.Parse(s);
            ZipDigits = Int32.Parse(ZipDigitsS);
        }
        else { throw new Exceptions("Invalid zip code input"); }
        
        
        
    }
    //creates the customer code
    public void CustomerCode()
    {
        CC = LastN + BirthYShort.ToString() + NameLength.ToString() + SubMonth + ZipDigits.ToString();

    }
    //Printing formating
    public void Print() {
        Console.WriteLine(FirstN+ " " + LastN);
        Console.WriteLine("DOB: " + BirthM + "/" + BirthD + "/" + BirthY);
        Console.WriteLine("Zip: " + ZipCode);
        Console.WriteLine("Sub Month: " + SubMonth);
        Console.WriteLine("CC: " +CC);
        Console.WriteLine();
    }
    //Function to sort and print the list
    public static void SortAndPrint(List<CustomerClass> l)
    {
        l.Sort((x, y) => String.Compare(x.LastN, y.LastN));
        for (int i = 0; i < l.Count; i++) { 
            var test = l[i];
              test.Print();
    }
    }

}
//Exeception handler
public class Exceptions : Exception
{
    public Exceptions(String s)
    {
        Console.WriteLine(s);
    }
}

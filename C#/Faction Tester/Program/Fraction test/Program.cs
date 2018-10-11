/*Author: Spencer Dant
 * C# Programming
 * Faction Tester
 */
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Fraction_test
{
    //Fraction class
    public class Fraction
    {
        int Numerator;
        int Denominator;
        double DFrac;

        //Constructor
        public Fraction(int Numerator, int Denominator)
        {
            this.Numerator = Numerator;
            this.Denominator = Denominator;
        }

        //Converts to decimal
        public double ToDecimal()
        {
            DFrac = (double)Numerator / (double)Denominator;
            return DFrac;
        }

        //Adds two fractions together
        public Fraction Add(Fraction f)
        {
            int num1 = f.Numerator * this.Denominator;
            int num2 = this.Numerator * f.Denominator;
            Denominator = f.Denominator * this.Denominator;
            Numerator = num1 + num2;
            Fraction ff = new Fraction(Numerator, Denominator);
            return ff;
            
        }

        //Multiplies two fractions together
        public Fraction Multiply(Fraction f)
        {
            Numerator = f.Numerator * this.Numerator;
            Denominator = f.Denominator * this.Denominator;
            Fraction ff = new Fraction(Numerator, Denominator);
            return ff;
        }

        //Simplifes a fraction 
        public Fraction Simplify()
        {
            int a = Numerator;
            int b = Denominator;
            int GCD;
            
                while (a != 0 && b != 0)
                {
                    if (a > b)
                        a %= b;
                    else
                        b %= a;
                }
                if (a == 0)
                {
                    GCD = b;
                }
                else
                {
                    GCD = a;
                }
                Numerator = Numerator / GCD;
                Denominator = Denominator / GCD;
          Fraction ff = new Fraction(Numerator, Denominator);
            return ff;

            //Print functions
        }
        public void PrintFraction()
        {
            Console.WriteLine(Numerator + "/" + Denominator);
        }
        public void PrintDecimal()
        {
            Console.WriteLine(DFrac);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            //Enter numerator and denominator seperatly
            Console.WriteLine("Enter Fraction");
                int x = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("--");
                int y = Convert.ToInt32(Console.ReadLine());
                Fraction f = new Fraction(x, y);

            f.ToDecimal();
            f.PrintDecimal();

            Console.WriteLine("Enter Second Fraction");
            x = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("--");
            y = Convert.ToInt32(Console.ReadLine());
            Fraction f2 = new Fraction(x, y);
            //uncomment to add first to fractions
           /* Console.WriteLine("ADD");
            Fraction fadd = f.Add(f2);
            fadd.Simplify();
            fadd.PrintFraction();*/

            Console.WriteLine("Enter Third Fraction");
            x = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("--");
            y = Convert.ToInt32(Console.ReadLine());
            Fraction f3 = new Fraction(x, y);

            Console.WriteLine("Multiply");
            f.Multiply(f2.Multiply(f3));
            f.Simplify();
            f.PrintFraction();
                
            Console.ReadLine();
        }
    }
}

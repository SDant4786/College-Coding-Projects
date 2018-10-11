//Author Spencer Dant
//C# Programming
//7/20/18
//Movement with delegates 
using System;
using System.Collections.Generic;
using System.Data.OleDb;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace DelgateKeypress
{
    class Program
    {
        //Dictionary data structure. Commaneds added within the main program could also be 
        //coded here instead of within the program
        static Dictionary<ConsoleKey, Action> myControls;
       private static int x=20;
        private static int y=20;

        private static void Main(string[] args)
        {
            //Creating and adding the movements. This is the first time used lambda expressions
            //and they're pretty awesome
            myControls = new Dictionary<ConsoleKey, Action>();
            myControls.Add(ConsoleKey.W, () => { if(y>0) y--; });
            myControls.Add(ConsoleKey.S, () => { y++; });
            myControls.Add(ConsoleKey.D, () => { x++; });
            myControls.Add(ConsoleKey.A, () => { if (x >0) x--; });

            while (true)
            { 
                
                Console.SetCursorPosition(x, y);
                Console.Write("@");

                int oldX = x;
                int oldY = y;
                //This reads the key and uses 'moves' the character accordingly 
                var key = Console.ReadKey(true);

                    myControls[key.Key]();
                
                    Console.SetCursorPosition(oldX, oldY);
                    Console.Write("+");
                        
            


            }
        }

    }
}

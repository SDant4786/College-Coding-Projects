/*Author Spencer Dant
 * C# Programming
 * 7/5/17
 * Module 3 exercise 2
 * Basic RPG inventory system*/

using System;
using System.Collections.Generic;

namespace Module3Exercise2
{
    class Program
    {
        static void Main(string[] args)
        {
            IContainer container = new Inventory(5);
            container.AddItem(new Sword());
            container.AddItem(new Sheild());
            container.AddItem(new Potion());
            IContainer bag = new BagOfHolding(5);
            bag.AddItem(new Sheild());
            bag.AddItem(new Sheild());
            bag.AddItem(new Sword());

            Console.WriteLine("Total weight is: " + bag.TotalWeight());
            Console.WriteLine("Total count is : " + bag.TotalCount());
            

           
            Console.ReadLine();
        }
    }
}

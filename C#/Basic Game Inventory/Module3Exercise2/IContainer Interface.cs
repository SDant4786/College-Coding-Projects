/*Author Spencer Dant
 * C# Programming
 * 7/5/17
 * Module 3 exercise 2
 * Basic RPG inventory system*/
using System;


//Interface for adding objects,returing weight and adding to count
interface IContainer
{
    int Count();
    Boolean AddItem(InventoryItems o);
    double ReturnWeight();
    double GetWeight(int spot);
    double TotalWeight();
    double TotalCount();
}

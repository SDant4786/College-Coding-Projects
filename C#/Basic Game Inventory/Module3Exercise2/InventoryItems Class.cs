/*Author Spencer Dant
 * C# Programming
 * 7/5/17
 * Module 3 exercise 2
 * Basic RPG inventory system*/
using System;

//All Items and Invetry Items class

    //main item class
public class InventoryItems:Inventory
{
    

    public InventoryItems(String name, double weight,double cost)
    {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
    public InventoryItems()
    {

    }
}

//sword
public class Sword : InventoryItems
{
    public Sword()
    {
        name = "Sword";
        weight = 2;
        cost = 500;
    }
}
//sheild
public class Sheild : InventoryItems
{
    public Sheild()
    {
        name = "Sheild";
        weight = 4;
        cost = 300;
    }
}
//potion
public class Potion : InventoryItems
{
    public Potion()
    {
        name = "Postion";
        weight = .5;
        cost = 20;
    }
}
//armor
public class Armor : InventoryItems
{
    public Armor()
    {
        name = "Armor";
        weight = 10;
        cost = 50;
    }
}

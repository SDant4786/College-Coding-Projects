/*Author Spencer Dant
 * C# Programming
 * 7/5/17
 * Module 3 exercise 2
 * Basic RPG inventory system*/
using System;
using System.Collections.Generic;

//Main inventory class
public class Inventory:IContainer
{
    public String name;
    public double weight;
    public double cost;
    public double inventoryWeight;
    public int inventoryCount;
    int inventorySize = 0;
    public double totalWeight;
    public List<Inventory> InventoryItems;
    //construcor 
	public Inventory(int inventorySize)
	{
        this.inventorySize = inventorySize;
        InventoryItems = new List<Inventory>(inventorySize);   
	}
    public Inventory(){}
    //Blank because used in bag class
    double IContainer.TotalCount(){ return 0;}
    //Bland because uesd in bag class
    double IContainer.TotalWeight(){return 0; }
    //Get weight fo certain objects
    double IContainer.GetWeight(int spot)
    {
        inventoryWeight = InventoryItems[spot].weight;
        return inventoryWeight;
    }
    //Adds to bag count 
    int IContainer.Count()
    {
        inventoryCount++;
        return inventoryCount;
    }
    //Adds to total inventory weight
    double IContainer.ReturnWeight()
    {
        inventoryWeight += weight;
        return inventoryWeight;
    }
    //Item adding method
    Boolean IContainer.AddItem(InventoryItems item)
    {
        if (inventoryCount < inventorySize)
        {
            InventoryItems.Add(item);
            inventoryCount++;
            inventoryWeight += item.weight;
            return true;

        }
        else
            return false;
    }
}








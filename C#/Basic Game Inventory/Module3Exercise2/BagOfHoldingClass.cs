/*Author Spencer Dant
 * C# Programming
 * 7/5/17
 * Module 3 exercise 2
 * Basic RPG inventory system*/
using System;
using System.Collections.Generic;

//Bag of holding class
public class BagOfHolding : InventoryItems, IContainer
{
    int totalCount;
    double bagWeight;
    int bagSize;
    int count;
    List<InventoryItems> bagOfHolding;
    //Constructor
    public BagOfHolding(int bagSize)
    {
        this.bagSize = bagSize;
        bagOfHolding = new List<InventoryItems>(bagSize);
    }
    //Returns weight of object
    double IContainer.GetWeight(int spot)
    {

        return weight;
    }
    //Adds to count
    int IContainer.Count()
    {
        count++;
        return count;
    }
    //Calculates total weight for inventory and bag 
    double IContainer.TotalWeight()
    {
        double temp = inventoryWeight;
        totalWeight = inventoryWeight + bagWeight;
        return totalWeight;
    }
    //Returns total bag weight
    double IContainer.ReturnWeight()
    {
            bagWeight += weight;
            return bagWeight;
    }
    public double Weight()
    {
        return bagWeight;
    }
    //Calculates total count for inventory and bag
    double IContainer.TotalCount()
    {
        double  temp = inventoryCount;
        totalCount = count + inventoryCount;
;
        return totalCount;
    }
    //Adds item to bag
    Boolean IContainer.AddItem(InventoryItems item)
    {
        if (count < bagSize)
        {
            count++;
            bagOfHolding.Add(item);
            
            bagWeight += item.weight;
            return true;

        }
        else
            return false;
    }
}

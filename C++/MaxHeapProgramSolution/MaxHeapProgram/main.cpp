// MaxHeapProgram.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "MaxHeapArray.h"
#include "BinarySearchTree.h"

#include <iostream>

using namespace std;
/*The insertion method i have from the binary search tree can sort the inputs into decending order
while they are being inserted so it auto creates a max heap. When items get deleted from this, they
should stay in the correct order for a heap to be in. Overall, i think the array based method
was easier and more practical to use because it useds less memory to store the data. I also saw
throught my internet searching that a linked based heap isn't very practical or used very often*/
int main()
{	
	cout << "Array Based " << endl;

	MaxHeapArray* arrHeap = new MaxHeapArray(100);
	int* storage = new int[50];

	//random numbers and storage of first 50
	srand(0);
	for (int i = 0; i < 100; i++) {
		int random = (rand() % 100) + 1;
		arrHeap->insertKey(random);
		if (i < 50) {
			storage[i] = random;
		}
	}

	cout << "Full array" << endl; //show full array
	arrHeap->printArray();
	cout << endl;

	cout << "Numbers to be deleted" << endl; //show numbers to be deleted 
	for (int i = 0; i < 50; i++) {
		cout << storage[i] << " ";
	}
	cout << endl;

	//delete numbers
	for (int i = 0; i < 50; i++) {
		arrHeap->deleteKey(storage[i]);
	}
	cout<<endl;

	cout << "Re heaped array" << endl; //show array after it was been re heapded
	arrHeap->printArray();
	cout << endl;
	

	cout << "Link Based" << endl;

	BinarySearchTree* linkedHeap = new BinarySearchTree();
	int* storage2 = new int[50];

	//random numbers and storage
	for (int i = 0; i < 100; i++) {
		int random = (rand() % 100) + 1;
		linkedHeap->addNode(random);
		if (i < 50) {
			storage2[i] = random;
		}
	}
	
	cout << "Full list" << endl; //show full listt
	linkedHeap->printTree();
	cout << endl;

	cout << "Numbers to be deleted" << endl; //show numbers to delete
	for (int i = 0; i < 50; i++) {
		cout << storage2[i] << " ";
	}
	cout << endl;

	//delete numbers
	for (int i = 0; i < 50; i++) {
		linkedHeap->removeNodeByKey(storage2[i]);
	}

	cout << endl;
	cout << "Re heaped list" << endl;//show new list
	linkedHeap->printTree();

	cin.get();
    return 0;
}





// DoublyLinkedList.cpp : Defines the entry point for the console application.
//


#include "stdafx.h"
#include "DLL.h"
#include <iostream>
#include <cstdlib>

using namespace std;


int main()
{
	//Creates list of randoms and displays
	DLL* list = new DLL();
	for (int i = 0; i < 50; i++) {
		int random = (rand() % 100) + 1;
		list->Add(random);
	}
	list->PrintBackwords();
	list->PrintForwards();

	//array that may be to long so it as an arraylength value
	//to store how many numbers are added
	int oddNumbers[50];
	int arrayLength = 0;

	//gets length of list and creates the array of odd numbers
	int listLength = list->getItemCount();
	for (int i = 0; i < listLength; i++) {
		int num = list->GetEntryAt(i);
		if ((num % 2) != 0) {
			oddNumbers[arrayLength] = num;
			arrayLength++;
		}
	}

	//displays odd number array
	cout << "Odd numbers Array" << endl;
	for (int i = 0; i < arrayLength; i++) {
		cout << oddNumbers[i] << " ";
	}
	cout << endl;
	cout << endl;

	//removes odd numbers from list
	for (int i = 0; i < arrayLength; i++) {
		list->Remove(oddNumbers[i]);
	}

	//displays new list forward and backwords
	list->PrintBackwords();
	list->PrintForwards();
	cin.get();
	cin.get();

    return 0;
}


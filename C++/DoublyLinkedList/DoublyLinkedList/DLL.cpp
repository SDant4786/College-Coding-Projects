//DLL class
#include "stdafx.h"
#include "DLL.h"
#include <iostream>

using namespace std;

struct Node {
	Node* prev;
	Node* next;
	int data;
};
Node* head;
int itemCount;

//Blank constructor
DLL::DLL(){
	head = nullptr;
	itemCount = 0;
}

//Add to list
void DLL:: Add(int data) {

    Node* newNode = new Node();
	newNode->data = data;

	if (head == NULL) {
		newNode->next = newNode->prev = newNode;
		head = newNode;
		itemCount++;
	}
	else {
		struct Node* last = head->prev;
		newNode->next = head;
		head->prev = newNode;
		newNode->prev = last;
		last->next = newNode;
		itemCount++;
	}
	
}

//Removes from list
void DLL::Remove(int data) {
	//Creates searcher node to travers ring and find value
    Node* searcher = head;
    Node* prev, *next;
	int count = 0;
	while ((searcher->data != data) && (count < itemCount)) {
		searcher = searcher->next;
		count++;
	}
	if (count == itemCount) {
		cout << "Item not in list" << endl;
	}
	else {
		//Assigns prev/next pointers to prev/next of searcher
		//deletes searcher and links the prev/next to each other
		prev = searcher->prev;
		next = searcher->next;
		delete searcher;
		prev->next = next;
		next->prev = prev;
		itemCount--;
	}
	
}

//Backwords print
void DLL::PrintBackwords() {
	cout << "Print Backwords" << endl;
	Node* travers = head->prev;
	Node* last = head->prev;
	travers = travers->prev;
	while (travers->prev != last->prev) {
		cout << travers->data << " ";
		travers = travers->prev;
	}
	cout << endl;
	cout << endl;
}//end printbackwords

//forwards print
void DLL::PrintForwards() {
	cout << "Print forwards" << endl;
	Node* travers = head;
	while(travers->next!= head){
		cout << travers->data << " ";
		travers = travers->next;
	}
	cout << endl;
	cout << endl;
}//end printforwards

//returns entry at given positon
int DLL::GetEntryAt(int position) {
	Node* travers = head;
	int count = 0;
	while (count != position) {
		travers = travers->next;
		count++;
	}
	return travers->data;
}

int DLL :: getItemCount() {
	return itemCount;
}
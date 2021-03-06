// MyBinarySearchTree.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include "BinarySearchTree.h"
#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
	srand(0);
	BinarySearchTree* tree = new BinarySearchTree();
	for (int i = 0; i < 10000; i++) {
		int random = (rand() % 100000) + 1;
		tree->addNode(random);
		if (i == 0) {
			cout << random << endl;
		}
		if (i == 499) {
			cout << random << endl;
		}
		if (i == 4999) {
			cout << random << endl;
		}
		if (i == 9999) {
			cout << random << endl;
		}
	}
	cout << endl;
	cout << "Entry number 1: " << tree->searchByKey(0) << " in " << tree->getSearchCount() << " searches" << endl;
	cout << "Entry number 500: " << tree->searchByKey(499) << " in " << tree->getSearchCount() << " searches" << endl;
	cout << "Entry number 5,000: " << tree->searchByKey(4999) << " in " << tree->getSearchCount() << " searches" << endl;
	cout << "Entry number 10,000: " << tree->searchByKey(9999) << " in " << tree->getSearchCount() << " searches" << endl;

	cout << "Item outside of range: " << tree->searchByData(12000) << " in " << tree->getSearchCount() << " searches" << endl;

	cout << "Item in range but not in tree: " << tree->searchByData(1) << " in " << tree->getSearchCount() << " searches" << endl;
	cin.get();
    return 0;
}


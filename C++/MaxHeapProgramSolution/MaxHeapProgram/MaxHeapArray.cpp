//MaxHeap.cpp

#include "stdafx.h"
#include "MaxHeapArray.h"
#include <iostream>
using namespace std;

MaxHeapArray::MaxHeapArray(int maxSize) 
{
	heapSize = 0;
	maxSize = maxSize;
	heapArray = new int[maxSize];
}

void MaxHeapArray::MaxHeapify(int index) 
{
	int l = getLeft(index);
	int r = getRight(index);
	int largest = index;

	if (l<heapSize && heapArray[l]>heapArray[largest]) {
		largest = l;
	}
	if (r<heapSize && heapArray[r]>heapArray[largest]) {
		largest = r;
	}
	if (largest != index) {
		swap(&heapArray[index], &heapArray[largest]);
		MaxHeapify(largest);
	}
}

//shrinks the array by 1 and moves items accordingly 
int MaxHeapArray::extractMax()
{
	if (heapSize <= 0) {
		return INT_MAX;
	}
	if (heapSize == 1) {
		heapSize--;
		return heapArray[0];
	}

	int root = heapArray[0];
	heapArray[0] = heapArray[heapSize - 1];
	heapSize--;
	MaxHeapify(0);

	return root;
}

//used during adding of items to array and heapifying
void MaxHeapArray::increaseKey(int index, int newIndex)
{
	heapArray[index] = newIndex;
	while (index != 0 && heapArray[getParent(index)] > heapArray[index]) {
		swap(&heapArray[index], &heapArray[getParent(index)]);
		index = getParent(index);
	}
}

//delete item from aray
void MaxHeapArray::deleteKey(int index)
{
	increaseKey(index, INT_MIN);
	extractMax();
}

//add item to array
void MaxHeapArray::insertKey(int key)
{

	heapSize++;
	int i = heapSize - 1;
	heapArray[i] = key;

	while (i != 0 && heapArray[getParent(i)] < heapArray[i]) {
		swap(&heapArray[i], &heapArray[getParent(i)]);
		i = getParent(i);
	}
}

//swap function
void MaxHeapArray::swap(int * x, int * y)
{
	int temp = *x;
	*x = *y;
	*y = temp;
}

//print function
void MaxHeapArray::printArray()
{
	for (int i = 0; i < heapSize; i++) {
		cout << heapArray[i] << " ";
	}
	cout << endl;
}

//get methods
int MaxHeapArray::getParent(int index) { return (index - 1) / 2; }

int MaxHeapArray::getLeft(int index) { return(2 * index + 1); }

int MaxHeapArray::getRight(int index) { return(2 * index + 1); }

int MaxHeapArray::getMax() { return heapArray[0]; }
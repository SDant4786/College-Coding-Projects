//MaxHeap.H

class MaxHeapArray {
private:
	int *heapArray;
	int maxSize;
	int heapSize;
public:
	MaxHeapArray(int maxSize);
	void MaxHeapify(int index);
	int extractMax();
	void increaseKey(int index, int newIndex);
	void deleteKey(int index);
	void insertKey(int key);
	void swap(int *x, int *y);
	void printArray();

	int getParent(int index);
	int getLeft(int index);
	int getRight(int index);
	int getMax();
};
//Binary Search Tree header

class BinarySearchTree {

public:

	BinarySearchTree();
	void addNode(int data);
	void removeNodeByKey(int key);
	void removeNodeByData(int data);
	int searchByKey(int key);
	int searchByData(int data);
	void printTree();
	int getSearchCount();
	int getItemCount();

};

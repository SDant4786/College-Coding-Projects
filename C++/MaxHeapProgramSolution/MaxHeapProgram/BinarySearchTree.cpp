
//Binary Search Tree .cpp
#include "stdafx.h"
#include "BinarySearchTree.h"
#include <iostream>

using namespace std;
struct Node {
	int data;
	int key; //Order in which each node is added
	Node* leftChild;
	Node* rightChild;


};
Node* root; 
int itemCount; //used to store the order things are added since the insert function sorts as it inserts
int searchCount;
//internal for recursion
Node* internalAddNode(int data, Node * travers, int itemCount)
{
	if (travers == nullptr) {
		//Node creation
		Node* newNode = new Node();
		newNode->data = data;
		newNode->key = itemCount;
		newNode->leftChild = nullptr;
		newNode->rightChild = nullptr;
		return newNode;
	}

	//sort and insert by key
	else if (data > travers->data) {
		travers->leftChild = internalAddNode(data, travers->leftChild, itemCount);
	}
	else if (data < travers->data) {
		travers->rightChild = internalAddNode(data, travers->rightChild, itemCount);
	}
	return travers;

}
Node* minValue(Node* node) {
	Node* current = node;

	while (current->leftChild != nullptr) {
		current = current->leftChild;
	}
	return current;
}

Node* internalRemoveNodeByKey(int key, Node* travers) {
	if (travers == nullptr)
		return travers;
	if (key > travers->data) {
		travers->leftChild = internalRemoveNodeByKey(key , travers->leftChild);
	}
	else if (key < travers->data) {
		travers->rightChild = internalRemoveNodeByKey(key, travers->rightChild);
	}

	else {
		if (travers->leftChild == nullptr) {
			Node* temp = travers->rightChild;
			delete travers;
			return temp;
		}
		else if (root->rightChild == nullptr) {
			Node* temp = travers->leftChild;
			delete travers;
			return temp;
		}
		else {
			Node* temp = minValue(travers);

			travers->key = temp->key;

			travers->rightChild = internalRemoveNodeByKey(temp->key, travers->rightChild);
		}
	}
	return travers;
};

Node* internalRemoveNodeByData(int data, Node* travers) {
	if (travers == nullptr) return travers;
	if (data > travers->data)
		travers->leftChild = internalRemoveNodeByData(data, travers);
	else if (data < travers->data)
		travers->rightChild = internalRemoveNodeByData(data, travers);
	else {
		if (travers->leftChild == nullptr) {
			Node* temp = travers->rightChild;
			delete travers;
			return temp;
		}
		else if (travers->rightChild == nullptr) {
			Node*temp = travers->leftChild;
			delete travers;
			return temp;
		}
		Node*temp = minValue(travers->rightChild);

		travers->data = temp->data;
		travers->rightChild = internalRemoveNodeByData(temp->data, travers->rightChild);
	}
}

Node* internalSearchByKey(int key, Node* travers) {
	
	while (travers != nullptr) {
		searchCount++;
		if (travers->key == key) {
			return travers;
		}
		else if (key > travers->key) {
			travers = travers->rightChild;
		}
		else if (key < travers->key)
			travers = travers->leftChild;
		
	}
};

void internalPrint(Node* travers) {
	if (travers != nullptr) {

		internalPrint(travers->leftChild);
		cout << travers->data << " ";
		internalPrint(travers->rightChild);
	}
};

int internalSearchByData(int data, Node* travers) {
	//In order traversal modified to search for key
	if (travers != nullptr) {
		searchCount++;
		internalSearchByData(data, travers->leftChild);
		if (travers->data == data) {
			return travers->data;
		}
		internalSearchByData(data, travers->rightChild);
	}
	else
		return -1;
}

BinarySearchTree::BinarySearchTree() {
	root = nullptr;
	itemCount = 0;
};
//just calls the internal method to keep the user from messing with nodes they shouldnt
void BinarySearchTree::addNode(int data) {
	
	root = internalAddNode(data, root, itemCount); //starts at root everytime
	itemCount++;
};
void BinarySearchTree::removeNodeByKey(int key) {
	internalRemoveNodeByKey(key, root);
}
void BinarySearchTree::removeNodeByData(int data)
{
	internalRemoveNodeByData(data, root);
}
int BinarySearchTree::searchByKey(int key)
{   searchCount = 0;
	Node* temp = internalSearchByKey(key, root);
	return temp->data;
}
int BinarySearchTree::searchByData(int data)
{
	searchCount = 0;
	int num = internalSearchByData(data, root);
	if (num != -1) {
		return num;
	}
	else {
		cout << "Item not found" << endl;
		return data;
	}
}
void BinarySearchTree::printTree() {
	internalPrint(root);
	cout << endl;
}

int BinarySearchTree::getSearchCount()
{
	return searchCount;
}

int BinarySearchTree::getItemCount()
{
	return itemCount;
}



//DLL Header

#include "stdafx.h"
class DLL {
private:
	struct Node {
		Node* prev;
		Node* next;
		int data;
	};
	Node* head;
	int itemCount;
public:

	DLL();
	void Add(int data);
	void Remove(int data);
	void PrintForwards();
	void PrintBackwords();
	int GetEntryAt(int position);
	int getItemCount();
};

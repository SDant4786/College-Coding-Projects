//ListExample

#include <iostream>
#include <string>
#include <fstream>
#include <iomanip>
#include <vector>
#include <algorithm>
#include <cassert>
using namespace std;
//listType Class from book
template <class elemType>
class listType{
public:
	//sorts through given index
	void sort();
	//prints index
	void print() const;
	//creates list of single stockType variables;
	void insertAt(const elemType& item, int position);
	//constructor
	listType(int listSize = 50);
	//destructor
	~listType();
	//gets the length of the list
	int getLength() const;
	//gets the maxsize of the list
	int getMaxSize() const;
private:
	int maxSize;
	int length;
	elemType *list;
	string symbol;
	double open, close, high, lose, prevClose, percent, volume; 
};
//constructor
template <class elemType>
listType<elemType>::listType(int listSize) {
	maxSize = listSize;
	length = 0;
	list = new elemType[maxSize];
}
//destructo
template <class elemType>
listType<elemType>::~listType() {
	delete[] list;
}
//sorts through list index
template <class elemType>
void listType<elemType>::sort() {
	int i, j;
	int min;
	elemType temp;
	for (i = 0; i < length; i++) {
		min = i;
		for (j = i + 1; j < length; ++j)
			if (list[j] < list[min])
				min = j;
		temp = list[i];
		list[i] = list[min];
		list[min] = temp;

	}
}
//prints through list index
template <class elemType>
void listType<elemType>::print() const {
	cout << fixed << setprecision(2);
	int i; 
	for (i = 0; i < length; ++i)
		cout << list[i] << " ";
		cout << endl;
	
}
//used to create list
template <class elemType>
void listType<elemType>::insertAt(const elemType& item, int position) {
	assert(position >= 0 && position < maxSize);
	list[position] = item;
	length++;
}
//sets value for potention stockListType object
template <class elemType>
void setValue(string s, double o, double c, double h, double l, double pc, double v) {
	symbol = s;
	open = o;
	close = c;
	high = h;
	low = l;
	percent = pc;
	volume = v;
};
//gets length of list
template <class elemType>
int listType<elemType>::getLength() const {
	return length;
}
//get maxSize of list
template <class elemType>
int listType<elemType>::getMaxSize() const {
	return maxSize;
}
//Class stockType holds inputed Stock data
class stockType {

public:
	// All function declartions are declared here as well to save lines and editing speed
	// setsAll variables to save time
	void setAll(string s, double o, double c, double h, double l, double pc, double p,double v) {
		setSymbol(s, symbol);
		setOpen(o, open);
		setClose(c, close);
		setHigh(h, high);
		setLow(l, low);
		setPrevClose(pc, prevClose);
		setVolume(v, volume);

	}
	// sets stock symbol
	void setSymbol(string s, string symbol) {
		symbol = s;
		
	}
	// sets opening price
	void setOpen(double o, double open) {
		open = o;
	}
	// sets closing price
	void setClose(double c, double close) {
		close = c;
		
	}
	// sets day high
	void setHigh(double h, double high) {
		high =h ;
	}
	// sets day low
	void setLow(double l, double low) {
		low = l;
	}
	// sets previous close
	void setPrevClose(double pc, double prevClose) {
		prevClose = pc;
	}
	// sets share volume
	void setVolume(double v, double volume) {
		volume = v;
	}
	// calculates the percent gain/lost
	double percentCalc(double prevClsoe, double close) {
		percent = ((close / prevClose) - 1) * 100;
		return percent;
	}
	//prints the called stockType object
	void print() {
		cout << fixed << showpoint << setprecision(2);
			cout << setw(5) << symbol << setw(10) << open << setw(10) << close
			<< setw(10) << high << setw(10) << low << setw(10) << prevClose
			<< setw(9) << percent << "%" << setw(10) << volume << endl;
	}
	// constructer
	stockType(string s, double o, double c, double h, double l, double pc,double p, double v) {
		symbol = s;
		open = o;
		close = c;
		high = h;
		low = l;
		prevClose = pc;
		percent = percentCalc(prevClose, close);
			volume = v;
	};
	// Also constructer
	stockType() {
		symbol = s;
		open = o;
		close = c;
		high = h;
		low = l;
		prevClose = pc;
		volume = v;
	}
	// Overloads the insert operator to allow for faster input from file
	friend istream& operator >> (istream& isObject, stockType& myStock) {
		isObject >> myStock.symbol >> myStock.open >> myStock.close >> myStock.high >> myStock.low >> myStock.prevClose >> myStock.volume;
		return isObject;
	}
	// Overlaods the output operator to print the data of stockType object
	friend ostream& operator << (ostream& osObject, const stockType& myStock) {
		cout << fixed << setprecision(2);
		osObject << setw(5) << myStock.symbol << setw(10) << myStock.open << setw(10) << myStock.close
			<< setw(10) << myStock.high << setw(10) << myStock.low << setw(10) << myStock.prevClose
			<< setw(9) << myStock.percent << "%" << setw(10) << fixed << setprecision(0) << myStock.volume << endl;
		return osObject;
	};
	// Used to allow less than comparason between 2 stockType symbol variables
	friend bool operator < (stockType& obj1, stockType& obj2 ) {
		return obj1.symbol < obj2.symbol;
	};
	// Used to allow greater than comparason between 2 stockType percent variables
	friend bool operator  > (stockType& obj1, stockType & obj2) {
		return obj1.percent > obj2.percent;
	}
	

	// variable declaration
	string symbol,s;
	double open;
	double close;
	double high;
	double low;
	double prevClose;
	double volume;
	double percent;
	double o, c, h, l, pc, v;
};
// derived from listType
class stockListType : public listType<stockType> {
	//nothing really here because i changed what i could in the listType class
public:
private:
};
// prints the header for the output
void headerPrint() {
cout << "******************* First Investor's Heaven *****************" << endl;
	cout << "********************** Financial Report**********************" << endl;
	cout << setw(5) << "Stock" << setw(20) << "Today" << setw(30) << "Previous" << setw(10) << "Percent" << endl;
	cout << setw(5) << "Symbol" << setw(9) << "Open" << setw(10) << "Close" << setw(10) << "High" << setw(10) << "Low" <<
		setw(10) << "Close" << setw(10) << "Gain" << setw(10) << "Volume" << endl;
};

int main() {
	//This was my main problem, i couldn't find a way to declare the entire 
	//stockType object into 1 index of the list because of the string and double 
	//variables within the class object
	// declares list type double to store the percent variables for sorting
	listType <double> stockList;
	// delclare list type string to store the symbol variables for sorting
	listType <string> stockString;
	//declares file
	ifstream myFile;
	//some variables
	string s;
	string symbol;
	//used to print the totat closing assets
	double closeAsset;

	
	// these are commented out because the program wont run with them in the code
	// also, according to the book, this should be the set up to assign the data
	//in the file to the different stockType objects but it wasn't working properly
	//
	//inFile.open("");

	// while loop to enter all the data 
	//while (inFile.is_open()){
		//int i = i + 1;

	//close condition
		//if (inFile.eof())
		//	inFile.close();

		//else
	
	// puts data from inFile to myStock object
			//inFile >> myStock;
	//}
	// these are dummy variables i had to use to try and test the code that i could get to work
	// variable format (symbol, open, clode, high, low, prevClose, percent, volume)
		stockType myStock1("ABC", 123.45, 130.95, 132.00, 125.00, 120.0,0, 10000);
		
		stockType myStock2("AOLK", 80, 75, 82, 74, 83,0, 5000);
		
		stockType myStock3("MSET", 120, 140, 145, 140, 115,0, 30920);
		
		stockType myStock4("IBD", 68, 71, 72, 67, 75,0, 15000);
		
		stockType myStock5("CSCO", 100, 102, 105, 98, 101,0, 25000);
		
		//very sloppy for loop to assign the percent value from each stockType object
		//to list for sorting
		//again, if i could've put all the data from one stockType object into a single
		//list index, this would've been a loop and accounted for any number of input
		//data lines through the getlength function and assinging the list size with
		//pointer
		for (int i = 0; i < 2; i++) {
			stockList.insertAt(myStock1.percent, 0);
			stockList.insertAt(myStock2.percent, 1);
			stockList.insertAt(myStock3.percent, 2);
			stockList.insertAt(myStock4.percent, 3);
			stockList.insertAt(myStock5.percent, 4);
			i++;
		}
		//same as previous one, just useing the stock symbol as the variable to be sorted
		for (int i = 0; i < 2; i++) {
			stockString.insertAt(myStock1.symbol, 0);
			stockString.insertAt(myStock2.symbol, 1);
			stockString.insertAt(myStock3.symbol, 2);
			stockString.insertAt(myStock4.symbol, 3);
			stockString.insertAt(myStock5.symbol, 4);
		}
		//again, very sloppy because the myStock objects aren't in a list
		//it would've been easy to cycle this throug a for loop if there where in a list
		closeAsset = ((myStock1.close*myStock1.volume) + (myStock2.close*myStock2.volume) +
			(myStock3.close*myStock3.volume) + (myStock4.close*myStock4.volume) + (myStock5.close*myStock5.volume));
	//sorts just the percent values
		stockList.sort();
		//sorts just the symbol values
		stockString.sort();
		//prints header
		headerPrint();
		//sloppy for the same reasons as all the slop
		cout << myStock1 << myStock2 << myStock3 << myStock4 << myStock5;
		// sets precision to 2 for the closing assets variable
		cout << fixed << setprecision(2);
		cout << "Clossing Assets =  $" << closeAsset << endl;
		//header again
		headerPrint();
		//prints just the sorted percent gain/loss
		stockList.print();
		//header once more
		headerPrint();
		//prints just the sorted stock symbol
		stockString.print();
		//just hit a couple key to exit program
		cin.get();
		cin.get();
		return 0;
	};

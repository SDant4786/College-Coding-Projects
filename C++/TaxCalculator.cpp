//Tax Calculator

#include <iostream>
#include <string>
#include <cmath>
#include <iomanip>

using namespace std; 

char maritalStatus, close;
double salary, pension, taxableIncome, totalTax, children, childrenPlusAdults;
void getData(char maritalStatus, double children, double salary, double pension);
double taxAmount(double salary, double childrenPlusAdults, double pension, char maritalStatus, double taxableIncome, double children, double totalTax);
int main()
{
// main program loop
	do {
		cout << setprecision(2) << fixed << endl;
		getData(maritalStatus, children, salary, pension);
		cout << "Enter N to terminate program, enter any other key to run again" << endl;
		cin >> close;
	} while ((close != 'N') && (close != 'n'));
	
}
//gets data from user
void getData(char maritalStatus, double children, double salary, double pension)
	{
	//loops till valid input	
	do {
			cout << "Please enter M for married or S for single" << endl;
			cin >> maritalStatus; 
			//for single
			if ((maritalStatus == 'S') || (maritalStatus == 's')){
				cout << "Please enter your gross salary" << endl;
				cin >> salary;
				cout << "Please enter percentage of gross income contributed to a pension fund" << endl;
				//loops till valid pension input 
				do {
					cin >> pension;
					if (pension >= 6.01){
						cout << "Error, please enter a percentage less than 6.01" << endl;
					}
				} while (pension >= 6.01);
			}
			//for married 
			else if ((maritalStatus == 'm') || (maritalStatus == 'M')) {
				cout << "Please enter number of children under the age of 14" << endl;
				cin >> children;
				cout << "Please enter combined gross salary" << endl;
				cin >> salary;
				cout << "Please enter percentage of gross income contributed to a pension fun" << endl;
				//loops till valid pension input
				do {
					cin >> pension;
					if (pension >= 6.01)
					{
						cout << "Error, please enter a percentage less than 6.01" << endl;
					}
				} while (pension >= 6.01);
			}
			else
				cout << "Error, please enter S for single or M for married" << endl;	
		}
	//loop conditions for single/married inputs	
	while ((((maritalStatus != 's') && (maritalStatus != 'S') && (maritalStatus != 'm') && (maritalStatus != 'M'))));
		//calls taxAmount function
		cout << "Total federal tax was " << (double)taxAmount(salary, childrenPlusAdults, pension, maritalStatus, taxableIncome, children, totalTax) << endl;
	}
// taxamount function
double taxAmount(double salary, double childrenPlusAdults, double pension, char maritalStatus, double taxableIncome, double children, double totalTax)
{
	//takes pension from percentage to decimal
	pension = pension / 100;
	// taxable income for single person
	if ((maritalStatus == 's') || (maritalStatus == 'S')) {
		taxableIncome = taxableIncome * (1 - pension);
		taxableIncome = salary - 5500;
	}
	// taxable income for a married couple
	if ((maritalStatus == 'm') || (maritalStatus == 'M')) {
		childrenPlusAdults = 2 + children;
		taxableIncome = taxableIncome * (1.00 - pension);
		taxableIncome = salary - 7000 - (childrenPlusAdults * 1500);
	}
	//tax bracket <= 15000
	if ((taxableIncome >= 0) && (taxableIncome <= 15000)) {
		totalTax = taxableIncome * .15;
	}
	//tax bracket >= 15001 and <= 40000
	if ((taxableIncome >= 15001) && (taxableIncome <= 40000)) {
		totalTax = 2250 + ((taxableIncome -15000)*.25);
	}
	//tax brackt >= 40001
	if (taxableIncome >= 40001) {
		totalTax = 8460 + ((taxableIncome- 40000)*.35);
	}
	return totalTax;
}
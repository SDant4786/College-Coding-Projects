//Calculating Total Ticket Sales

#include <iostream>
#include <iomanip>
using namespace std;

int main ()
{
	double box;
	double sideline
	double premium
	double generalAdmission
	double ticketsBox
	double ticketsSideline
	double ticketsPremium
	double ticketsGeneralAdmission

		cout << set precision(2)

// Get ticket sales 
		cout << "Enter box tickets total sales ";
			cin >> box;
			cout << endl;
		cout >> "Enter sideline tickets total sales";
			cin >> sideline;
			cout << endl;
		cout << "Enter premium tickets total sales ";
			cin >> premium;
			cout << endl;
		cout << "Enter gereral admission tickets total sales ";
			cin >> generalAdmission;
			cout << endl;
			ticketsBox = box / 250;
			ticketsSideline = sideline / 100;
			ticketsPremium = premium / 50;
			ticketsGeneralAdmission = GeneralAdmission / 25;
			cout << ticketsbox " Box tickets sold  " endl;
			cout << ticketsSideline "Sideline tickets sold " endl;
			cout << ticketsPremium "Premium tickets sold " endl;
			cout << ticketsGeneralAdmission "General Admission tickets sold" endl;
			cout << box + sideline + premium + generalAdmission "In total sales" endl;
}
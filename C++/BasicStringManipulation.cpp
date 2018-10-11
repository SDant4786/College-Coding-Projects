//Basic string maninpulation

#include <iostream>
#include <string>

using namespace std; 

string input;
char *uInput;
int i;
char close; 
int main() {
	//loop for program
	do {
		//get string
		cout << "Enter a string or sentance" << endl;
		getline(cin, input);
		//assign uInput array to length of entered string/sentance
		uInput = new char[input.length()];
		//changes all characters to uppercase and assigns them to the index locations of uInput
		for (i = 0; i <= input.length(); i++) {
			input[i] = toupper(input[i]);
			uInput[i] = input[i];
		}
		//outputs the uppercase character array
		cout << uInput << endl;
		//asks to run again
		cout << "To run again, enter any key. To end, enter n/N" << endl;
		cin >> close;
		//used to get rid of character buffer for get.line 
		cin.ignore();
	//end conditions
	} while ((close != 'n') && (close != 'N'));
	return 0;
}
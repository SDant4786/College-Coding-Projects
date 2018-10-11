#include <iostream>
#include <string>


using namespace std;
string word;
int digitCounter;
int stringLength;
int i;
string phoneNumber;
string newWord;
char yes;
char choice;


	int main()
{	//Loop for whole program
	do {
	digitCounter = 0;
	word = "";
	phoneNumber = "";
	newWord = "";
	cout << "Enter word(s) to become a phone number" << endl;
	getline(cin, word);
	stringLength = word.length();
	//removes spaces
	for (i = 0; i < stringLength; i++) {
		if (word[i] == ' ') {
			word.erase(i, 0);
		}
		else {
			newWord += word[i];
		}
	}
	if (newWord.length() < 7) {
		cout << "Error, must enter at least 7 characters" << endl;
		getline(cin, word);
	}
	stringLength = newWord.length();
	//convertes all characters to lowercase
	for (i = 0; i < stringLength; i++)
	{
		newWord[i] = tolower(newWord[i]);
	}
	word = newWord;
	//index back to 0
	i = 0;
	//turning letters to digits
	while (phoneNumber.length() < 8) {
		//adds the dash after the third number
		if (phoneNumber.length() == 3) {
			phoneNumber += '-';;
		}
		//2
		else if (word[i] == 'a' || word[i] == 'b' || word[i] == 'c') {
			phoneNumber += '2';
			i++;
		}
		//3
		else if (word[i] == 'd' || word[i] == 'e' || word[i] == 'f') {
			phoneNumber += '3';
			i++;
		}
		//4
		else if (word[i] == 'g' || word[i] == 'h' || word[i] == 'i') {
			phoneNumber += '4';
			i++;
		}
		//5
		else if (word[i] == 'j' || word[i] == 'k' || word[i] == 'l') {
			phoneNumber += '5';
			i++;
		}
		//6
		else if (word[i] == 'm' || word[i] == 'n' || word[i] == 'o') {
			phoneNumber += '6';
			i++;
		}
		//7
		else if (word[i] == 'p' || word[i] == 'q' || word[i] == 'r' || word[i] == 's') {
			phoneNumber += '7';
			i++;
		}
		//8
		else if (word[i] == 't' || word[i] == 'u' || word[i] == 'v') {
			phoneNumber += '8';
			i++;
		}
		//9
		else if (word[i] == 'w' || word[i] == 'x' || word[i] == 'y' || word[i] == 'z') {
			phoneNumber += '9';
			i++;
		}
		//account for none number charcters
		else
			i++;


	}

	cout << "The words you typed created this phone number" << endl;
	cout << phoneNumber << endl;
	cout << "To try another word press any key" << endl;
	cout << "To terminate type 'n' or 'N'" << endl;
	cin >> choice;
	yes = choice;
	if (yes == 'n' || yes == 'N') {
		break;
	}
	cin.get();
	} while (true);
	
	return 0;
	
}
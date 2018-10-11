//Counts numbers in a given range

#include <iostream>

using namespace std;

int scores[26]{76,89,150,135,200,76,12,100,150,28,187,189,167,200,175,150,87,99,129,149,176,200,87,35,157,189};
int i;
//r1 = 0-24
//r2 = 25-49
//r3 = 50-74
//r4 = 75-99
//r5 = 100-124
//r6 = 125-149
//r7 = 150-174
//r8 = 175-200
int r1, r2, r3, r4, r5, r6, r7, r8;
int main() {
	r1 = 0;
	r2 = 0;
	r3 = 0;
	r4 = 0;
	r5 = 0;
	r6 = 0;
	r7 = 0;
	r8 = 0;
	for (i = 0; i < 26; i++) {
		// r1 0-24
		if (scores[i] <= 24) {
			r1++;
		}
		// r2 25-49
		if ((scores[i] >= 25) && (scores[i] <= 49)) {
			r2++;
		}
		// r3 50-74
		if ((scores[i] >= 50) && (scores[i] <= 74)) {
			r3++;
		}
		// r4 75-99
		if ((scores[i] >= 75) && (scores[i] <= 99)) {
			r4++;
		}
		// r5 100-124
		if ((scores[i] >= 100) && (scores[i] <= 124)) {
			r5++;
		}
		// r6 125-149
		if ((scores[i] >= 125) && (scores[i] <= 149)) {
			r6++;
		}
		// r7 150-174
		if ((scores[i] >= 150) && (scores[i] <= 174)) {
			r7++;
		}
		// r8 175-200
		if ((scores[i] >= 175) && (scores[i] <= 200)) {
			r8++;
		}
	}
	// printing results 
	cout << "Number of students in score range between 0-24 " << r1 << endl;
	cout << "Number of students in score range between 25-49 " << r2 << endl;
	cout << "Number of students in score range between 50-74 " << r3 << endl;
	cout << "Number of students in score range between 75-99 " << r4 << endl;
	cout << "Number of students in score range between 100-124 " << r5 << endl;
	cout << "Number of students in score range between 125-149 " << r6 << endl;
	cout << "Number of students in score range between 150-174 " << r7 << endl;
	cout << "Number of students in score range between 175-200 " << r8 << endl;
	
	cin.get();
	cin.get();

	return 0;
}

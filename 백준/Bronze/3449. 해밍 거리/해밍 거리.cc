#include <iostream>
using namespace std;

int main() {
	string num1;
	string num2;
	int t;
	cin >> t;
	
	for(int i=0; i<t; i++){
		cin >> num1 >> num2;
		int cnt = 0;
		for(int j=0; j<num1.length(); j++){
			if(num1[j] != num2[j]) cnt++;
		}
		cout << "Hamming distance is " << cnt << "." << endl;
	}
}
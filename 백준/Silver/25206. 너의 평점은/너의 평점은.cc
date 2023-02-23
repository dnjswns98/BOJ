#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	string str, rate;
	double n , sum = 0, grade = 0;

	for (int i = 0; i < 20; i++) {
		cin >> str >> n >> rate;
		if (rate == "P") continue;
		sum += n;
		if (rate == "A+") grade += n * 4.5;
		else if (rate == "A0") grade += n * 4.0;
		else if (rate == "B+") grade += n * 3.5;
		else if (rate == "B0") grade += n * 3.0;
		else if (rate == "C+") grade += n * 2.5;
		else if (rate == "C0") grade += n * 2.0;
		else if (rate == "D+") grade += n * 1.5;
		else if (rate == "D0") grade += n * 1.0;
		else if (rate == "F") grade += n * 0.0;
		
	}
	cout.precision(7);
	cout << grade / sum;
}
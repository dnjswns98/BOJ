#include <iostream>
using namespace std;

int main() {
	int k, sum = 0;
	int num[5] = { 0 };

	for (int i = 0; i < 5; i++) {
		cin >> k;
		num[i] = k;
		sum += k;
	}

	for (int i = 0; i < 5; i++) {
		int min = i;
		for (int j = i + 1; j < 5; j++) {
			if (num[min] > num[j])
				min = j;
		}
		int temp = num[i];
		num[i] = num[min];
		num[min] = temp;
	}

	cout << sum / 5 << endl << num[2];

}
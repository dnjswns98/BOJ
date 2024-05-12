#include <iostream>
#include <string.h>

using namespace std;

int arr[100001];

int main(void) {
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		cin >> n;
		memset(arr, 0, sizeof(arr));
		int min = 100000;
		int num;
		for (int i = 0; i < n; i++) {
			cin >> num;
			if (num >= 0) {
				arr[num]++;
				if (min > num) min = num;
			}
			else {
				int temp = -num;
				arr[temp]++;
				if (min > temp) min = temp;
			}
		
		}
		cout << "#" << test_case << " " << min << " " << arr[min] << "\n";
	}
}
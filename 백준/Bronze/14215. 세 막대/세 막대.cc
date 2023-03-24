#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int arr[3];
	cin >> arr[0] >> arr[1] >> arr[2];
	sort(arr, arr + 3);
	if (arr[0] + arr[1] > arr[2]) cout << arr[0] + arr[1] + arr[2];
	else {
		cout << arr[0] + arr[1] + arr[0] + arr[1] - 1;
	}
	
	
	
}
#include <iostream>
#include <cmath>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int t, a, b;
    cin >> t;
	int arr[5] = { 1 };
	for(int i = 1;  i<= t; i++) {
		cin >> a >> b;
		for(int j = 1;  j<=4; j++){
			arr[j] = (arr[j - 1] * a) % 10;
			if (arr[j] == 0) arr[j] = 10;
		}
		int tmp = b % 4;
		if (tmp == 0) cout << arr[4] << "\n";
		else cout << arr[tmp] << "\n";
	}
}
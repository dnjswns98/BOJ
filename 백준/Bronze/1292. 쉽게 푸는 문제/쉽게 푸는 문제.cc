#include <iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	
	int a, b;
	cin >> a >> b;
	int arr[1001];
	int n = 1;
	int i = 1;
	while(n <= 1000){
		for (int j = 0; j < i; j++) {
			arr[n++] = i;
			if (n > 1000) break;
		}
		i++;
	}
	int sum = 0;
	for (int j = a; j <= b; j++) {
		sum += arr[j];
	}
	cout << sum;
}
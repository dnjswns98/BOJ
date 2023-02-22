#include <iostream>
#include <string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n, m;
	int arr[100];
	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		arr[i] = i;
	}
	int begin, end, mid;
	for (int i = 0; i < m; i++) {
		cin >> begin >> end >> mid;
		for (int j = mid; j <= end; j++) {
			int start = begin + 1;
			int temp = arr[begin];
			arr[begin++] = arr[j];
			while (start <= j) {
				int tmp = arr[start];
				arr[start++] = temp;
				temp = tmp;
				//cout << arr[1] << " " << arr[2] << " " << arr[3] << " " << arr[4] << " " << arr[5] << " " << arr[6] <<"\n" ;
			}
			
		}
		
	}

	for (int i = 1; i <= n; i++) {
		cout << arr[i] << " ";
	}
}
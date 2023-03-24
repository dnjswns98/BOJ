#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int a, b, c;
	while (1) {
		cin >> a >> b >> c;
		int max = a;
		if (max < b && b > c) max = b;
		else if (max < c && c > b) max = c;
		
		if (a == 0 && b == 0 && c == 0) break;
		else if (max >= b + c || max >= a + b || max >= a + c) cout << "Invalid\n";
		else if (a == b && b == c) cout << "Equilateral\n";
		else if ((a == b && a != c) || (a == c && b != c) || (b == c && a != b)) cout << "Isosceles\n";
		else if (a != b && b != c && a != c) cout << "Scalene\n";
	}
	
	
	
}
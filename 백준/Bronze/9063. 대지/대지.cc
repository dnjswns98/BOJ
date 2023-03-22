#include <iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	int x, y;
	int minX = 10000, maxX = -10000;
	int minY = 10000, maxY = -10000;
	for (int i = 0; i < n; i++) {
		cin >> x >> y;
		if (x < minX)
			minX = x;
		if (y < minY)
			minY = y;
		if (x > maxX)
			maxX = x;
		if (y > maxY)
			maxY = y;
	}
	cout << (maxX - minX) * (maxY - minY);
}
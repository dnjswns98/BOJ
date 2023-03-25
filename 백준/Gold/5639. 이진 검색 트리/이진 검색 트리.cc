#include <iostream>
#include <vector>
using namespace std;

vector<int> preorder;

void postorder(int start, int end) { //0 9 -> 1 6 -> 2 5 -> 3 4 (5) -> 4 5 (28) ->
	if (start >= end ) return;

	int root = preorder[start];
    
	int rightidx = start + 1;
	for (int i = start + 1; i < end; i++) {
		if (root < preorder[i]) {
			rightidx = i;
			break;
		}
	}
	postorder(start + 1, rightidx); //1 5, 2 4, 3 3
	postorder(rightidx, end); //3 4
	cout << root << "\n";
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);


	int tmp;
	while(cin >> tmp) {
		if (tmp == -1) break;
		preorder.push_back(tmp);
	}

	postorder(0,preorder.size());
}
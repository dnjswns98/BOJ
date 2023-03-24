#include <iostream>
#include <vector>
using namespace std;

vector<int> inorder;
vector<int> postorder;

void preorder(int startin, int endin, int startpost, int endpost) {
	if (startin > endin || startpost > endpost) return;

	int root = postorder[endpost];
	int rootidx;
	for (int i = 0; i <= endin; i++) {
		if (inorder[i] == root) {
			rootidx = i;
			break;
		}
	}
	int leftsize = rootidx - startin;

	cout << root << " ";
	preorder(startin, rootidx - 1, startpost, startpost + leftsize - 1);
	preorder(rootidx + 1, endin, startpost + leftsize, endpost - 1);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		inorder.push_back(tmp);
	}
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		postorder.push_back(tmp);
	}

	preorder(0, n - 1, 0, n - 1);
	
}
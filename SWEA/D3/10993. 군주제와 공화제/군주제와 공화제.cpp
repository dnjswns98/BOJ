#include<iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{	
		int n;
		cin >> n;

		int x[1000], y[1000], s[1000], result[1000];
		for (int i = 0; i < n; i++) {
			cin >> x[i] >> y[i] >> s[i];
		}

		for (int i = 0; i < n; i++) {
			float max = 0;
			int cnt = 0;
			int maxidx;
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				float dist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
				if (s[i] < s[j]/dist) {
					if (max < s[j] / dist) {
						max = s[j] / dist;
						maxidx = j;
						cnt = 1;
					}
					else if (max == s[j] / dist)
						cnt = 2;
				}
			}

			if (cnt == 0) result[i] = -2; //군주제
			else if (cnt > 1) result[i] = -1; //공화제
			else result[i] = maxidx;
		}
		cout << "#" << test_case << " ";
		for (int i = 0; i < n; i++) {
			if (result[i] == -2) cout << "K ";
			else if (result[i] == -1) cout << "D ";
			else {
				while (result[result[i]] != -2) {
					result[i] = result[result[i]];
				}
				cout << result[i] + 1 << " ";
			}
		}
		cout << "\n";
	}
	return 0;
}
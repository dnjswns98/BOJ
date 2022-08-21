#include <iostream>
#include <vector>
#include <queue>
using namespace std;

//참고 : https://www.crocus.co.kr/625
/*
문제 해결에 필요한 사항
1. 최대 힙, 최소 힙
2. Priority Queue
3. pq로 중간 값 구하는 방식
	1. 최대 힙의 크기는 최소 힙의 크기와 같거나, 하나 더 크다.
	2. 최대 힙의 최대 원소는 최소 합의 최소 원소보다 작거나 같다.
	이때 알고리즘에 맞지 않다면 최대 힙, 최소 힙의 가장 위의 값을 swap해준다.
	[결과] 이때 이 두가지 규칙을 유지해 준다면 항상 최대 힙 top값이 중간값이 된다.
*/

struct compare {
	bool operator()(int a, int b) {
		return a > b;
	}
};

int main() {
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	int n;
	cin >> n;
	priority_queue<int> q1;
	priority_queue<int, vector<int>, compare> q2;
	int tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		if (!q1.empty()) {
			if (q1.size() >= q2.size() + 1) {
				if (q1.top() < tmp) {
					q2.push(tmp);
				}
				else {
					q2.push(q1.top());
					q1.pop();
					q1.push(tmp);
				}
			}
			else {
				if (tmp > q2.top()) {
					q1.push(q2.top());
					q2.pop();
					q2.push(tmp);
				}
				else q1.push(tmp);
			}
		}
		if (q1.empty()) {
			q1.push(tmp);
		}
		cout << q1.top() << "\n";
	}
}
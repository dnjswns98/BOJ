#include <iostream>
using namespace std;
#define max 15

int n, cnt = 0;
int arr[max]; //arr[0] = 2 일경우 0번째행에서 2번째에 퀸이 위치해있다 == arr[0][2]

bool check(int x) {
	for (int i = 0; i < x; i++) {
		if (arr[i] == arr[x] || abs(arr[i] - arr[x]) == x - i) { //퀸과 동일선상 or 대각선에 있는지 검사
			return false;
		}
	}
	return true;
}

void queen(int x) {
	if (x == n) {
		cnt++;
		return;
	}
	for (int i = 0; i < n; i++) {
		arr[x] = i; //퀸을 배치
		if (check(x)) //배치한 퀸이 공격받는지 검사
			queen(x + 1); //공격받지않으면 x값을 증가시켜 다음 행에서 퀸의 위치를 찾는다.
	}
}

int main() {
	cin >> n;
	queen(0);
	cout << cnt;
}
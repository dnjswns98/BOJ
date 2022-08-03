#include <iostream>
#include <vector>
#include <utility>
using namespace std;
#define max 9

int cnt = 0;
int arr[max][max];
bool found = false;
vector<pair<int, int>> vp;

void print() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
}

bool check(int i, int x) {
	for (int j = 0; j < 9; j++) {
		if (j != vp[x].second) { //자기 자신 제외
			if (i == arr[vp[x].first][j]) { //가로 검사
				return false;
			}
		}
		if (j != vp[x].first) {
			if (i == arr[j][vp[x].second]) { //세로 검사
				return false;
			}
		}
	}

	int divx = vp[x].first / 3; //작은 정사각형 구역
	int divy = vp[x].second / 3;
	for (int j = 3 * divx; j < 3 * (divx + 1); j++) {
		for (int h = 3 * divy; h < 3 * (divy + 1); h++) {
			if (j == vp[x].first && h == vp[x].second)
				continue;
			if (i == arr[j][h])
				return false;
		}
	}
	return true;
}

void sudoku(int x) {
	if (x == cnt) {
		print();
		found = true;
		return;
	}
	for (int i = 1; i <= 9; i++) {
		arr[vp[x].first][vp[x].second] = i; //비워져있는 스도쿠에 임의의 값 넣음
		if (check(i, x)) { //중복체크
			sudoku(x + 1);
		}
		if (found) //스도쿠가 완성되었을 경우 함수 종료
			return;
	}
	arr[vp[x].first][vp[x].second] = 0; //최적값을 못찾았을 경우 비워줘야한다.
	//비워주지않으면 return한 후 값을 넣고나서 check를 할 때 문제가 생긴다.
	return;
}

int main() {
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> arr[i][j];

			if (arr[i][j] == 0) {
				cnt++;
				vp.push_back(make_pair(i, j)); //비워져 있는 스도쿠의 좌표 기억하기
			}
		}
	}
	sudoku(0);
}
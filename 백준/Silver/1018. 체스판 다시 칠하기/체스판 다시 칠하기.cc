#include <iostream>
#include <string>
#include <vector>
using namespace std;

string WB[8] = {
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW"
};
string BW[8] = {
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB",
        "BWBWBWBW",
        "WBWBWBWB"
};
string board[50];

int WB_cnt(int x, int y) 
{
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (BW[i][j] != board[i + x][j + y])
                cnt++;
        }
    }
    return cnt;
}
int BW_cnt(int x, int y) 
{
    int cnt = 0;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (WB[i][j] != board[i + x][j + y])
                cnt++;
        }
    }
    return cnt;
}

int main()
{
    int cntW, cntB, min=9999;
	pair<int, int> p1;

	cin >> p1.first >> p1.second;

    for (int i = 0; i < p1.first; i++) {
        cin >> board[i];
    }

    for (int i = 0; i <= p1.first - 8; i++) {
        for (int j = 0; j <= p1.second - 8; j++) {
            cntW = WB_cnt(i, j);
            cntB = BW_cnt(i, j);
            if (cntW < cntB) {
                if (min > cntW)
                    min = cntW;
            }
            else {
                if (min > cntB)
                    min = cntB;
            }
        }
    }
    cout << min;
}
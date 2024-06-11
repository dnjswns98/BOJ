#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int sum = brown + yellow;
    int col = 3;
    while(1) {
        if (!(sum % col)) {
            int row = sum / col;
            if (((col - 2) * (row - 2)) == yellow) {
                answer.push_back(row);
                answer.push_back(col);
                break;
            }
        }
        col++;
    }
    return answer;
}
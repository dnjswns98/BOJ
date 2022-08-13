#include <iostream>
#define max 2187

using namespace std;

int arr[max][max];
int n;
int zero = 0, minusOne = 0, one = 0;

void test(int x, int y, int size) {
    int check = arr[x][y];
    bool different = false;
    for (int i = x; i < x + size; i++) {
        for (int j = y; j < y + size; j++) {
            if (check != arr[i][j]) {
                different = true;
                break;
            }
        }
    }
    if (different) {
        test(x, y, size / 3);
        test(x, y + size / 3, size / 3);
        test(x, y + 2 * (size / 3), size / 3);
        test(x + size / 3, y, size / 3);
        test(x + size / 3, y + size / 3, size / 3);
        test(x + size / 3, y + 2 * (size / 3), size / 3);
        test(x + 2 * (size / 3), y, size / 3);
        test(x + 2 * (size / 3), y + size / 3, size / 3);
        test(x + 2 * (size / 3), y + 2 * (size / 3), size / 3);
    }
    else {
        if (check == 0)
            zero++;
        else if (check == 1)
            one++;
        else
            minusOne++;
    }
}

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    
    test(0, 0, n);

    cout << minusOne << "\n" << zero << "\n" << one;
}
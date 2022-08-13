#include <iostream>
#define max 128

using namespace std;

int arr[max][max];
int n;
int white = 0, blue = 0;

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
        test(x, y, size / 2);
        test(x, y + size / 2, size / 2);
        test(x + size / 2, y, size / 2);
        test(x + size / 2, y + size / 2, size / 2);
    }
    else {
        if (check == 0)
            white++;
        else blue++;
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

    cout << white << "\n" << blue;
}
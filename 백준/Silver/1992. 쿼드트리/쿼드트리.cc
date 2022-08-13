#include <iostream>
#define max 64

using namespace std;

char arr[max][max];
int n;

void test(int x, int y, int size) {

    char check = arr[x][y];
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
        cout << "(";
        test(x, y, size / 2);
        test(x, y + size / 2, size / 2);
        test(x + size / 2, y, size / 2);
        test(x + size / 2, y + size / 2, size / 2);
        cout << ")";
    }
    else {
        if (check == '0')
            cout << "0";
        else
            cout << "1";
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
}
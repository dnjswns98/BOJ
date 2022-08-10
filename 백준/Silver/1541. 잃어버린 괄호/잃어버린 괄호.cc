#include <iostream>
#include <string>
using namespace std;

// '-'가 한번이라도 나오게되면 그 뒤의 값은 갈호를 쳐서 -로 처리한다.
//ex) 55-(50+40)-(30+10)
//참고 : https://scarlettb.tistory.com/64

int main() {
    ios_base::sync_with_stdio(false); cout.tie(NULL); cin.tie(NULL);

    string s;
    cin >> s;

    bool minus = false;
    string num;
    int sum = 0;
    for (int i = 0; i <= s.size(); i++) {
        if (s[i] == '+' || s[i] == '-' || i == s.size()) { //'+'와'-'와 제일 마지막 숫자
            if (minus == true) {
                sum -= stoi(num);
                num = "";
            }
            else {
                sum += stoi(num);
                num = "";
            }
        }
        else
            num += s[i];
        if (s[i] == '-')
            minus = true;
    }
    cout << sum;
}
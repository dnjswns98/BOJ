#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

int cnt = 0;

int recursion(const char* s, int l, int r) {
    cnt++;
    if (l >= r) return 1;
    else if (s[l] != s[r]) return 0;
    else return recursion(s, l + 1, r - 1);
}

int isPalindrome(const char* s) {
    return recursion(s, 0, strlen(s) - 1);
}

int main() {
    int t;
    scanf("%d", &t);
    char str[1000];
    char* ptr = str;
    for (int i = 0; i < t; i++) {
        scanf("%s", ptr);
        int istrue = isPalindrome(ptr);
        printf("%d %d\n", istrue, cnt);
        cnt = 0;
    }
}
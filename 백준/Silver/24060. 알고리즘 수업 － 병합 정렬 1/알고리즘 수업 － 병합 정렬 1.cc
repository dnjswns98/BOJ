#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int* temp;
int n, k;
int cnt = 0;
int sum_cnt = 0;

void merge(int* a, int l, int mid, int r) {
    int i, j, t;
    i = l;
    j = mid + 1;
    t = l;
    while (i <= mid && j <= r) {
        if (a[i] <= a[j]) {
            temp[t] = a[i];
            i++;
            t++;
        }
        else {
            temp[t] = a[j];
            t++;
            j++;
        }
    }
    while (i <= mid)
        temp[t++] = a[i++];
    while (j <= r)
        temp[t++] = a[j++];
    i = l;
    t = l;
    while (i <= r) {
        a[i++] = temp[t++];
        cnt++;
        sum_cnt++;
        if (cnt == k)
            printf("%d", a[i - 1]);
    }
}

void merge_sort(int* a, int l, int r) {
    if (l < r) {
        int mid = (l + r) / 2;
        merge_sort(a, l, mid);
        merge_sort(a, mid + 1, r);
        merge(a, l, mid, r);
    }
}

int main() {
    scanf("%d %d", &n, &k);
    int* arr = (int*)malloc(sizeof(int) * n);
    temp = (int*)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    merge_sort(arr, 0, n - 1);
    if (sum_cnt < k)
        printf("-1");
    free(arr);
}
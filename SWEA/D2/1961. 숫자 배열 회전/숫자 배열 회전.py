T = int(input())

def rotate(arr, n):
    result = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            result[i][j] = arr[n - 1 - j][i]
    return result

for test_case in range(1, 11):
    n = int(input())
    arr = list(input().split() for _ in range(n))
    arr_90 = rotate(arr,n)
    arr_180 = rotate(arr_90,n)
    arr_270 = rotate(arr_180,n)
    
    print("#{}" .format(test_case))
    for i in range(n):
        for j in range(n):
            print(arr_90[i][j], end="")
        print(end=" ")
        for j in range(n):
            print(arr_180[i][j], end="")
        print(end=" ")
        for j in range(n):
            print(arr_270[i][j], end="")
        print()
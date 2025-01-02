T = int(input())


for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    arr = [[0] * 3 * n for _ in range(3 * n)]
    for i in range(n, 2 * n):
        temp = list(map(int, input().split()))
        for j in range(n, 2 * n):
            arr[i][j] = temp[j - n]

    max = 0
    for i in range(n, 2 * n):
        for j in range(n, 2 * n):
            sum = 0
            for h in range(-m + 1, m):
                sum += arr[i][j + h]
                sum += arr[i + h][j]
            sum -= arr[i][j]
            if sum > max:
                max = sum

            sum = 0
            for h in range(-m + 1, m):
                sum += arr[i + h][j + h]
                sum += arr[i + h][j - h]
            sum -= arr[i][j]
            if sum > max:
                max = sum

    print("#{} {}" .format(test_case, max))
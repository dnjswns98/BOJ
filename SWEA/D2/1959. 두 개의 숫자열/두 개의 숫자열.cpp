T = int(input())

for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    
    if n > m:
        temp = b
        b = a
        a = temp
        temp = m
        m = n
        n = temp
        
    max = 0;
    for i in range(m - n + 1):
        sum = 0
        for j in range (n):
            sum += a[j] * b[j + i]
        if sum > max:
            max = sum
    
    print("#{} {}" .format(test_case, max))
    
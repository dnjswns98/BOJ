n = int(input())
num = list(map(int, input().split()))
num.sort()
print(num[n//2])
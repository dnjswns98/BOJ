a, b = map(int, input().split())
if a < b:
    if a == 1 and b == 3:
        print("A")
    else:
        print("B")
else:
    if b == 1 and a == 3:
        print("B")
    else:
        print("A")

import queue

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

T = int(input())


def checkBomb(n, arr):
    for i in range(n):
        for j in range(n):
            if arr[i][j] == ".":
                cnt = 0
                for h in range(8):
                    nx = i + dx[h]
                    ny = j + dy[h]
                    if nx >= 0 and ny >= 0 and nx < n and ny < n and arr[nx][ny] == "*":
                        cnt += 1
                arr[i][j] = cnt


def bfs(i, j, visited):
    q = queue.Queue()
    q.put([i, j])
    visited[i][j] = True

    while q.empty() == False:
        x, y = q.get()
        for h in range(8):
            nx = x + dx[h]
            ny = y + dy[h]
            if (
                nx >= 0
                and ny >= 0
                and nx < n
                and ny < n
                and arr[nx][ny] != "*"
                and visited[nx][ny] == False
            ):
                visited[nx][ny] = True
                if arr[nx][ny] == 0:
                    q.put([nx, ny])


for test_case in range(1, T + 1):
    n = int(input())
    arr = [list(input()) for _ in range(n)]
    visited = [[False] * n for _ in range(n)]
    result = 0

    checkBomb(n, arr)

    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0 and visited[i][j] == False:
                bfs(i, j, visited)
                result += 1

    for i in range(n):
        for j in range(n):
            if visited[i][j] == False and arr[i][j] != "*":
                result += 1

    print("#{} {}".format(test_case, result))

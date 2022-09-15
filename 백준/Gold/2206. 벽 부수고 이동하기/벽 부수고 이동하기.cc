#include <iostream>
#include <queue>
using namespace std;

typedef struct In {
    int x;
    int y;
    int count;
    bool destroy;
};

int n, m;
int arr[1000][1000];
bool visited[2][1000][1000] = { false };
int dx[] = { 1,0,-1,0 };
int dy[] = { 0,1,0,-1 };

void Input() {
    cin >> n >> m;
    string s;
    for (int i = 0; i < n; i++) {
        cin >> s;
        for (int j = 0; j < m; j++) {
            arr[i][j] = s[j] - '0';
        }
    }
}

void bfs(int a, int b, int count, bool des) {
    queue<In> q;
    q.push({ a,b,count,des });
    visited[0][a][b] = true;
    while (!q.empty()) {
        int cx = q.front().x;
        int cy = q.front().y;
        int cnt = q.front().count;
        bool crash = q.front().destroy;
        q.pop();
        if (cx == n - 1 && cy == m - 1) {
            cout << cnt;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!crash) {
                    if (!visited[0][nx][ny]) {
                        if (arr[nx][ny] == 0) {
                            q.push({ nx,ny,cnt + 1,crash });
                            visited[0][nx][ny] = true;
                        }
                        else {
                            q.push({ nx,ny,cnt + 1,!crash });
                            visited[0][nx][ny] = true;
                        }
                    }
                }
                else {
                    if (!visited[1][nx][ny] && arr[nx][ny] == 0) {
                        visited[1][nx][ny] = true;
                        q.push({ nx,ny,cnt + 1,crash });
                    }
                }
            }
        }
    }
    cout << "-1";
}

int main() {
    Input();
    bfs(0, 0, 1, false);
}
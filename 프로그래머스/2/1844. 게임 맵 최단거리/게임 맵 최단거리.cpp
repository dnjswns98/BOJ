#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int dx[4] = {1,0,-1,0};
int dy[4] = {0,-1,0,1};
int dist[100][100];
int visited[100][100] = {0};

void init(){
    for(int i = 0; i<100; i++){
        for(int j = 0; j<100; j++){
            dist[i][j] = -1;
            //visited[i][j] = -1;
        }
    }
}

int solution(vector<vector<int>> maps)
{
    int answer = -1;
    init();
    int ns = maps.size();
    int ms = maps[0].size();
    
    queue<pair<int,int>> q;
    
    q.push({0,0});
    visited[0][0] = 1;
    dist[0][0] = 1;
    
    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        if(cx == ns - 1 && cy == ms - 1){
            return dist[cx][cy];
        }
        for(int i = 0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            if(nx < 0 || ny < 0 || nx >= ns || ny >= ms || visited[nx][ny] || !maps[nx][ny]) continue;
            q.push({nx,ny});
            visited[nx][ny] = 1;
            dist[nx][ny] = dist[cx][cy] + 1;
        }
    }
    
    return answer;
}
#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    map<int,int> m;
    for(int i = 0; i<tangerine.size(); i++){
        m[tangerine[i]]++;
    }
    
    vector<int> v;
    for(auto iter = m.begin(); iter!=m.end(); iter++){
        v.push_back(iter->second);
    }
    sort(v.begin(),v.end(),greater<int>());
    
    int cnt = 0;
    for(int i = 0; i<v.size(); i++){
        cnt += v[i];
        if(cnt >= k){
            answer = i + 1;
            break;
        }
    }
    
    return answer;
}
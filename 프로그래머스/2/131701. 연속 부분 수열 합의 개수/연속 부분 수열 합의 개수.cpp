#include <string>
#include <vector>
#include <set>

using namespace std;

set<int> s;

void Sum(int len, vector<int> v){
    for(int i = 0; i<v.size(); i++){
        int sum = 0;
        for(int j = i; j<i+len; j++){
            if(j >= v.size())
                sum += v[j - v.size()];
            else
                sum += v[j];
        }
        s.insert(sum);
    }
}

int solution(vector<int> elements) {
    
    int len = 1;
    while(len <= elements.size()){
        Sum(len, elements);
        len++;
    }
    
    return s.size();
}
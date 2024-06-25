#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(int n, vector<string> words) {

    for(int i = 0; i<words.size(); i++){
        if(i>0){
            if(words[i].front() != words[i-1].back()){
                return{i%n + 1, i/n+1};
            }
        }
        for(int j = 0; j<i; j++){
            if(words[j] == words[i]){
                return{i%n + 1, i/n+1};
            }
        }

    }
    return {0,0};
}
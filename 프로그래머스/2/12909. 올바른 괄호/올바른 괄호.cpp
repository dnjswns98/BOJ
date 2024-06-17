#include <string>
#include <iostream>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    string tmp = "";
    for(int i = 0; i<s.size(); i++){
        if(s[i] == '('){
            tmp += s[i];
        }
        else{
            if(tmp.empty()){
                answer = false;
                return answer;
            }
            else{
                tmp.pop_back();
            }
        }
    }
    if(tmp.size()){
        answer = false;
    }
    else answer = true;
    
    return answer;
}
#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    bool check = false;
    for(int i = 0; i<s.size(); i++){
        if(s[i] == ' '){
            answer += ' ';
            check = false;
        }
        else if(!check){
            if(s[i] >= 97 && s[i] <= 122){
                answer += (s[i] - 32);
            }
            else answer += s[i];
            check = true;
        }
        else {
            if(s[i] >= 65 && s[i] <= 90)
                answer += (s[i] + 32);
            else answer += s[i];
        }
    }
    
    return answer;
}
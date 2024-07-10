#include <string>
#include <vector>
#include <stack>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    for(int i = 0; i<s.length(); i++){
        stack<char> st;
        bool check = true;
        for(int j = 0; j<s.length(); j++){
            if(s[j] == '(' || s[j] == '{' || s[j] == '['){
                st.push(s[j]);
            }
            else if(st.empty()){
                if(s[j] == ')' || s[j] == '}' || s[j] == ']')
                    check = false;
            }
            else{
                if(!st.empty()){
                    if(s[j] == ')' && st.top() == '('){
                        st.pop();
                    }
                    else if(s[j] == '}' && st.top() == '{'){
                        st.pop();
                    }
                    else if(s[j] == ']' && st.top() == '['){
                        st.pop();
                    }
                }
            }
            
        }
        
        if(st.empty() && check) answer++;
        
        char c = s.front();
        s.erase(0,1);
        s.push_back(c);
    }
    
    return answer;
}
#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    int answer = 0;

    if(s.size() % 2 == 1) return answer;
    
    stack<char> st;
    for(int i = 0; i<s.size(); i++){
        if(st.empty() || st.top() != s[i]){
            st.push(s[i]);
        }
        else{
            st.pop();
        }
    }

    if(st.empty()) answer = 1;
    return answer;
}
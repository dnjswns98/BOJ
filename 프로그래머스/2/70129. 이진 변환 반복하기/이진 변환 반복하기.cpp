#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    
    int zero = 0;
    int cnt = 0;
    
    while(s != "1"){
        string tmp = "";
        cnt++;
        
        for(int i = 0; i<s.size(); i++){
            if(s[i] == '0'){
                zero++;
            }
            else{
                tmp += '1';
            }
        }
        
        s = "";
        for(int i = tmp.size(); i>0; i/=2){
            s+=to_string(i%2);
        }
    }
    answer.push_back(cnt);
    answer.push_back(zero);
    return answer;
}
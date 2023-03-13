#include <iostream>
#include<stack>
using namespace std;

int main(){
  ios_base::sync_with_stdio(0);
  int num;
  cin>>num;

  stack<pair<int,int>> st;
  int now,same_height=0;
  long long cnt_pair=0;
  
  for(int i=0; i<num ; ++i){
    cin>>now;

    same_height=1;
    while(!st.empty() && st.top().first < now){
      cnt_pair += st.top().second;
      st.pop();
    }

    if(!st.empty() ){
      if(st.top().first== now){
        cnt_pair += st.top().second;
        same_height = (st.top().second +1 );
        if(st.size() >1)
          ++cnt_pair;

        st.pop();
      }else{
        ++cnt_pair;
      }
    }
    
    st.push(make_pair(now, same_height));
  }

  cout<<cnt_pair<<'\n';
  return 0;
}
#include <iostream>
#include <cmath>
using namespace std;
 
int main() {
  while(1){
  int a, cnt=0;
  cin >> a;
  
  int* num = new int[2*a+1];
  fill_n(num, 2*a+1, 0);
  for(int i=2; i<=2*a+1; i++){
    num[i] = i;
  }

  for(int i=2; i<=sqrt(2*a); i++)
  {
    if(num[i]==0)
      continue;
    for(int j=i*i; j<=2*a; j+=i){
      num[j] = 0;
    }
  }

  for(int i=a+1; i<=2*a; i++){
    if(num[i]!=0)
      cnt++;
  }

  if(a == 0){
    delete[] num;
    return 0;
    }
    else cout << cnt << "\n";
  }
}
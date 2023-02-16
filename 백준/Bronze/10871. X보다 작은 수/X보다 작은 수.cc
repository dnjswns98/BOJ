#include <iostream>
using namespace std;

int main() {
  cin.tie(NULL);
  cout.tie(NULL);
  ios::sync_with_stdio(false);
    
  int a, b;
  cin >> a >> b;\
  int n[a];
  for(int i=0; i<a; i++){
    cin >> n[i];
  }
  for(int i=0; i<a; i++){
    if(b > n[i]) cout << n[i] << " ";
  }
}
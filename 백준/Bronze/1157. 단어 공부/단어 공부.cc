#include <iostream>
#include <string>
using namespace std;

int main() {
  string s;
  cin >> s;
  int num[26] = {0};
  int max = 0, n;
  string alphabet = "abcdefghijklmnopqrstuvwxyz";
  string ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  for(int i=0; i<s.length(); i++){
    for(int j=0; j<26; j++){
      if(s[i]==alphabet[j] || s[i]==ALPHABET[j])
        num[j]++;
      if(max < num[j]) {
        max = num[j];
        n=j;
        }
    }
  }
  for(int i=0; i<26; i++){
    for(int j=i+1; j<26; j++){
      if(num[i]!=0 && num[j]!=0){
        if(num[i]==num[j] && num[i]==max && num[j]==max){
          cout <<"?";
          return 0;
          }
        }
      }
  }
  cout << ALPHABET[n];
}
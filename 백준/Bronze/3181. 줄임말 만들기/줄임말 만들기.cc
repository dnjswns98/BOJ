#include<iostream>
#include<vector>
#include<string>
using namespace std;
int main()
{
	string word;
	getline(cin, word);
	string temp;
	vector<string>v;
	for (int i = 0; i < word.size(); i++)
	{
		if (word[i] == ' ')
		{
			v.push_back(temp);
			temp = "";
		}
		else
			temp += word[i];
	}
	//마지막 null전까지의 단어까지넣고,
	v.push_back(temp);
	//최소하나의단어를포함하므로 첫글자출력
	cout << char(v[0][0]-'a'+'A');
	for (int i = 1; i < v.size(); i++)
	{
		if (v[i] != "i" && v[i] != "pa" && v[i] != "te" && v[i] != "ni" && v[i] != "niti" && v[i] != "a" && v[i] != "ali" && v[i] != "nego" && v[i] != "no" && v[i] != "ili")
			cout << char(v[i][0] - 'a' + 'A');
	}
	cout << endl;
	
}
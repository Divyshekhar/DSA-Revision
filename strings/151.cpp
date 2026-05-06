/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
*/
#include <bits/stdc++.h>
using namespace std;

string reverseWords(string s)
{
   string ans = "";
   reverse(s.begin(), s.end());
   int n = s.size();
   for (int i = 0; i < n; i++)
   {
      string word = "";
      while (i < n && s[i] != ' ')
      {
         word += s[i];
         i++;
      }
      reverse(word.begin(), word.end());
      if (word.size() > 0)
      {
         ans += " " + word;
      }
   }
   return ans;
}

int main()
{
   ios_base::sync_with_stdio(false);
   cin.tie(nullptr);
}
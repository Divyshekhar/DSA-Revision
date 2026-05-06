
import java.util.*;

/* 

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

 */
class strings {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!mpp.containsKey(t.charAt(i)) || mpp.get(t.charAt(i)) == 0) {
                return false;
            }
            mpp.put(t.charAt(i), mpp.get(s.charAt(i)) - 1);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

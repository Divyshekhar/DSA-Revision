
class strings {

    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            // for odd length of string
            int l = i;
            int r = i;
            while ((l >= 0 && r < n) && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (ans.length() < r - l - 1) {
                ans = s.substring(l + 1, r);
            }
            // for even length of string
            l = i;
            r = i + 1;
            while ((l >= 0 && r < n) && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (ans.length() < r - l - 1) {
                ans = s.substring(l + 1, r);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

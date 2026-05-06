
import java.util.*;


class strings {

    public String longestCommonPrefix(String[] s) {
        int n = s.length;
        Arrays.sort(s);
        String first = s[0];
        String last = s[n-1];
        String ans = "";
        for(int i = 0; i<Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                break;
            }
            ans += first.charAt(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

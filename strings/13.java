
import java.util.*;

class strings{
    public int romanToInteger(String s){
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int n = s.length();
        int result = 0;
        for(int i = 0; i<n; i++){
            if((i < n-1) && (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1)))){
                // IV -> chatAt < chatAt+1
                // so 5-1
                result -= romanMap.get(s.charAt(i));
            }else{
                result += romanMap.get(s.charAt(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        
    }
}
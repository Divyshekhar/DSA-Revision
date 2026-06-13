import java.util.*;

class arrays{

    public char findFirst(String input){

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char c : input.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return (0);
    }

    public static void main(String[] args) {
        
    }
}
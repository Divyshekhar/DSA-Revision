import java.util.*;
class arrays{
    public boolean checkSubarraySum(int[] nums, int k){
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        for(int i = 0; i<n; i++){
            prefixSum = (nums[i] + prefixSum) % k;
            if(map.containsKey(prefixSum)){
                if(i - map.get(prefixSum) > 1){
                    return true;
                }
            }else{
                map.put(prefixSum, i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
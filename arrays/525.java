
import java.util.*;

class arrays {
    // treating 0 as -1 and 1 as +1 making the question boil down to
    // finding the length of longest subarray whose sum is equal to 0

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int count = 0;
        int maxi = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                maxi = Math.max(maxi, i - map.get(count));
            }
            map.put(count, i);
        }
        return maxi;
    }

    public static void main(String[] args) {

    }
}

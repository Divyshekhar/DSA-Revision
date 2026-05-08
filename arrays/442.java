
import java.util.*;

class arrays {

    public List<Integer> findDuplicates(int[] nums) {
        // flip whatever nums[nums[i]]
        // if checking that nums[nums[i]] < 0 that means already seen before at nums[i] hence add to the answer
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                ans.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        return ans;
    } // time complexity = O(n)
    // space complexity = O(1) {answer array took space}

    public List<Integer> findDuplicatesSecond(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                ans.add(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        return ans;
    }
    // time complexity = O(n)
    // space complexity = O(n) {hashmap took}

    public static void main(String[] args) {

    }
}


import java.util.*;

/*
    The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

    You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

    Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.


 */
class stack_queues {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];
        for (int it : nums2) {
            while (!st.isEmpty() && it > st.peek()) {
                map.put(st.peek(), it);
                st.pop();
            }
            st.push(it);
        }
        while (!st.isEmpty()) {
            map.put(st.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

// normal Next Greater Element (NGE)
    public int[] nge(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(nums[i]);

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

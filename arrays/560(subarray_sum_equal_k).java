
import java.util.*;

class arrays {

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int sum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mpp.containsKey(sum - k)) {
                cnt++;
            }
            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    public  void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        int ans = subarraySum(arr, k);
        System.out.println(ans);
    }
}

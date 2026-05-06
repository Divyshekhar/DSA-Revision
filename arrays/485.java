
class arrays {

    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
                maxCount = Math.max(cnt, maxCount);
            } else {
                cnt = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {

    }
}

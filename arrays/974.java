/*
    prefix sum ka intuition aaya because subarray sub ki baat ho rahi hai , continuous sum means yaa to sliding window ya prefix sum... prefix sum ka ek pattern hota hai jiss mai har value pa aake kuch operation perform krte hai and then use store krte hai map mai aur agar map mai phle se hi ho vo value to uss value ko + krne ke baad map mai increment krte hai prefix sum mai majorly do hi pattern dikhte hai 1. jiss mai aage piche dono ka sum kro yaa dusra jo maine upar btaya vo....


 */

class arrays {

    public static int subarrayDivByK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // subarray sum from idx start to idx end is prefix[end] - pre[start - 1];
            prefix[i] = nums[i] + prefix[i - 1];
        }
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int cur;
                if (start == 0) {
                    cur = prefix[end];
                } else {
                    cur = prefix[end] - prefix[start - 1];
                }
                int rem = cur % k;
                if (rem < 0) {
                    rem += k;
                }
                if (rem == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int subarrayDivByKOptimal(int[] nums, int k) {
        int ans = 0;
        int[] remainders = new int[k];
        remainders[0] = 1; // this is made so that [0] can be added
        // nums[5, 2] and k = 5
        /*
            when no remainder[0] = 1;
            curSum = 5;
            then rem = 5 % 5 == 0
            ans += remainder[rem]
            so here the remainder[0] = 0
            then that would be false
            hence put remainder[0] = 1;
        */
        int curSum = 0;

        for (int it : nums) {
            curSum += it;
            int rem = curSum % k;
            if (rem < 0) {
                rem += k;
            }
            ans += remainders[rem];
            remainders[rem]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int ans = subarrayDivByKOptimal(nums, k);
        System.out.println("answer " + ans);
    }
}

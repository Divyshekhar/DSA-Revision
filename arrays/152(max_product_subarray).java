/*
    Given an integer array nums, find a subarray that has the largest product, and return the product.

    The test cases are generated so that the answer will fit in a 32-bit integer.   

    Note that the product of an array with a single element is the value of that element.

*/

class arrays{
    public int maxProduct(int[] nums){
        int n = nums.length;
        int suf = 1;
        int pre = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(pre == 0){
                pre = 1;
            }
            if(suf == 0){
                suf = 1;
            }
            pre = nums[i] * pre;
            suf = suf * nums[n-i-1];
            ans = Math.max(ans, Math.max(pre, suf));
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
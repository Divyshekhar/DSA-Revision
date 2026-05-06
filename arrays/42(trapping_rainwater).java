
class arrays {

    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int l = 0, r = n - 1, lmax = 0, rmax = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > lmax) {
                    lmax = Math.max(height[l], lmax);
                }
                total += lmax - height[l];
                l++;
            } else {
                if (height[r] > rmax) {
                    rmax = Math.max(height[r], rmax);
                }
                total += rmax - height[r];
                r--;
            }
        }
        return total;
    }

    public static void main(String[] args) {

    }
}

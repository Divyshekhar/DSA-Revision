
class arrays {

    public int trap(int[] height) {
        int n = height.length;
        int total = 0;
        int l = 0, r = n - 1, lmax = 0, rmax = 0;
        while (l < r) {
            if (height[l] < height[r]) { // when left side is low then it will be dependent on the left side only
                if (height[l] > lmax) {
                    lmax = Math.max(height[l], lmax);
                }
                total += lmax - height[l];
                l++;
            } else { // when right side is low then it will be dependent on the right side only
                if (height[r] > rmax) {
                    rmax = Math.max(height[r], rmax);
                }
                total += rmax - height[r];
                r--;
            }
        }
        return total;
    }
    // asked in goldman sachs interview (trapping most snow in between buildings)
    public int trapThing(int[] height){
        int n = height.length;
        int lmax = 0;
        int rmax = 0;
        int l = 0;
        int r = n-1;
        int total = 0;
        while(l <= r){
            if(height[l] < height[r]){
                if(lmax < height[l]){
                    lmax = Math.max(lmax, height[l]);
                }
                total += lmax - height[l];
                l++;
            }else{
                if(rmax < height[r]){
                    rmax = Math.max(rmax, height[r]);
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

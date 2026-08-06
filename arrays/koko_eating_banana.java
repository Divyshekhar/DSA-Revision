
class KokoBanana {

    private int maxValue(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public long calculateHours(int[] piles, int hourly) {
        if (hourly == 0) {
            return Integer.MAX_VALUE;
        }
        long totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += (long) Math.ceil((double) piles[i] / hourly);
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int hours){
        int high = maxValue(piles);
        int low = 0;
        while(low <= high){
            int mid = low + high / 2;
            long totalHours = calculateHours(piles, mid);
            if(totalHours <= hours){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {

    }
}

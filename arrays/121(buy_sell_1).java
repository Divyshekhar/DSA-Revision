class arrays{

    public int maxProfit(int[] prices){
        int n = prices.length;
        int minCost = prices[0];
        int maxi = 0;
        for(int i = 1; i<n; i++){
            int profit = prices[i] - minCost;
            maxi = Math.max(profit, maxi);
            minCost = Math.min(prices[i], minCost);
        }
        return maxi;
    }

    public static void main(String[] args) {
        
    }
}
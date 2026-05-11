
class arrays {

    public int f(int ind, int buy, int cap, int[] prices) {
        int n = prices.length;
        if (ind == n || cap == 0) {
            return 0;
        }
        int profit;
        if (buy == 1) {
            profit = Math.max((-prices[ind] + f(ind + 1, 0, cap, prices)), (0 + f(ind + 1, 1, cap, prices)));
        } else {
            profit = Math.max((prices[ind] + f(ind + 1, 1, cap - 1, prices)), (0 + f(ind + 1, 0, cap, prices)));
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        return f(0, 1, 2, prices);
    }

    public static void main(String[] args) {

    }
}

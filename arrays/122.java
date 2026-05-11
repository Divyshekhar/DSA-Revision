
class arrays {

    // when buy == 1 then allowed to buy that means need to -prices[ind]
    // when buy == 0 then not allowed to buy only sell
    public int f(int ind, int buy, int[] prices, int[][] dp) {
        int n = prices.length;
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }
        if (ind == n) {
            return 0;
        }
        int profit;
        if (buy == 1) {
            profit = Math.max((-prices[ind] + f(ind + 1, 0, prices, dp)), (0 + f(ind + 1, 1, prices, dp)));
        } else {
            profit = Math.max((prices[ind] + f(ind + 1, 1, prices, dp)), (0 + f(ind + 1, 0, prices, dp)));
        }
        return dp[ind][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        return f(0, 1, prices, dp);
    }

    public int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                int profit;
                if (buy == 1) {
                    profit = Math.max((-prices[i] + dp[i + 1][0]), (0 + dp[i + 1][1]));
                } else {
                    profit = Math.max((prices[i] + dp[i + 1][1]), (0 + dp[i + 1][0]));
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {

    }
}

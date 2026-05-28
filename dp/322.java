
import java.util.Arrays;

class das {

    public int f(int ind, int amount, int[] coins, int[][] dp) {
        if (ind == 0) {
            if (amount % coins[ind] == 0) {
                return amount / coins[ind];
            }
            return (int) 1e9;
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        if (amount == 0) {
            return (int) 1e9;
        }
        int notTake = 0 + f(ind - 1, amount, coins, dp);
        int take = Integer.MAX_VALUE;
        if (amount >= coins[ind]) {
            int res = 1 + f(ind, amount - coins[ind], coins, dp);
            if (res != (int) 1e9) {
                take = 1 + res;
            }
        }
        return dp[ind][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(n - 1, amount, coins, dp);
        return (ans == (int) 1e9) ? -1 : ans;
    }

    public int coinChangeTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                dp[0][target] = target / coins[0];
            } else {
                dp[0][target] = (int) 1e9;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + dp[i - 1][target];
                int take = (int) 1e9;
                if (target >= coins[i]) {
                    take = 1 + dp[i][target - coins[i]];
                }
                dp[i][target] = Math.min(take, notTake);
            }
        }
        int ans = dp[n - 1][amount];
        return (ans == (int) 1e9) ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}

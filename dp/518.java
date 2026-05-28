
import java.util.Arrays;

class dp {

    public int f(int ind, int amount, int[] coins, int[][] dp) {
        if (ind == 0) {
            return (amount % coins[ind] == 0) ? 1 : 0;
        }
        if (dp[ind][amount] != -1) {
            return dp[ind][amount];
        }
        int notTake = f(ind - 1, amount, coins, dp);
        int take = 0;
        if (amount >= coins[ind]) {
            take = f(ind, amount - coins[ind], coins, dp);
        }
        return take + notTake;
    }

    public int change(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = f(n - 1, amount, coins, dp);
        return ans;
    }

    public int changeTabulation(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                dp[0][target] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (target >= coins[i]) {
                    take = dp[i][target - coins[i]];
                }
                dp[i][target] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }

    public static void main(String[] args) {

    }
}

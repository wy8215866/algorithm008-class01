class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        if (n == 0) return 0;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][0][0] = dp[0][1][0] = dp[0][2][0] = 0;
        dp[0][0][1] = dp[0][1][1] = dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }

        }
        return dp[n - 1][k][0];
    }
}


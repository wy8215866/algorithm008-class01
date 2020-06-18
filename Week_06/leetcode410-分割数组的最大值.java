class Solution {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = dp[0][i - 1] + nums[i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = i; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < j; k++) {
                    min = Math.min(min, Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
                }
                dp[i][j] = min;
            }
        }
        return dp[m - 1][n - 1];

    }
}



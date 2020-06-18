import java.util.Arrays;

//https://www.youtube.com/watch?v=HzlEkUt2TYs&t=21s
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;
        for (int t = 3; t <= target; t++) {
            int n = 32 - Integer.numberOfLeadingZeros(t);
            //AA...A(nA) bast case
            if (1 << n == t + 1) {
                dp[t] = n;
                continue;
            }
            //AA...AR(nA+1R) + DP(left)
            if ((1 << n) - 1 - t < t) {
                dp[t] = Math.min(dp[t], n + 1 + dp[(1 << n) - 1 - t]);
            }
            for (int j = 0; j < n - 1; j++) {
                //AA...ARA...AR(n-1A+1R+mA+1R) + DP(left)
                dp[t] = Math.min(dp[t], n + 1 + j + dp[t - (1 << (n - 1)) + (1 << j)]);
            }
        }
        return dp[target];
    }
}



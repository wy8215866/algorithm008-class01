class Solution {
    //https://www.youtube.com/watch?v=06YtJdBG0rk
    public int checkRecord(int n) {
        long M = 1000000007;
        //dp[i] = total number of rewardable student records with i len
        long[] dp = new long[n <= 3 ? 4 : n + 1];
        //不包含A的数量
        dp[0] = 1;
        dp[1] = 2; //P or L
        dp[2] = 4; //PP PL LL LP 2*2
        dp[3] = 7; //without LLL 2*2*2-1

        //1.without A end with P dp[i] = dp [i - 1]
        //2.without A end with L ...PLLL dp[i] = dp [i-1] - dp[i-4]
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % M) + (M - dp[i - 4]) % M;
        }
        long sum = dp[n];
        //with A .assume A is in index i
        //[... i-1]A[i+1,...n]
        //dp[i-1]*dp[n-i]
        for (int i = 1; i <= n; i++) {
            sum = sum + dp[i - 1] * dp[n - i] % M;
        }
        return (int) (sum%M);

    }
}



public class Solution {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=1;i<prices.length;i++) {
            int profile =prices[i]-prices[i-1];
            if(profile>0){
                sum = sum + profile;
            }
        }
        return sum;
    }
}


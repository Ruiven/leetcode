package main;

public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int dp[] = new int[prices.length];
		int min = prices[0];
		dp[0] = 0;
		for(int i = 1; i < prices.length; i++) {
			dp[i] = (dp[i-1] > prices[i]-min) ? dp[i-1] : (prices[i] - min);
			if(prices[i] < min)
				min = prices[i];
		}
		return dp[dp.length-1];
    }
}

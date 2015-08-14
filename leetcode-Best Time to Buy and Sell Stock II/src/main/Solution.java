package main;

public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int profit = 0;
		int min = prices[0];
		for(int i = 1 ; i < prices.length-1; i++) {
			if(prices[i] <= min)
				min = prices[i];
			else {
				if(prices[i+1] < prices[i]) {
					profit += prices[i]-min;
					min = prices[i+1];
				}
				
			}
		}
		
		profit += prices[prices.length-1] - min;
		return profit;
    }
}

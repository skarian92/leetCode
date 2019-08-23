package com.arise.easy.buySellStock;

public class Solution {
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length == 0)
			return 0;
		int[] low = new int[length];

		low[0] = prices[0];
		int maxdif = 0, num;
		for (int i = 1; i < length; i++) {
			low[i] = min(low[i - 1], prices[i]);
		}

		num = prices[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			num = max(num, prices[i]);
			int dif = num - low[i];
			if (dif > maxdif) {
				maxdif = dif;
			}
		}
		return maxdif;
	}

	int min(int a, int b) {
		return a < b ? a : b;
	}

	int max(int a, int b) {
		return a > b ? a : b;
	}
}

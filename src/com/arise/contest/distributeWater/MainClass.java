package com.arise.contest.distributeWater;

public class MainClass {

	public static void main(String[] args) {
		// int n = 7;
		// int[] wells = { 14545, 18504, 48032, 46725, 76232, 50574, 12109 };
		// int[][] pipes = { { 3, 1, 83424 }, { 4, 3, 12977 }, { 5, 1, 48398 },
		// { 6, 3, 9918 }, { 7, 4, 9954 } };

		int n = 5;
		int[] wells = { 46012, 72474, 64965, 751, 33304 };
		int[][] pipes = { { 2, 1, 6719 }, { 3, 2, 75312 }, { 5, 3, 44918 } };
		int cost = new Solution().minCostToSupplyWater(n, wells, pipes);
		System.out.println(cost);

	}

}

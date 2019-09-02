package com.arise.contest.minCostStick;

public class MainClass {

	public static void main(String[] args) {
		int[] sticks = { 1, 8, 3, 5 };
		int connectSticks = new Solution().connectSticks(sticks);
		System.out.println(connectSticks);

	}

}

package com.arise.contest.minCostStick;

import java.util.PriorityQueue;

public class Solution {

	public int connectSticks(int[] sticks) {
		if (sticks.length == 0)
			return 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int a : sticks) {
			q.add(a);
		}

		int cost = 0;

		while (q.size() > 1) {
			int f = q.poll();
			int s = q.poll();
			cost += f + s;
			q.add(f + s);
		}

		return cost;
	}

}

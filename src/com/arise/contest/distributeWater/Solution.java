package com.arise.contest.distributeWater;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		if (n == 0)
			return 0;
		int cost = 0;
		// int[] visited = new int[wells.length];
		int minInd = getMin(wells);
		cost = wells[minInd];

		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < pipes.length; i++) {
			Map<Integer, Integer> im = new HashMap<>();
			if (map.get(pipes[i][0]) == null) {
				map.put(pipes[i][0], new HashMap<>());
			}
			im.put(pipes[i][1], pipes[i][2]);
			map.get(pipes[i][0]).putAll(im);

			Map<Integer, Integer> sm = new HashMap<>();
			sm.put(pipes[i][0], pipes[i][2]);

			if (map.get(pipes[i][1]) == null) {
				map.put(pipes[i][1], new HashMap<>());
			}
			map.get(pipes[i][1]).putAll(sm);

		}
		/*
		 * cost = wells[minInd]; for (int i = minInd; i < pipes.length; i++) {
		 * int pcost = pipes[i][2]; int wcost = wells[i + 1];
		 * 
		 * cost += pcost < wcost ? pcost : wcost; }
		 * 
		 * for (int i = minInd - 1; i >= 0; i--) {
		 * 
		 * int pcost = pipes[i][2]; int wcost = wells[i];
		 * 
		 * cost += pcost < wcost ? pcost : wcost; }
		 */

		for (int i = 1; i <= n; i++) {
			if (i - 1 == minInd)
				continue;
			int wcost = wells[i - 1];
			int pcost = getMin(map.get(i));

			cost += pcost < wcost ? pcost : wcost;
		}

		return cost;
	}

	private int getMin(Map<Integer, Integer> pipes) {
		if (pipes == null)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (Entry<Integer, Integer> entry : pipes.entrySet()) {
			if (entry.getValue() < min) {
				min = entry.getValue();
			}
		}
		return min;
	}

	private int getMin(int[] wells) {
		int min = Integer.MAX_VALUE;
		int minInd = 0;
		for (int i = 0; i < wells.length; i++) {
			if (wells[i] < min) {
				min = wells[i];
				minInd = i;
			}
		}
		return minInd;
	}
}

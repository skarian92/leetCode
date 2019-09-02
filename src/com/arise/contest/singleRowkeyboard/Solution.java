package com.arise.contest.singleRowkeyboard;

public class Solution {
	public int calculateTime(String keyboard, String word) {
		if (word == null || word.equals(""))
			return 0;
		int i = 0;
		int count = 0;
		for (char c : word.toCharArray()) {
			int j = keyboard.indexOf(c);
			count += Math.abs(i - j);
			i = j;
		}
		return count;
	}
}

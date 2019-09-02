package com.arise.contest.singleRowkeyboard;

public class MainClass {

	public static void main(String[] args) {
		String key = "pqrstuvwxyzabcdefghijklmno";
		String word = "leetcode";
		int calculateTime = new Solution().calculateTime(key, word);
		System.out.println(calculateTime);

	}

}

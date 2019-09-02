package com.arise.med.wordBreak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		// while ((line = in.readLine()) != null) {
		String s = "leetleetcode";
		// line = in.readLine();
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("san");
		wordDict.add("code");

		boolean ret = new Solution().wordBreak(s, wordDict);

		String out = booleanToString(ret);

		System.out.print(out);
	}
	// }

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

}

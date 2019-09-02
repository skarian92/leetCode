package com.arise.wordLadder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new
		// InputStreamReader(System.in));
		// String line;
		// while ((line = in.readLine()) != null) {
		String beginWord = "hit";
		// line = in.readLine();
		String endWord = "cog";
		// line = in.readLine();
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		int ret = new BetterSolution().ladderLength(beginWord, endWord, wordList);

		String out = String.valueOf(ret);

		System.out.print(out);
	}
}

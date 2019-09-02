package com.arise.wordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;

		Queue<String> q = new LinkedList<>();
		q.add(endWord);
		q.add(null);
		wordList.remove(endWord);
		int count = 1;

		Set<String> set = new HashSet<>(wordList);

		while (!q.isEmpty() && !set.isEmpty()) {
			String w = q.poll();

			if (w != null) {
				Set<String> words = getWords(w, set);
				if (words.contains(beginWord))
					return count + 1;
				for (String word : words) {
					if (getDiff(word, beginWord) == 1) {
						return count + 2;
					} else {
						q.add(word);
					}
				}
			} else {
				if (!q.isEmpty()) {
					q.add(null);
					count++;
				}
			}
		}

		if (!q.isEmpty()) {
			String word = q.poll();
			if (word.equals(endWord) && getDiff(word, beginWord) == 1) {
				return count + 1;
			}
		}
		return 0;
	}

	private Set<String> getWords(String ew, Set<String> wl) {
		Set<String> words = new HashSet<String>();
		for (String w : wl) {
			int diff = getDiff(ew, w);
			if (diff == 1) {
				words.add(w);
			}
		}
		wl.removeAll(words);
		return words;
	}

	private int getDiff(String a, String b) {
		if (a.length() != b.length()) {
			return 2;
		}
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
				if (count == 2)
					return 2;
			}

		}

		return count;
	}
}

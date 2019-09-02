package com.arise.hard.lexographic.newLan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {

	private static final int NOT_VISITED = 0;
	private static final int VISITING = 1;
	private static final int VISITED = 2;

	// 85% faster
	public String alienOrder(String[] words) {
		if (words == null || words.length == 0)
			return "";
		// 1. Initialize empty dict with all characters
		Map<Character, List<Character>> dict = getDictionary(words);
		int[] visited = new int[26]; // problem set states that we are dealing
										// with only lower case letters, if
										// unicode, we can change to map
		Deque<Character> stack = new ArrayDeque<>();

		// 2. Build association
		for (int i = 1; i < words.length; i++) {
			String word1 = words[i - 1], word2 = words[i];
			int diff = getDifferenceIndex(word1, word2);
			// if word1 == aa and word2 == abc, diff will equal -1
			// in this case, we do not know anything about c so we cannot
			// associate
			// anything here
			if (diff == -1)
				continue;

			// if word1 == ab and word2 == ac, we can conclude b comes before c
			// so we will add c to b as a connection
			char w1 = word1.charAt(diff), w2 = word2.charAt(diff);
			dict.get(w1).add(w2);
		}

		// 3. top sort
		for (char a = 'a'; a <= 'z'; a++) {
			if (dict.containsKey(a) // if it does not contain its a letter we do
									// not have
					&& visited[a - 'a'] == NOT_VISITED // only if never
														// processed
					&& !topologicalSort(dict, stack, a, visited)) { // if top
																	// sort
																	// returns
																	// false,
																	// top sort
																	// failed
																	// which
																	// implies
																	// its not
																	// solvable
				return "";
			}
		}

		// 4. pop stack and construct our results
		return getOrder(stack);
	}

	private String getOrder(Deque<Character> stack) {
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(stack.pop());
		return sb.toString();
	}

	private boolean topologicalSort(Map<Character, List<Character>> dict, Deque<Character> stack, char u,
			int[] visited) {
		// classic top sort algorithm
		// aggressively push to stack if we are allowed to
		// if we detect a cycle, it implies it is not top sortable to return
		// false
		if (visited[u - 'a'] == VISITING)
			return false;
		if (visited[u - 'a'] == VISITED)
			return true;
		visited[u - 'a'] = VISITING;
		for (char v : dict.get(u)) {
			// if recursive call out returns false, it implies topological sort
			// failed so just exit
			if (!topologicalSort(dict, stack, v, visited))
				return false;
		}
		// mark the current char visited and push him on the top of the stack
		visited[u - 'a'] = VISITED;
		stack.push(u);

		// topological sorting was successful
		return true;
	}

	private int getDifferenceIndex(String word1, String word2) {
		for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
			if (word1.charAt(i) != word2.charAt(i))
				return i;
		}
		// no meaningful difference found
		return -1;
	}

	private Map<Character, List<Character>> getDictionary(String[] words) {
		Map<Character, List<Character>> letters = new HashMap<>();
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!letters.containsKey(c)) {
					letters.put(c, new ArrayList<>());
				}
			}
		}
		return letters;
	}
}
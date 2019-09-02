package com.arise.hard.lexographic.newLan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//75% faster
public class Solution2 {
	public String alienOrder(String[] words) {
		Set<Character> letter = new HashSet();
		int[] in_degree = new int[26];
		Map<Character, Set<Character>> map = new HashMap();
		for (int i = 0; i < words.length; ++i) {
			add(letter, words[i]);
			if (i != words.length - 1)
				find(in_degree, map, words[i], words[i + 1]);
		}

		return toposort(letter, in_degree, map);
	}

	void add(Set<Character> letter, String s) {
		for (char c : s.toCharArray()) {
			letter.add(c);
		}
	}

	// given 2 strings, derive an order for 2 chars
	void find(int[] in_degree, Map<Character, Set<Character>> map, String a, String b) {
		int i = 0;
		int j = 0;
		while (i < a.length() && j < b.length()) {
			if (a.charAt(i) != b.charAt(j)) {
				// got the order: a[i] < b[j]
				char pre = a.charAt(i);
				char suc = b.charAt(j);
				Set<Character> sucs = map.get(pre);
				if (sucs == null) {
					sucs = new HashSet();
					sucs.add(suc);
					map.put(pre, sucs);
					in_degree[suc - 'a']++;
				} else {
					if (!sucs.contains(suc)) {
						sucs.add(suc);
						in_degree[suc - 'a']++;
					}
				}

				break;
			} else {
				++i;
				++j;
			}
		}
	}

	String toposort(Set<Character> letter, int[] in_degree, Map<Character, Set<Character>> m) {
		// BFS
		Queue<Character> q = new LinkedList();
		for (char c : letter) {
			if (in_degree[c - 'a'] == 0) {
				q.add(c);
			}
		}

		StringBuilder result = new StringBuilder();
		while (!q.isEmpty()) {
			char pre = q.poll();
			result.append(pre);
			letter.remove(pre);

			Set<Character> sucs = m.get(pre);
			if (sucs != null) {
				for (char suc : sucs) {
					if (letter.contains(suc)) {
						--in_degree[suc - 'a'];
						if (in_degree[suc - 'a'] == 0) {
							q.add(suc);
						}
					}
				}
			}
		}

		return letter.isEmpty() ? result.toString() : "";
	}
}

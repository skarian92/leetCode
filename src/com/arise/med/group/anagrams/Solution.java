package com.arise.med.group.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> ol = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			boolean flag = false;
			for (int j = 0; j < ol.size(); j++) {
				if (ifAnagram(ol.get(j).get(0), strs[i])) {
					ol.get(j).add(strs[i]);
					flag = true;
				}
			}

			if (!flag) {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				ol.add(list);
			}
		}

		return ol;
	}

	public boolean ifAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (s1.equals(s2))
			return true;
		Map<Character, Integer> map = new HashMap<>();
		char[] arr = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			Integer val = map.putIfAbsent(arr[i], 1);
			if (val != null) {
				map.put(arr[i], val + 1);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			Integer val = map.get(arr2[i]);
			if (val == null)
				return false;
			else if (val == 1)
				map.remove(arr2[i]);
			else
				map.put(arr2[i], val - 1);
		}

		if (map.size() > 0)
			return false;

		return true;
	}
}

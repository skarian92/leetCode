package com.arise.med.wordBreak;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	Map<String, Boolean> map = new HashMap<>();

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.equals(""))
			return true;
		if (map.containsKey(s))
			return map.get(s);

		for (String w : wordDict) {
			if (s.contains(w)) {
				int i = s.indexOf(w);
				if (wordBreak(s.substring(0, i), wordDict)
						&& wordBreak(s.substring(i + w.length(), s.length()), wordDict)) {
					map.put(s, true);
					return true;
				}
			}
		}

		map.put(s, false);
		return false;
	}

}

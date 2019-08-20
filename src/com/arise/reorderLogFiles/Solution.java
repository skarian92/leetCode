package com.arise.reorderLogFiles;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public String[] reorderLogFiles(String[] logs) {
		List<String> strlist = new ArrayList<>();
		List<String> numlist = new ArrayList<>();
		for (int i = 0; i < logs.length; i++) {
			String str = logs[i].substring(logs[i].indexOf(" ") + 1);
			if (str.charAt(0) >= (0 + '0') && str.charAt(0) <= (9 + '0')) {
				numlist.add(logs[i]);
			} else {
				binarySearch(strlist, logs[i], 0, strlist.size() - 1);
			}
		}

		strlist.addAll(numlist);

		String[] arr = new String[strlist.size()];
		return strlist.toArray(arr);
	}

	private void binarySearch(List<String> list, String s, int start, int end) {
		if (list.isEmpty()) {
			list.add(s);
			return;
		}
		if (start > end) {
			list.add(start, s);
			return;
		}

		int mid = start + (end - start) / 2;

		String midString = list.get(mid).substring(list.get(mid).indexOf(" ") + 1);
		String str = s.substring(s.indexOf(" ") + 1);
		if (midString.compareTo(str) < 0) {
			binarySearch(list, s, mid + 1, end);
		} else if (midString.compareTo(str) > 0) {
			binarySearch(list, s, start, mid - 1);
		} else {
			list.add(mid + 1, s);
			return;
		}
	}
}
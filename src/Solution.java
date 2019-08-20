class Solution {
	public int lengthOfLongestSubstring(String s) {

		int maxCount = 0;
		if (s == null || s.equals(""))
			return 0;
		else if (s.length() == 1)
			return 1;
		else {
			int start = 0, count = 1;
			for (int current = 1; current < s.length(); current++) {
				char currentChar = s.charAt(current);
				String currentString = s.substring(start, current);
				if (currentString.contains(String.valueOf(currentChar))) {
					count = current - start;
					start += currentString.indexOf(currentChar) + 1;
					if (count > maxCount) {
						maxCount = count;
					}
				}
			}
			maxCount = Math.max(maxCount, s.length() - start);
		}

		return maxCount;
	}
}
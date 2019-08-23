package com.arise.med.group.anagrams;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = { "lactated", "lactated" };
		boolean ifAnagram = new Solution().ifAnagram(strs[0], strs[1]);
		System.out.println(ifAnagram);
	}

}

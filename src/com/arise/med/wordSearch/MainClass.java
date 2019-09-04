package com.arise.med.wordSearch;

public class MainClass {

	public static void main(String[] args) {
		String word = "ABCCED";
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'C', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		boolean exist = new Solution().exist(board, word);
		System.out.println(exist);
	}

}

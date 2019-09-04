package com.arise.med.wordSearch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int m, n;

	public boolean exist(char[][] board, String word) {
		if (word.equals(""))
			return true;
		m = board.length;
		n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == word.charAt(0)) {
					if (method(i, j, 0, board, word, visited))
						return true;
				}
			}
		}
		return false;
	}

	public boolean method(int i, int j, int index, char[][] board, String word, boolean[][] visited) {
		if (index == word.length())
			return true;

		if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(index))
			return false;
		/*
		 * List<Pair> boxes = getBoxes(board, word.charAt(0), i, j, visited);
		 * 
		 * for (Pair box : boxes) { visited[i][j] = true; String subString =
		 * word.length() == 1 ? "" : word.substring(1); if (method(box.i, box.j,
		 * board, subString, visited)) { return true; } visited[i][j] = false;
		 * 
		 * }
		 */

		visited[i][j] = true;

		boolean match = method(i + 1, j, index + 1, board, word, visited)
				|| method(i - 1, j, index + 1, board, word, visited)
				|| method(i, j + 1, index + 1, board, word, visited)
				|| method(i, j - 1, index + 1, board, word, visited);

		visited[i][j] = false;
		return match;
	}

	private List<Pair> getBoxes(char[][] board, char c, int i, int j, boolean[][] visited) {
		List<Pair> list = new ArrayList<Solution.Pair>();
		// Left
		int a = i, b = j - 1;
		if (b >= 0 && board[a][b] == c && !visited[a][b]) {
			list.add(new Pair(a, b));
		}

		// Top
		a = i - 1;
		b = j;
		if (a >= 0 && board[a][b] == c && !visited[a][b]) {
			list.add(new Pair(a, b));
		}

		// Bottom
		a = i + 1;
		b = j;
		if (a < board.length && board[a][b] == c && !visited[a][b]) {
			list.add(new Pair(a, b));
		}

		// Right
		a = i;
		b = j + 1;
		if (b < board[0].length && board[a][b] == c && !visited[a][b]) {
			list.add(new Pair(a, b));
		}

		return list;

	}

	public class Pair {
		int i;
		int j;

		public Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}

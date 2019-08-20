package com.arise.reorderLogFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// String line = in.readLine();
		String line = "a1 9 2 3 1,g1 act car,zo4 4 7,ab1 off key dog,a8 act zoo";
		String[] array = line.split(",");
		Solution s = new Solution();

		String[] sortedArray = s.reorderLogFiles(array);
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
	}

}

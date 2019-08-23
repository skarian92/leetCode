package com.arise.meetingRooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	/*
	 * public static int[][] stringToInt2dArray(String input) { JsonArray
	 * jsonArray = JsonArray.readFrom(input); if (jsonArray.size() == 0) {
	 * return new int[0][0]; }
	 * 
	 * int[][] arr = new int[jsonArray.size()][]; for (int i = 0; i <
	 * arr.length; i++) { JsonArray cols = jsonArray.get(i).asArray(); arr[i] =
	 * stringToIntegerArray(cols.toString()); } return arr; }
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		// while ((line = in.readLine()) != null) {
		// int[][] intervals = stringToInt2dArray(line);
		// int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int[][] intervals = { { 13, 15 }, { 1, 13 } };
		int ret = new Solution().minMeetingRooms(intervals);

		String out = String.valueOf(ret);

		System.out.print(out);
		// }
	}
}

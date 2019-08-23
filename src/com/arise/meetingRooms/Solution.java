package com.arise.meetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public int minMeetingRooms(int[][] intervals) {

		if (intervals.length == 0)
			return 0;
		List<Meeting> list = new ArrayList<Meeting>();
		for (int i = 0; i < intervals.length; i++) {
			list.add(new Meeting('s', intervals[i][0]));
			list.add(new Meeting('e', intervals[i][1]));
		}

		Collections.sort(list, (m1, m2) -> {
			if (m1.time == m2.time) {
				return m1.type - m2.type;
			} else {
				return m1.time - m2.time;
			}
		});

		int count = 0;
		int max = Integer.MIN_VALUE;
		for (Meeting m : list) {
			if (m.type == 's') {
				count++;
			} else {
				count--;
			}

			if (count > max) {
				max = count;
			}
		}

		return max;
	}

	class Meeting {
		int time;
		char type;

		public Meeting(char type, int time) {
			this.time = time;
			this.type = type;
		}
	}
}

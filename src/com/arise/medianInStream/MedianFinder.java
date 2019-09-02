package com.arise.medianInStream;

import java.util.PriorityQueue;

class MedianFinder {

	PriorityQueue<Integer> minQueue = null;
	PriorityQueue<Integer> maxQueue = null;

	/** initialize your data structure here. */
	public MedianFinder() {
		minQueue = new PriorityQueue<>(50);
		maxQueue = new PriorityQueue<>(50, (a, b) -> b - a);

	}

	public void addNum(int num) {
		if (minQueue.size() == 0) {
			minQueue.add(num);
			return;
		}
		if (maxQueue.size() == minQueue.size()) {
			if (num < maxQueue.peek()) {
				minQueue.add(maxQueue.poll());
				maxQueue.add(num);
			} else {
				minQueue.add(num);
			}

		} else {
			if (num <= minQueue.peek()) {
				maxQueue.add(num);
			} else {
				maxQueue.add(minQueue.poll());
				minQueue.add(num);
			}
		}

	}

	public double findMedian() {
		if (maxQueue.size() == 0 && minQueue.size() == 0) {
			return 0.0;
		} else if (maxQueue.size() == 0) {
			return Double.valueOf(minQueue.peek());
		} else if (maxQueue.size() == minQueue.size()) {
			return (maxQueue.peek() + minQueue.peek()) / 2.0;
		} else {
			return Double.valueOf(minQueue.peek());
		}
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
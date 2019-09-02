package com.arise.medianInStream;

public class MainClass {

	public static void main(String[] args) {
		// PriorityQueue<Integer> minQueue = new PriorityQueue<>(50, (a, b) -> b
		// - a);
		MedianFinder mf = new MedianFinder();

		mf.addNum(1);
		mf.addNum(2);

		mf.addNum(3);

		System.out.println(mf.findMedian());

	}

}

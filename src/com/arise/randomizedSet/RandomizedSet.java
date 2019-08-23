package com.arise.randomizedSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
	Set<Integer> set = null;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		set = new HashSet<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (set.contains(val))
			return false;
		set.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (set.contains(val)) {
			set.remove(val);
			return true;
		}

		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int size = set.size();
		int item = new Random().nextInt(size);
		List<Integer> list = new ArrayList<Integer>(set);
		return list.get(item);

	}
}

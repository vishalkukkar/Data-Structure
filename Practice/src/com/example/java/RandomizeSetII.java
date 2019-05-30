package com.example.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class RandomizeSetII {

	public static void main(String[] args) {

	}

	class RandomizedSet {

		private Map<Integer, LinkedHashSet<Integer>> map;
		private List<Integer> list;
		private java.util.Random random;

		/** Initialize your data structure here. */
		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
			random = new java.util.Random();
		}

		/**
		 * Inserts a value to the set. Returns true if the set did not already
		 * contain the specified element.
		 */
		public boolean insert(int val) {

			LinkedHashSet<Integer> set = map.get(val);
			boolean res = set == null ? true : false;
			if (set == null)
				map.put(val, new LinkedHashSet<>());
			map.get(val).add(list.size());
			list.add(val);
			return res;
		}

		/**
		 * Removes a value from the set. Returns true if the set contained the
		 * specified element.
		 */
		public boolean remove(int val) {

			LinkedHashSet<Integer> set = map.get(val);
			boolean res = set != null ? true : false;
			if(!res) return false;
			
			int loc = set.iterator().next();
			set.remove(loc);
			if (loc < list.size() - 1) {
				Integer last = list.get(list.size() - 1);
				list.set(loc, last);
				
			}

			map.remove(val);
			list.remove(list.size() - 1);
			return res;

		}

		/** Get a random element from the set. */
		public int getRandom() {
			return list.get(random.nextInt(list.size())); // return nums.get(
															// rand.nextInt(nums.size())
															// );
		}
	}

}

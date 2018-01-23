package com.example.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class MergeIntervals {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}
		
		
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		// Merge Intervals
		/*
		 * List<Interval> intervals = new ArrayList<>(); intervals.add(new
		 * Interval(1, 4)); intervals.add(new Interval(2, 3));
		 * 
		 * List<Interval> res = merge(intervals); res.forEach(x -> {
		 * System.out.println("[" + x.start + " " + x.end + "]"); });
		 */

		// Check if person can attend all meetings
		Interval t1 = new Interval(0, 30);
		Interval t2 = new Interval(5, 10);
		Interval t3 = new Interval(15, 20);
		Interval[] interval = new Interval[3];
		interval[0] = t1;
		interval[1] = t3;
		interval[2] = t2;

		System.out.println(canAttendMeetings(interval));

	}

	public static boolean canAttendMeetings(Interval[] intervals) {
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.valueOf(o1.start).compareTo(Integer.valueOf(o2.start));
			}
		});
		
		
		System.out.println(Arrays.toString(intervals));
		
		
		
		
		return true;

	}

	public static List<Interval> merge(List<Interval> intervals) {

		if (intervals == null || intervals.size() == 0)
			return intervals;

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.valueOf(o1.start).compareTo(Integer.valueOf(o2.start));
			}
		});

		int i = 1;
		Stack<Interval> stack = new Stack<>();
		stack.add(intervals.get(0));

		while (i < intervals.size()) {

			Interval first = stack.pop();
			Interval second = intervals.get(i);

			// add only one item into stack
			if (first.end >= second.start) {

				int t1 = first.start;
				int t2 = first.end > second.end ? first.end : second.end;
				stack.push(new Interval(t1, t2));
			} else {
				// add both
				stack.push(first);
				stack.push(second);

			}
			i++;
		}
		return new ArrayList<>(stack);
	}

}

package com.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

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

	public static void main(String[] args) {

		// Merge Intervals
		/*
		 * List<Interval> intervals = new ArrayList<>(); intervals.add(new
		 * Interval(1, 4)); intervals.add(new Interval(2, 3));
		 * 
		 * List<Interval> res = merge(intervals); res.forEach(x -> {
		 * System.out.println("[" + x.start + " " + x.end + "]"); });
		 */

		// Check if person can attend all meetings

		Interval t1 = new Interval(1, 5);
		Interval t2 = new Interval(8, 9);
		Interval t3 = new Interval(8, 9);
		Interval[] interval = new Interval[3];
		interval[0] = t1;
		interval[1] = t3;
		interval[2] = t2;

		System.out.println(canAttendMeetings(interval));

	}

	private static int canAttendMeetings(Interval[] intervals) {

		if (intervals == null)
			return 0;

		if (intervals.length == 0 || intervals.length == 1)
			return intervals.length;

		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start < o2.start)
					return -1;
				else
					return 0;

			}
		});

		System.out.println(Arrays.toString(intervals));
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			Interval curr = intervals[i];
			if(curr.start >= queue.peek())
				queue.poll();
			queue.add(curr.end);
		}
		return queue.size();
	}

}

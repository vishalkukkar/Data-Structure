package com.example.arrayy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.util.Util;

public class InsertInterval {

	public static void main(String[] args) {

		List<Interval> l = new ArrayList<>();
		l.add(new Interval(1, 5));
		/*
		 * l.add(new Interval(3, 5)); l.add(new Interval(6, 7)); l.add(new
		 * Interval(8, 10)); l.add(new Interval(12, 16));
		 */

		Interval i = new Interval(2, 3);

		List<Interval> res = new InsertInterval().insert(l, i);

		for (Interval j : res) {
			System.out.println(j.start + " " + j.end);
		}

	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> res = new ArrayList<>();

		if (intervals == null || intervals.size() == 0) {
			res.add(newInterval);
			return res;
		}

		int i = 0;
		int len = intervals.size();

		while (i < len) {
			Interval interval = intervals.get(i);
			if (interval.end >= newInterval.start)
				break;
			res.add(interval);
			i++;
		}

		System.out.println(i);
		while (i < len && ( intervals.get(i).start <= newInterval.end)) {
			
			int start = Math.min(intervals.get(i).start, newInterval.start);
			int end = Math.max(intervals.get(i).end, newInterval.end);
			newInterval = new Interval(start, end);
			i++;

		}

		res.add(newInterval);

		while (i < len) {

			res.add(intervals.get(i));
			i++;
		}
		return res;

	}
}

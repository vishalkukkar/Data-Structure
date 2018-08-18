package com.example.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

	public static class Range {
		int start;
		int end;

		Range() {
			start = 0;
			end = 0;
		}

		Range(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

	}

	/***
	 * 
	 * @param args
	 * Apple Coderpad sample example:
	 *
	 *  Input : 1-10,14-35,3-3,9-25
	 * 
	 *  Output : 1-35
	 * 
	 * 
	 *  Input : 1-10, 11-20 25-30
	 * 
	 *  Output : 1-20, 25-30
	 *  
	 *  Note: For second example I think ans should be same as input as there is difference of 1 in 
	 *  1 - 10 and 11 - 20 so we shouldn't merge that interval but I implemented that case too 
	 *  for expected output mentioned
	 */
	public static void main(String[] args) {
		
		MergeInterval m = new MergeInterval();
		Range range1 = new Range(1, 10);
		Range range3 = new Range(3, 3);
		Range range2 = new Range(14, 35);
		Range range4 = new Range(9, 25);
		List<Range> ranges = new ArrayList<>();
		ranges.add(range1);
		ranges.add(range2);
		ranges.add(range3);
		ranges.add(range4);
	    System.out.println(m.merge(ranges));

		ranges.clear();
		Range range5 = new Range(1, 10);
		Range range6 = new Range(11, 20);
		Range range7 = new Range(25, 30);
		ranges.add(range5);
		ranges.add(range6);
		ranges.add(range7);
		System.out.println(m.merge(ranges));
	}

	public List<Range> merge(List<Range> list) {
		List<Range> result = new ArrayList<Range>();

		if (list == null || list.size() == 0)
			return result;

		Collections.sort(list, new Comparator<Range>() {
			public int compare(Range obj1, Range obj2) {
				if (obj1.start != obj2.start)
					return obj1.start - obj2.start;
				else
					return obj1.end - obj2.end;
			}
		});

		Range pre = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			Range curr = list.get(i);
			int max = Math.max(pre.end, curr.end);
			if (Math.abs(curr.start - pre.end) == 1) {
				Range merged = new Range(pre.start, max);
				pre = merged;
			}
			if (curr.start > pre.end) {
				result.add(pre);
				pre = curr;
			} else {
				Range merged = new Range(pre.start, max);
				pre = merged;
			}
		}
		result.add(pre);

		return result;
	}
}

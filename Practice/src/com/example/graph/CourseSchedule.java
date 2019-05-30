package com.example.graph;

import java.util.ArrayList;

public class CourseSchedule {

	public static void main(String[] args) {

		int[][] array = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 0 } };
		System.out.println(new CourseSchedule().canFinish(6, array));
		// for example to take course 0 you have to first take course 1,
		// which is expressed as a pair: [0,1]
		
		
	}

	static class Course {
		private boolean vis;
		private boolean done;
		private ArrayList<Course> pre = new ArrayList<Course>();

		void addPre(Course preCourse) {
			pre.add(preCourse);
		}

		boolean isCyclic() {
//			if (done) {
//				return false;
//			}
			if (vis) {
				return true;
			}
			vis = true;

			for (Course preCourse : pre) {
				if (preCourse.isCyclic()) {
					return true;
				}
			}

			vis = false;
			//done = true;
			return false;
		}
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Course clist[] = new Course[numCourses];

		for (int i = 0; i < numCourses; i++) {
			clist[i] = new Course();
		}

		for (int[] couple : prerequisites) {
			Course c1 = clist[couple[0]];
			Course c2 = clist[couple[1]];
			c1.addPre(c2);
		}

		for (int i = 0; i < numCourses; i++) {
			if (clist[i].isCyclic()) {
				return false;
			}
		}

		return true;
	}

}

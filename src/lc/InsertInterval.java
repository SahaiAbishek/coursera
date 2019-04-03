/*
 * 57 - https://leetcode.com/problems/insert-interval/
 */

package lc;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

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
			return "[" + start + "," + end + "]";
		}

	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		int newStart = Integer.MIN_VALUE;
		int newEnd = Integer.MIN_VALUE;
		for (int i = 0; i < intervals.size(); i++) {
			if (newStart == Integer.MIN_VALUE) {
				if (newInterval.start < intervals.get(i).start && newInterval.end < intervals.get(i).end) {
					newStart = newInterval.start;
					newEnd = newInterval.end;
				}
				if (newInterval.start <= intervals.get(i).start) {
					newStart = newInterval.start;
				} else if (intervals.get(i).start <= newInterval.start
						&& intervals.get(i + 1).start > newInterval.start) {
					newStart = intervals.get(i).start;
				}
				if (newInterval.end >= intervals.get(i).end && newInterval.end < intervals.get(i + 1).start) {
					newEnd = newInterval.end;
				}
			}

			if (newEnd == Integer.MIN_VALUE) {
				if (newInterval.end < intervals.get(i).end) {
					newEnd = intervals.get(i).end;
				}
			}

		}
		List<Interval> result = new ArrayList<>();
		System.out.println(newStart + " ," + newEnd);
		return result;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(6, 9));

		System.out.println(insert(intervals, new Interval(4, 5)));
	}
}

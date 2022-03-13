package com.shama.datastructures.LeetCode.arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
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

    public String toString() {
        return "[" + this.start + "," + this.end + "]" ;
    }
}
public class MergeIntervals {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return intervals;

        // sort intervals by using self-defined Comparator
        Collections.sort(intervals, new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start) {
                // merged case
                Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
                prev = merged;
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }

    public static void main(String[] args) {
        Interval v1 = new Interval(1,3);
        Interval v2 = new Interval(2,6);
        Interval v3 = new Interval(8,10);
        Interval v4 = new Interval(15,18);
        Interval v5 = new Interval(14,18);
        ArrayList<Interval> intervalList = new ArrayList<Interval>();

        intervalList.add(v1);
        intervalList.add(v2);
        intervalList.add(v3);
        intervalList.add(v4);
        intervalList.add(v5);

        System.out.println(merge(intervalList));

    }
}
class IntervalComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start; }
}

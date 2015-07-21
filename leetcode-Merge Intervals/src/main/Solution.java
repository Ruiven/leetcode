package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

class IntervalComparator implements Comparator<Interval> {
	
	public int compare(Interval v1, Interval v2) {
		if(v1.start == v2.start)
			return v1.end - v2.end;
		return v1.start - v2.start;		
	}
}

public class Solution {
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0)
			return res;
        Collections.sort(intervals, new IntervalComparator());
        
        res.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++) {
        	if(res.get(res.size()-1).end >= intervals.get(i).start)
        		res.get(res.size()-1).end = res.get(res.size()-1).end > intervals.get(i).end ? res.get(res.size()-1).end : intervals.get(i).end;
        	else
        		res.add(intervals.get(i));
        	
        	
        }
        return res;
    }
	
	public static void main(String[] args) {
		List<Interval> list = new ArrayList<>();
		Interval i1 = new Interval(1,4);
		Interval i2 = new Interval(0,2);
		Interval i3 = new Interval(3,5);
		// i4 = new Interval(15,18);
		list.add(i1);
		list.add(i2);
		list.add(i3);
	//	list.add(i4);
		List<Interval> res = merge(list);
		for(Interval interval : res) {
			System.out.println(interval.start + ", " + interval.end);
		}
		
	}
}

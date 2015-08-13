package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        if(numRows == 0)
        	return res;
        row.add(1);
        res.add(new ArrayList<>(row));
        row.clear();
        for(int i = 2 ; i <= numRows; i++) {
        	row.add(1);
        	for(int j = 0 ; j < res.get(res.size()-1).size()-1; j++) {
        		row.add(res.get(res.size()-1).get(j) + res.get(res.size()-1).get(j+1));
        	}
        	row.add(1);
        	res.add(new ArrayList<>(row));
        	row.clear();
        }
        return res;
    }
	
	public static void main(String[] args) {
		generate(3);
	}
}

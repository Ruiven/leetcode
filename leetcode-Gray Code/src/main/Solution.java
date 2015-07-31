package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
public List<Integer> grayCode(int n) {
	 if(n == 0) {
         List<Integer> res = new ArrayList<>();
     	res.add(0);
     	return res;
     }
     	
     List<Integer> temp = grayCode(n-1);
     int add = 1 << (n-1);
     List<Integer> res = new ArrayList<>(temp);
     for(int i = temp.size()-1; i >= 0; i--)
     	res.add(temp.get(i)+add);
     
     return res;
    }
}

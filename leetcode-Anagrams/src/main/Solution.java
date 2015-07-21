package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static List<String> anagrams(String[] strs) {
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<String> res = new ArrayList<String>();
		
		if(strs == null || strs.length == 0)
			return res;
		
		if(strs.length == 1 )
			return res;
		
		boolean[] firstIndex = new boolean[strs.length];
		for (int i = 0; i < strs.length; i++) {
			
			char []temp = strs[i].toCharArray();
			Arrays.sort(temp);
			String tempString = String.valueOf(temp);
			if(!map.containsKey(tempString)) {
				
				map.put(tempString, i);
			}
				
			else {
				firstIndex[map.get(tempString)] = true;
				res.add(strs[i]);
			}
		}	
		for(int i = 0; i < firstIndex.length; i++)
			if(firstIndex[i])
				res.add(strs[i]);
		return res;
    }
	
	public static void main(String[] args) {
		String[] strs = {"", "", ""};
		System.out.println(anagrams(strs));
	}
}

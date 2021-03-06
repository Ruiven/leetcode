package main;

public class Solution {
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		
        for(int i = 0; i < strs[0].length(); i++) {        	
        	for(String s : strs) {
        		if(i >= s.length())
        			return strs[0].substring(0, i); 
        		if(!s.substring(0, i+1).equals(strs[0].substring(0, i+1))) 
        			return strs[0].substring(0, i);    
        		
        			
        	}       	
        }
        
        return strs[0];
    }
	
	public static void main(String[] args) {
		String[] stringList = {"sdfsdf", "helloworld"};
		System.out.println(longestCommonPrefix(stringList));
	}
}

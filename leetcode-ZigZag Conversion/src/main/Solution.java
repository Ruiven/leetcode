package main;

public class Solution {
	public static String convert(String s, int numRows) {
		
		if(numRows == 1)
			return s;
		if(numRows >= s.length())
		    return s;
		
        String res = "";
        int pos = 0;
        int step = 2*numRows-2;
        
        
        for(int i = 0 ; i < numRows; i++ ) {
        	for(int j = i ; j < s.length(); j += step) {
        		res = res + s.charAt(j);
        		if(i != 0 && i != numRows-1 && j+2*numRows-2*i-2 < s.length())
        			res = res + s.charAt(j+2*numRows-2*i-2);
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(convert("jygxbzmralrbcnqjauietpxvllbffkfrilqlmccoqwpsjidlclpwcmtnzwtghaxropfaujpkfgeqohb", 68));
	}
}

package main;

public class Solution {
	public static int[] plusOne(int[] digits) {
		int up = 1;
        for(int i = digits.length-1; i >= 0; i--) {
        	digits[i] += up;
        	up = digits[i] / 10;
        	if(up == 0)
        		break;
        	digits[i] %= 10;
        }
        if(up > 0) {
        	int head[] = new int[1];
        	head[0] = up;
        	int []res = new int[digits.length+1];
        	
        	System.arraycopy(head, 0, res, 0, 1);
        	System.arraycopy(digits, 0, res, 1, digits.length);
        	return res;
        }
        
        
        return digits;
        
    }
	
	public static void main(String[] args) {
		int digits[] = {9};
		plusOne(digits);
	}
}

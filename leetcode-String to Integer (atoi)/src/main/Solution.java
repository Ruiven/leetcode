package main;

public class Solution {
	public static int myAtoi(String str) {
		boolean start = false;
		int sign = 1;
		int num= 0;
        for(int i = 0; i < str.length(); i++ ) {
        	if(str.charAt(i) == ' ') {
        		if(start)
        			break;
        		continue;
        	}
        	
        	
        	else if(str.charAt(i) == '-') {
        		if(start)
        			break;
        		sign = -1;
        		start = true;
        		
        	}
        	else if(str.charAt(i) == '+') {
        		if(start)
        			break;
        		sign = 1;
        		start = true;
        		
        	}
        	
        	else if(str.charAt(i)-'0' < 0 || str.charAt(i)-'0' > 9)
        		break;
        	
        	else {
        		start = true;
        		num *= 10;
        		num += str.charAt(i) - '0'; 
        		
        		if(sign == -1) {
        			int max = 2147483647;
        			if((num > max/10 ||  num*10 < 0 || num == max/10 && str.charAt(i+1)-'0' >= 8) && i < str.length()-1 && str.charAt(i+1)-'0' >= 0 && str.charAt(i+1)-'0' <= 9  )
    	        		return -max-1;
    	        	
        		}
        		else {
        			int max = 2147483647;
        			
        			
        			if((num > max/10 ||  num*10 < 0 || num == max/10 && str.charAt(i+1)-'0' >= 8) && i < str.length()-1 && str.charAt(i+1)-'0' >= 0 && str.charAt(i+1)-'0' <= 9  )
    	        		return max;
        		}
        		
        	}
        	
        }
        if(sign == 0)
        	sign = 1;
        return num * sign;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("-1233333333333333333333"));
	}
}

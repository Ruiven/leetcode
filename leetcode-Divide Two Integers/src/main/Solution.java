package main;

public class Solution {
	public static int divide(int dividend, int divisor) {
        long divid = Math.abs((long)dividend), divis = Math.abs((long)divisor);
        if(divisor == 1)
        	return dividend;
		if(dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		
		
		int res = 0;
		
		while(divid >= divis) {
			long a = divis;
			int i;
			for(i = 1 ; a <= divid; i++)
				a <<= 1;
			
			divid -= divis << (i-2);
			res += 1 << (i-2);
		}
		
		if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
			res = - res;
		
		
		return res;
		
    }
	
	public static void main(String[] args) {
		System.out.print(divide(-2147483648, -1));
	}
}

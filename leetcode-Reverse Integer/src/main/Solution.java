package main;

public class Solution {
	public static int reverse(int x) {
        
        //x = x >0 ? x : -x;
		int res = 0 ;
        
        
        
        if(x > 0) {
        	int max = 2147483647;
	        while(x != 0) {
	        	res *= 10;
	        	res += x % 10;
	        	if(res > max/10 && x/10 > 0 || (res == max/10 && (x/10)%10 > 7))
	        		return 0;
	        	x /= 10;
	        }
        }
        
        else {
        	int max = -2147483648;
        	while(x != 0) {
	        	res *= 10;
	        	res += x % 10;
	        	int a = max / 10;
	        	if(res < max/10 && x/10 < 0 || res*10 > 0 && x/10 < 0)
	        		return 0;
	        	if(res == max/10 && (x/10)%10 < -8)
	        		return 0;
	        	x /= 10;
	        }
        	
        }
        
        
        
        return res;
		
    }
	public static void main(String[] args) {
		System.out.print(reverse(-2147483412));
	}
}

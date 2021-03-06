package main;

public class Solution {
    public static boolean isPalindrome(int x) {
    	
    	if(x < 0)
    		return false;
    	if(x < 10)
    		return true;
    		
        int bits = 0;
        int copy = x;
        while(copy != 0) {
        	bits++;
        	copy /= 10;
        }
        
        boolean pal = true;
        int i = 0;
        while(i <= (bits-2)/2 ) {
        	if(getBit(x, i) != getBit(x, bits-i-1))
        		return false;
        		i++;
        	
        }
        return true;
    }
    
    static int getBit(int x, int bit) {
    	
    	return (int) (x/Math.pow(10, bit) % 10);
    }
    
    public static void main(String[] args) {
		System.out.print(isPalindrome(-2147483648));
	}
}

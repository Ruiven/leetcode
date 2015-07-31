package main;

public class Solution {
	public static int mySqrt(int x) {
		double temp = x/2;
		double next;
		while(true) {
			
			next = 1.0/2*(temp+x/temp);
			if(Math.floor(next) == Math.floor(temp))
				return (int)Math.floor(temp);
			temp = next;
			
		}
        
    }
	
	public static void main(String[] args) {
		System.out.println(mySqrt(25));
	}
}

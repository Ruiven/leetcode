package main;

public class Solution {
	public static double myPow(double x, int n) {
		if(n < 0)
			return 1.0/_myPow(x, -n);
		else
			return _myPow(x,n);
    }
	
	static double _myPow(double x, int n) {
		if(n == 0)
			return 1;
		double temp = _myPow(x, n/2);
		if(n % 2 == 0)
			return temp*temp;
		else 
			return temp * temp * x;
		
	}
	
	public static void main(String[] args) {
		System.out.print(myPow(2, -3));
	}
}

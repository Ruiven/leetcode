package main;

public class Solution {
	
	
	
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int l = (A.length + B.length + 1)/2;
    	int r = (A.length + B.length + 2)/2;
    	int a = getkth(A, A.length, 0, B, B.length, 0, l);
    	int b = getkth(A, A.length, 0, B, B.length, 0, r);
    	return (double) (a+b)/2;    	
        
    }
    
    
    public static int getkth(int A[], int m, int ap, int B[], int n, int bp, int k) {
    	if(m > n) {
    		return getkth(B, n,bp, A, m, ap, k);
    	}
    	
    	if(m == 0) {
    		return B[bp + k -1];
    	}
    	
    	if(k == 1) {
    		return (A[ap] < B[bp] ? A[ap] : B[bp]);
    	}
    	
    	int aHalf = m < k/2 ? m : k/2;
    	int bHalf = n < k/2 ? n : k/2;
    	
    	if(A[ap + aHalf-1] <= B[bp + bHalf-1]) {
    		return getkth(A, m-aHalf,ap+aHalf, B, n, bp, k-aHalf);
    	}
    	
    	else {
    		return getkth(A, m, ap, B, n-bHalf, bp+bHalf, k-bHalf);
    	}
    }
    
    
    public static void main(String[] args) {
    	
    	int A[] = {1};
    	int B[] = {2,3,4,5,6};
    	System.out.println(findMedianSortedArrays(A, B));
    	//getkth(A, A.length, 0, B, B.length, 0, 4);
		
	}
}
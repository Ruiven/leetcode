package main;

public class Solution {
	public static String multiply(String num1, String num2) {
        String res = "";
        String mid = "";
        int up = 0;
        
        for(int i = 0 ; i < num2.length(); i++) {
        	mid = mid + "0";
        	up = 0;
        	for(int j = num1.length()-1; j >= 0; j--) {
        		int temp = (num1.charAt(j)-'0') * (num2.charAt(i)-'0') + up;
        		res = (char)(temp%10+ '0') + res;
        		up = temp / 10;	
        	}
        	if(up > 0)
        		res = (char)(up + '0') + res;
        	
        	int k = 0;
        	up = 0;
        	String tempString = "";
        	while(k < res.length() && k < mid.length()) {
        		int temp = res.charAt(res.length()-1-k) - '0' + mid.charAt(mid.length()-1-k) - '0' + up;
        		tempString = (char)(temp % 10 + '0') + tempString;
        		up = temp/10;
        		k++;
        	}
        	while(k < mid.length()) {
        		int temp = mid.charAt(mid.length()-1-k) - '0' + up;
        		tempString = (char)(temp % 10 + '0') + tempString;
        		up = temp/10;
        		k++;
        	}
        	while(k < res.length()) {
        		int temp = res.charAt(res.length()-1-k) - '0' + up;
        		tempString = (char)(temp % 10 + '0') + tempString;
        		up = temp/10;
        		k++;
        	}
        	if(up > 0)
        		tempString = (char)(up + '0') + tempString;
        	mid = tempString;
        	res = "";
        	
        }
        
        int i = 0;
        if(mid.length() > 1)
	        while(i < mid.length()-1) {
	        	if(mid.charAt(i) != '0')
	        		break;
	        	i++;
	        }
		return mid.substring(i);
		
		
    }
	
	public static void main(String[] args) {
		System.out.println(multiply("140", "721"));
	}
}

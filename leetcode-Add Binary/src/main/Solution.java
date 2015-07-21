package main;

public class Solution {
	public static String addBinary(String a, String b) {
        int i = 0;
        String res = "";
        int up = 0;
        while(a.length()-i > 0 && b.length()-i > 0) {
        	int num1 = a.charAt(a.length()-1-i) - '0';
        	int num2 = b.charAt(b.length()-1-i) - '0';
        	res = (num1 + num2 + up) % 2 + res;
        	up = (num1 + num2 + up) / 2;
        	i++;
        }
        while(a.length()-i > 0) {
        	int num1 = a.charAt(a.length()-1-i) - '0';
        	res = (num1 + up) % 2 + res;
        	up = (num1 + up) / 2;
        	i++;
        }
        
        while(b.length()-i > 0) {
        	int num2 = b.charAt(b.length()-1-i) - '0';
        	res = (num2 + up) % 2 + res;
        	up = (num2 + up) / 2;
        	i++;
        }
        if(up > 0)
        	res = up + res;
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(addBinary("1111", "1"));
	}
}

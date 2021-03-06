package main;

public class Solution {
	public static String intToRoman(int num) {
        String roman = "";
		int numOfThou = num/1000;
        for(int i = 0 ; i < numOfThou; i++)
        	roman = roman + "M";
        
        int numOfHund = (num-numOfThou*1000)/100;
        if(numOfHund == 9) {
        	roman = roman + "CM";
        }
        else if(numOfHund >= 5) {
        	roman = roman + "D";
        	for(int i = 0; i < numOfHund-5; i++)
        		roman = roman + "C";
        }
        else if(numOfHund == 4)
        	roman = roman + "CD";
        else {
        	for(int i = 0; i < numOfHund; i++)
        		roman = roman + "C";
        }
        
        int numOfTen = (num-numOfThou*1000-numOfHund*100)/10;
        if(numOfTen == 9)
        	roman = roman + "XC";
        else if(numOfTen >= 5) {
        	roman = roman + "L";
        	for(int i = 0; i < numOfTen-5; i++)
        		roman = roman + "X";
        }
        else if(numOfTen == 4)
        	roman = roman + "XL";
        else {
        	for(int i = 0; i < numOfTen; i++)
        		roman = roman + "X";
        }
        
        int numOfOne = num % 10;
        if(numOfOne == 9)
        	roman = roman + "IX";
        else if(numOfOne >= 5) {
        	roman = roman + "V";
        	for(int i = 0; i < numOfOne-5; i++)
        		roman = roman + "I";
        }
        else if(numOfOne == 4)
        	roman = roman + "IV";
        else {
        	for(int i = 0; i < numOfOne; i++)
        		roman = roman + "I";
        }
        return roman;
        
    }
	
	public static void main(String[] args) {
		System.out.print(intToRoman(1));
	}
}

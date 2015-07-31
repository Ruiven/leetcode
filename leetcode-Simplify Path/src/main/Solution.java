package main;

import java.util.Stack;

public class Solution {
	public static String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Stack<String> strStack = new Stack<>();
        int i = 0;
        while(i < strArr.length) {
        	if(strArr[i].equals(".")) {
        		i++;
        		continue;
        	}
        		
        	else if(strArr[i].equals("..")) {
        		if(strStack.isEmpty()) {
        			i++;
        			continue;
        		}
        			
        		else {
					strStack.pop();
				}
        		
        	}
        	else if(strArr[i].equals("")) {
        		i++;
        		continue;
        	}
        		
        	else {
        		strStack.push(strArr[i]);
        	}
        	i++;	
        		
        }
        String res = "";
        i = 0;
        while(!strStack.isEmpty()) {
        	res = strStack.pop() + res;
        	res = "/" + res;
        }
        
        if(res.equals(""))
        	res += "/";
        return res;
    }
	public static void main(String[] args) {
		System.out.print(simplifyPath("/abc/..."));
	}
}

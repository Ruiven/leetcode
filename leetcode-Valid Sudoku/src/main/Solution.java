package main;

public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        
    	boolean used[] = new boolean[10];
    	//check every row
    	for(int i = 0 ; i < board.length; i++ ) {
    		for(int j = 0 ; j < board.length; j++) {
    			if(board[i][j] == '.')
    				continue;
    			if(used[board[i][j]-'0'])
    				return false;
    			used[board[i][j]-'0'] = true;
    		}
    		
    		for(int j = 0 ; j < 10; j++)
    			used[j] = false;
    	}
    	
    	//check every column
    	for(int i = 0 ; i < board.length; i++ ) {
    		for(int j = 0 ; j < board.length; j++) {
    			if(board[j][i] == '.')
    				continue;
    			if(used[board[j][i]-'0'])
    				return false;
    			used[board[j][i]-'0'] = true;
    		}
    		
    		for(int j = 0 ; j < 10; j++)
    			used[j] = false;
    	}
    	
    	//check every squares
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++ ) {
    			for(int p = 0; p < 3; p++) {
    				for(int q = 0; q < 3; q++) {
    					if(board[i*3+p][j*3+q] == '.')
    	    				continue;
    	    			if(used[board[i*3+p][j*3+q]-'0'])
    	    				return false;
    	    			used[board[i*3+p][j*3+q]-'0'] = true;
    					
    				}
    			}
    			for(int k = 0 ; k < 10; k++)
    				used[k] = false;
    			
    		}
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
		char[][] board = new char[9][9];
		String[] charStrings = {".87654321","2........","3........","4........","5........","6........","7........","8........","9........"};
		for(int i = 0 ; i < 9; i++)
			board[i] = charStrings[i].toCharArray();
		System.out.println(isValidSudoku(board));
	}
}
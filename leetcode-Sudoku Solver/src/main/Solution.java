package main;

public class Solution {
	public char[][] copy;
	public void solveSudoku(char[][] board) {
		copy = new char[9][9];
        backtrack(board, 0);
        for(int i = 0 ; i < 9; i++)
			for(int j = 0 ; j < 9; j++)
				board[i][j] = copy[i][j];
    }
	
	public void backtrack(char[][] board, int pos) {
		if(pos == 81) {
			for(int i = 0 ; i < 9; i++)
				for(int j = 0 ; j < 9; j++)
					copy[i][j] = board[i][j];
			return;
		}
			
		if(board[pos/9][pos - pos/9*9] != '.') {
			backtrack(board, pos+1);
			return;
		}
		
		for(int i = 1 ; i <= 9; i++) {
			board[pos/9][pos - pos/9*9] = (char) ('0' + i);
			if(isValidSudoku(board))
				backtrack(board, pos+1);
			board[pos/9][pos - pos/9*9] = '.';
		}
	
	}
	
	public boolean isValidSudoku(char[][] board) {
        
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
		Solution solution = new Solution();
		char[][] board = new char[9][9];
		String[] charStrings = {"....7....",".783.61.2","9...28.67","...96....","2..7....9","....83...","52.43...1","6.48.237.","....5...."};
		for(int i = 0 ; i < 9; i++)
			board[i] = charStrings[i].toCharArray();
		solution.solveSudoku(board);
		for(int i = 0 ; i < 9; i++)
			System.out.println(String.valueOf(board[i]));
	}
}


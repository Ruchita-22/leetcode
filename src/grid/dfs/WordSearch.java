package grid.dfs;



public class WordSearch {
	//79. Word Search
	//https://leetcode.com/problems/word-search/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean exist(char[][] grid, String word) {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == word.charAt(0) && dfs(grid,i,j,0,word))
					return true;
			}
		}
		return false;
        
    }
	public static boolean dfs(char[][] grid, int i, int j, int count, String word) {
		if(count == word.length())
			return true;
		if(i>=0 && i< grid.length && j>=0 && j< grid[0].length && grid[i][j] == word.charAt(count)) {
			char temp = grid[i][j];
			grid[i][j] = '#';
			boolean found = dfs(grid, i-1, j, count+1, word) || dfs(grid, i+1, j, count+1, word) || dfs(grid, i, j-1, count+1, word) || dfs(grid, i, j+1, count+1, word);
			grid[i][j] = temp;
			return found;
		}
		
		return false;
	}
}

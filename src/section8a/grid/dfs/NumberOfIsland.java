package section8a.grid.dfs;

public class NumberOfIsland {
	//200. Number of Islands
	//https://leetcode.com/problems/number-of-islands/
	//learning : codebix
	//take standard we need to count something so one count variable
	// we are given grid so 2D array = grid 
	//We always use DFS in grid so dfs function 
	//as grid is there we always use two loop
	// jis element ko change kar diya uske value change karne hai 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','1'},
				{'0','0','1','1','0'}
			};
		System.out.println(numIslands(grid));
	}
	public static int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					dfs(grid,i,j);
					
				}
				
			}
		}
		return count;
	}
	public static void dfs(char[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		//check boundary condition
		if (i>=0 && i < grid.length && j>=0 && j<grid[0].length && grid[i][j]=='1') {
			grid[i][j] = '0';
			dfs(grid, i-1, j); 				//check left
			dfs(grid, i+1, j); 				//check right
			dfs(grid, i, j-1);  			//check top
			dfs(grid, i, j+1);  			//check bottom
		}
		
	}
	

}



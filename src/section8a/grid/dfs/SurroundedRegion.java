package section8a.grid.dfs;

public class SurroundedRegion {
	//130. Surrounded Regions
	//https://leetcode.com/problems/surrounded-regions/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'},
				{'X','O','X','O','X','O'},
				{'O','X','O','X','O','X'}
				
			};
		System.out.println(grid.length+" "+grid[0].length);
		solve(grid);
		System.out.println("=========================");
		print(grid);
	}
	
	public static void solve(char[][] grid) { 
		if (grid == null || grid.length == 0) 
			return;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 'O') {
					if(i == 0 || i == grid.length-1 || j==0 || j == grid[0].length-1)
						dfs(grid, i, j);
				}
			}
		}
		print(grid);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 'O') {
					grid[i][j] = 'X';
				}
				if(grid[i][j] == '#')
					grid[i][j] = 'O';
					
			}
		}
	}
	public static void dfs(char[][] grid, int i, int j) {
		if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 'O') {
			grid[i][j] = '#';
			dfs(grid, i-1, j);
			dfs(grid, i+1, j);
			dfs(grid, i, j-1);
			dfs(grid, i, j+1);
		}
		
	}
	private static void print(char[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
}

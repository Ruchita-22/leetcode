package grid.dfs;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
				{1,1,1},
				{1,1,0},
				{1,0,1},
		};
		System.out.println(grid);

	}
	public static int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
		int oldColor = grid[sr][sc];
		if(grid[sr][sc] == newColor)
			return grid;
		dfs(grid,sr,sc,newColor,oldColor); 
		return grid;
	        
	 }
	public static void dfs(int[][] grid, int i, int j, int newColor, int oldColor) {
		// TODO Auto-generated method stub
		if(i < 0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != oldColor) 
			return;
		grid[i][j] = newColor;
		dfs(grid,i-1,j,newColor,oldColor);
		dfs(grid,i+1,j,newColor,oldColor);
		dfs(grid,i,j-1,newColor,oldColor);
		dfs(grid,i,j+1,newColor,oldColor);
		
	}

}

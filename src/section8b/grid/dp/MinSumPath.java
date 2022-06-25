package section8b.grid.dp;

import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class MinSumPath {
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] =  {{1,3,1},{1,5,1},{4,2,1}};
		
		System.out.println(minPathSum(grid));
	}
	 public static int minPathSum(int[][] grid) {
	        if(grid == null || grid.length == 0 || grid[0].length == 0)
				return 0;
	       map.clear();
	        return minSumPath(0,0,grid);
	    }
	    
	    public static int minSumPath(int row, int col, int[][] grid) {
			if(row == grid.length-1 && col == grid[0].length-1  )
				return grid[row][col];
			if(row > grid.length-1 || col > grid[0].length-1  )
				return Integer.MAX_VALUE;
			String key = row + "and"+ col;
			if(map.containsKey(key))
				return map.get(key);
			int cost = Math.min(minSumPath(row+1, col, grid), minSumPath(row, col+1, grid));
			map.put(key, grid[row][col]+cost);
			return grid[row][col]+cost;
		}

}

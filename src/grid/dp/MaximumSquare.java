package grid.dp;

import java.util.*;

//221. Maximal Square
//https://leetcode.com/problems/maximal-square/
public class MaximumSquare {
	static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
							{1,0,1,0,0},
							{1,0,1,1,1},
							{1,1,1,1,1},
							{1,0,0,1,0}
						};
		System.out.println(maximumSquare(0,0,grid));
		
	}

	private static int maximumSquare(int row, int col, int[][] grid) {
		// TODO Auto-generated method stub
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		map.clear();
		int max = 0;
		int curr_max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				curr_max = getMaximumSquare(i,j,grid);
				max = curr_max > max ? curr_max : max;
			}
		}
		 return max * max;
	
	}

	private static int getMaximumSquare(int i, int j, int[][] grid) {
		if(i>=grid.length || j >=grid[0].length || grid[i][j] == 0)
			return 0;
		String key = i + "#" + j;
		if(map.containsKey(key))
			return map.get(key);
		int ans = 1 + Math.min(getMaximumSquare(i+1, j+1, grid), Math.min(getMaximumSquare(i+1, j, grid), getMaximumSquare(i, j+1, grid)));
		map.put(key, ans);
		return ans;
	}
	

}

package matrix;

import java.util.Iterator;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = { {1,2,3},{4,5,6},{7,8,9}};
		printGrid(grid);
		grid=rotateAnticlockwise(grid);
		System.out.println("===============");
		printGrid(grid);
		

	}
	private static void printGrid(int grid[][]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int[][] transpose(int grid[][]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < i; j++) {
				if(i!=j) {
					int temp = grid[j][i];
					grid[j][i]=grid[i][j];
					grid[i][j]=temp;
				}	
			}
		}
		return grid;

	}
	private static int[][] rotateAnticlockwise(int grid[][]) {
		// TODO Auto-generated method stub
		//first take transpose and then swap top and last row and swap second row to second last row
		grid=transpose(grid);
		int n=grid.length;
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int temp = grid[i][j];
				grid[i][j]=grid[n-1-i][j];
				grid[n-1-i][j]=temp;
			}
		}
		return grid;
	}
	private static void sprialPrint(int grid[][]) {
		// TODO Auto-generated method stub
		int t = 0, d=grid.length-1,l=0,r=grid[0].length-1;
		int dir = 0;
		while(t<=d && l<=r) {
			if(dir==0) {
				for (int i = 0; i < grid[t].length; i++) 
					System.out.println(grid[t][i]);
				t++;
			}
			if(dir==1) {
				for (int i = t; i < grid.length; i++) 
					System.out.println(grid[i][r]);
				r--;
			}
			if(dir==2) {
				for (int i = grid[0].length-1; i >=0; i--) 
					System.out.println(grid[d][i]);
				d--;
				
			}
			if(dir==4) {
				for (int i = grid.length-1; i >=0; i--) 
					System.out.println(grid[i][l]);
				l++;
			}
			dir = (dir+1)%4;
		}

	}
	

}

package section1.binary_serach;

public class BinarySearchOnMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNegatives(int[][] grid) {

		int n = grid.length;
		int m = grid[0].length;

		int count = 0;
		int i = 0, j = m - 1;

		while (i < n && j >= 0) {
			if (grid[i][j] < 0) {
				count += n - i;
				j--;
			} else if (grid[i][j] >= 0) {
				i++;
			}
		}
		return count;

	}

	// 74. Search a 2D Matrix
	// https://leetcode.com/problems/search-a-2d-matrix/
	// https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
	public boolean searchMatrix(int[][] matrix, int target) {
		int i = 0, j = matrix[0].length - 1;

		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] > target)
				j--;
			else if (matrix[i][j] < target)
				i++;
		}
		return false;
	}

}

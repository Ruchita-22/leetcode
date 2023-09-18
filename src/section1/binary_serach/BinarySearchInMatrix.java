package section1.binary_serach;

public class BinarySearchInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int searchMatrix(int[][] mat, int target) {
        int i=0,j=mat[0].length-1;

        while(i<mat.length && j>=0){
            if(mat[i][j]==target)   return 1;
            else if(mat[i][j]>target) j--;
            else    i++;

        }
        return 0;
    }

}

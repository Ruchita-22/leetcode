package other;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class Kadane_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {-2,-3,4,-1,-2,1,5,-3};
		System.out.println(kandane(array));
		

	}

	public static int kandane(int[] array) {
		// TODO Auto-generated method stub
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for (int i = 0; i < array.length; i++) {
			max_ending_here += array[i];
			max_ending_here = max_ending_here < array[i] ? array[i] : max_ending_here;
			max_so_far = max_so_far < max_ending_here ? max_ending_here : max_so_far;
			
		}
		return max_so_far;
	}

}


//we are given an array and we need to find the largest sum contiguous array
//3 variation --  all +ve no. , all -ve no, both +ve and -ve no.

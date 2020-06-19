package subarray;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

public class SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 4, 20, 3, 10, 5};
		//subArraySum(arr, sum);

	}
	
	
	/*
	find the sum of contiguous subarray which has the largest sum. = kadane's algo
	{-2, -3, 4, -1, -2, 1, 5, -3}
	max Sum(SubArray)
	*/
	public static int maxSubArraySum(int arr[]) {
		int msf = 0;
		int meh = 0;
		for (int i = 0; i < arr.length; i++) {
			meh = Math.max(meh+arr[i], arr[i]);
			msf = Math.max(msf, meh);
		}
		return msf;
		
	}

}

package dp.knapsack_0_1;

public class SubsetSum {
	static boolean dp[][] = new boolean[100][1000];
	//subset with given sum is present or not
	public boolean subsetSum(int[] arr, int sum) {
		// TODO Auto-generated method stub
		//base condition
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < sum+1; j++) {
				if(i==0)
					dp[i][j] = false;
				if(j==0)
					dp[i][j] = true;
			}
		}
		//choice diagram
		for (int i = 1; i < arr.length+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if(arr[i-1] <= sum)
					dp[i][j] = dp[i-1][sum-arr[i-1]] || dp[i-1][sum];
				else 
					dp[i][j] = dp[i-1][sum];
			}
			
		}
		return dp[arr.length][sum];
	}
	//subset with equal subset is present or not
	public boolean equalSumSubset(int[] arr) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if(sum%2 != 0)
			return false;
		else 
			subsetSum(arr, sum/2);
			
		return false;
	}
	//subset with s1-s2 = difference is present or not
	public boolean subsetDiff(int[] arr, int diff) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		int subSetSum = (diff+sum)/2;
		
		return subsetSum(arr, subSetSum);
	}
	
	
}

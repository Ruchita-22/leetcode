package section5.dp.unboundKnapsack;

import java.util.Arrays;

public class RodCutting {
	//static int dp[][] = new int[1001][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	private static int rodCutting(int price[],int n) {

	    if (n == 0) 
	        return 0;
	    
	    int maxValue = Integer.MIN_VALUE;
	 
	    for (int i = 1; i <= n; i++) {
	    	maxValue = Math.max(maxValue, price[i-1] + rodCutting(price, n - i));
	    }	
	    return maxValue;
	}
	static int dp[][] = new int[1001][1001];
	private static int unboundedKnapsack(int[] len, int[] v, int L, int n) {
		
		//Base Condition
		if( L==0 ||	n==0 )
			return 0;
		
		if( dp[n][L] != -1 )
			return dp[n][L];
		
		//choice diagram
		if( len[n-1] <= L ) {
			return dp[n][L] = Math.max(v[n-1] + unboundedKnapsack(len, v, L-len[n-1], n), unboundedKnapsack(len, v, L, n-1));
			}
		else
			return dp[n][L] = unboundedKnapsack(len, v, L, n-1);
	}

}

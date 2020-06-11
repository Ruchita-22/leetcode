package knapsack_0_1;

import java.util.Arrays;
import java.util.Iterator;

public class KnapsackApplication {
	
	int dp[][] = new int[1001][1001];
	
	
	public KnapsackApplication() {
		super();
		for (int[] temp : dp) {
			Arrays.fill(temp, -1);
		}
		
	}


	public int knapsack(int[] w, int[] v, int W, int n) {
		
		// TODO Auto-generated method stub
		//Recusive Approach
		//Base Condition
//		if( W==0 ||	n==0 )
//			return 0;
//		
//		//choice diagram
//		if(w[n-1]<=W) {
//			return Math.max(v[n-1] + knapsack(w, v, W-w[n-1], n-1), knapsack(w, v, W, n-1));
//			}
//		else
//			return knapsack(w, v, W, n-1);
		
		
		//memorization
		
		//Base Condition
		if( W==0 ||	n==0 )
			return 0;
		if( dp[n][W] != -1 )
			return dp[n][W];
		//choice diagram
		if( w[n-1] <= W ) {
			return dp[n][W] = Math.max(v[n-1] + knapsack(w, v, W-w[n-1], n-1), knapsack(w, v, W, n-1));
			}
		else
			return dp[n][W] = knapsack(w, v, W, n-1);
	}

}

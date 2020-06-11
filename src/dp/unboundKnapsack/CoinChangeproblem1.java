package dp.unboundKnapsack;

import java.util.Arrays;

// number of ways amount can we paid == unbound Knapsack
public class CoinChangeproblem1 {
	static int t[][] = new int[5001][5001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {2};
		int amount = 3;
		System.out.println(change(amount, coins));
	}
	public static int change(int amount, int[] coins) {
		for (int i[] : t) {
			Arrays.fill(i, 0);
		}
		return knapsack(coins,amount,coins.length);
		 
        
    }
	public static int knapsack(int[] coins, int amount, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < amount+1; j++) {
				if(i==0)
					t[i][j] = 0;
				else if(j==0)
					t[i][j] = 1;
				else if(coins[i-1]<=j)
					t[i][j] =  t[i][j-coins[i-1]]+ t[i-1][j];
				else 
					t[i][j] = t[i-1][j];
			}
		}
		return t[n][amount];
	}
}

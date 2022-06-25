package section5.dp.unboundKnapsack;

import java.util.Arrays;

//minimum no. of coins required to pay the amount == unbound Knapsack
public class CoinChangeProblem {
	static int t[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {2};
		int amount = 3;
		t = new int[coins.length+1][amount+1];
		for (int temp[] : t) {
			Arrays.fill(temp, -1);
		}
		System.out.println(coinChange(coins,amount));

	}
	
	public static int coinChange(int[] coins, int amount) {
		return ubknapsack(coins,amount,coins.length);
		
        
    }
	private static int ubknapsack(int[] coins, int amount, int n) {
		//Base Condition
		if(amount == 0)
			return 0;
		if(n==1 && amount%coins[n-1] !=0)
			return -1;
		for (int i = 0; i < coins.length+1; i++) {
			for (int j = 0; j < amount+1; j++) {
				if(i==0)
					t[i][j] = Integer.MAX_VALUE-1;
				if(j==0)
					t[i][j] = 0;
			}
		}
		for (int i=1, j = 0; j < amount+1; j++) {
			if(j % coins[i-1] == 0)
				t[i][j] = j / coins[i-1];
			else
				t[i][j] = Integer.MAX_VALUE-1;
		}
		
		//Choice diagram
		for (int i = 2; i < coins.length+1; i++) {
			for (int j = 1; j < amount+1; j++) {
				if(coins[i-1]<=j) {
					t[i][j] = Math.min(1 + t[i][j-coins[i-1]] , t[i-1][j]);
				}
				else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][amount];

	}

}

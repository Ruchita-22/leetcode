package section5.dp.fabonacci;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arrays.fill(dp,-1);
		System.out.println(fib1(7));
	}
	
	//Basic
	// 0 1 1 2 3 5 8 13 21 
	// 0 1 2 3 4 5 6 7   8
	static int dp[] = new int[1000];
	private static int fib(int n) {
		if(n<2)
			return n;
		return fib(n-1)+fib(n-2);
	}
	
	private static int fib1(int n) {
		if(n<2)
			return n;
		if(dp[n]!=-1)
			return dp[n];
		
		return dp[n]=fib(n-1)+fib(n-2);
		
	}
	//70. Climbing Stairs
	//https://leetcode.com/problems/climbing-stairs/
	//static int dp[]=new int[46];
    public int climbStairs(int n) {
        Arrays.fill(dp,-1);
        return solve(n);
        
    }
    private static int solve(int n){
        if(n<=2)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = solve(n-1)+solve(n-2);
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] arr) {
        int n=arr.length,p=0;
        int sell[] = new int[n];
        sell[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
           sell[i] = Math.max(sell[i+1],arr[i]);
        }
        for(int i=0;i<n;i++){
            p = Math.max(p,sell[i]-arr[i]);
        }
        return p;
        
    }
    //122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] arr) {
        int n=arr.length,p=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i])
                p +=arr[i]-arr[i-1];
        }
        return p;
    }
    //123. Best Time to Buy and Sell Stock III
    public int maxProfit3(int[] prices) {
        return 0;
    }
	//Check if the number is Fibonacci
	//https://practice.geeksforgeeks.org/problems/check-if-the-number-is-fibonacci4654/1/?page=1&difficulty[]=-2&difficulty[]=-1&category[]=Fibonacci&sortBy=submissions
	private static String checkFibonacci(int n){
        // code here
        int t1=5*n*n-4,t2=5*n*n+4;
        int p1=(int)Math.sqrt(t1),p2=(int)Math.sqrt(t2);
        if(p1*p1==t1||p2*p2==t2)
            return "Yes";
        else
        return "No";
    }
	
	//Fibonacci to N 
	//https://practice.geeksforgeeks.org/problems/fibonacci-to-n0811/1/?page=1&difficulty[]=-1&category[]=Fibonacci&sortBy=submissions
	private static ArrayList <Integer> nFibonacci(int n){

        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        l.add(1);
        Integer t=1;
        int i=2;
        while(t<=n) {
            t= l.get(i-1)+l.get(i-2);
            if(t<=n)
                l.add(t);
            i++;    
        }
        return l;
    }

}

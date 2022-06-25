package section5.dp.longestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubstring {
	static int t[][] = new int[1001][1001];
	static int length = 0, row =0 , col=0;
	static String res = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "abcdefh";
		String Y = "abedfr";
		System.out.println(longestCommonSubstring(X,Y));
		//print(X,Y);
		
	}
	public static int longestCommonSubstring(String X, String Y) {
		
		for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
		return solve(X,Y, X.length(),Y.length(),0);
    }
	
	
	
	public static int lcs(String X, String Y, int m, int n) {
		//Base Condition
		if(m==0||n==0)
			return length = 0;
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
			}
		}

		// choice diagram
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(X.charAt(i-1) == Y.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
					length = length < t[i][j] ? Math.max(length, t[i][j]):length;
					
				}	
				else{
		    		t[i][j] = 0;
		    		length = Math.max(length, t[i][j]);
				}
			}
		}
		return length;
	}
public static int longestCommonSubstring1(String X, String Y) {
		
		for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
		return solve(X,Y, X.length(),Y.length(),0);
    }
	
	
	
	public static int lcs1(String X, String Y, int m, int n) {
		//Base Condition
		if(m==0||n==0)
			return length = 0;
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
			}
		}

		// choice diagram
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(X.charAt(i-1) == Y.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
					if(length < t[i][j] ) {
						length = Math.max(length, t[i][j]);
						row = i;
						col =j;
					}
					
				}	
				else{
		    		t[i][j] = 0;
		    		length = Math.max(length, t[i][j]);
				}
			}
		}
		return length;
	}
	
	public static void print(String X, String Y) {
		while (t[row][col]!=0) {
			res += X.charAt(row-1);
			length--;
			row--;
			col--;
		}
		// reverse the string
		String s = "";
		for (int i = res.length()-1; i >=0 ; i--) {
			s += res.charAt(i);
		}
		System.out.println(s);
	}
	
	//memorization version
		private static int solve(String str1, String str2,int i, int j, int count)
	    {
	 
	        if (i == 0 || j == 0)
	            return count;
	        else if (str1.charAt(i-1)== str2.charAt(j-1))
	        	count = solve(str1, str2,i - 1, j - 1, count + 1);
	        else {
		        int count1 = Math.max(solve(str1, str2,i, j - 1, 0),solve(str1, str2,i - 1, j, 0));
		        count = Math.max(count, count1);
	        }
	        return count;
	    }
		//https://leetcode.com/problems/maximum-length-of-repeated-subarray/
		
}

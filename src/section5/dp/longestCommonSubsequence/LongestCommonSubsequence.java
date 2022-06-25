package section5.dp.longestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {
	static int t[][] = new int[1001][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "abcdefh";
		String Y = "abedfhr";
		System.out.println(longestCommonSubsequence(X,Y));

	}
	public static int longestCommonSubsequence(String X, String Y) {
		for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
		return lcs(X,Y, X.length(),Y.length());
		
        
    }
	private static int lcs(String X, String Y, int m, int n) {
		//Base Condition
		if( m == 0 || n == 0 )
			return 0;
		//memorization
		if(t[m][n] != -1)
			return t[m][n];
		//choice diagram
		if(X.charAt(m-1)==Y.charAt(n-1))
			return t[m][n] = 1+lcs(X,Y,m-1,n-1);
		else {
			return t[m][n] = Math.max( lcs(X,Y,m-1,n), lcs(X,Y,m,n-1));
		}
	}
}

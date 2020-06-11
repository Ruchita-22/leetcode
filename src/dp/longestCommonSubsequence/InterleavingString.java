package longestCommonSubsequence;

import java.util.Arrays;
import java.util.Iterator;

public class InterleavingString {
	static int t[][] = new int[1001][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "a", s2 = "", s3 = "a";
		System.out.println(isInterleave(s1, s2, s3));
	}
	public static boolean isInterleave(String s1, String s2, String s3) {
		
		return isSubsequence(s1,s3) && isSubsequence(s2,s3);
    }
	
	private static boolean isSubsequence(String a, String b) {
		for (int[] is : t) {
			Arrays.fill(is, -1);
		}
		if(a==null && b!=null|| a.length() == 0 && b.length()!=0 )
			return false;
		else if(a==null && b==null || a.length()==0 && b.length()==0)
			return true;
		return lcs(a,b,a.length(),b.length());
	}
	
	private static boolean lcs(String a, String b, int m, int n) {
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i==0||j==0)
					t[i][j]=0;
				else {
					if(a.charAt(i-1)==b.charAt(j-1))
						t[i][j] = 1+t[i-1][j-1];
					else
						t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}	
			}
		}
		return a.length() == t[m][n] ? true : false;
	}
}

/*
 * Input:
""
""
"a"
Output:
true
Expected:
false

Input:
"a"
""
"a"
Output:
false
Expected:
true
*/

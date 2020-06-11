package dp.longestCommonSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	static int t[][] = new int[1001][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
	   System.out.println(longestPalindromeSubseq(s));
	}
	
	public static int longestPalindromeSubseq(String s) {
        
        //base condition
		if(s==null)
			return 0;
        if(isPalindrome(s))
            return s.length();
        for (int[] temp : t) {
			Arrays.fill(temp, -1);
		}
        //reverse string
        String s1 = "";
		for (int i = s.length()-1; i >=0 ; i--) {
			s1 += s.charAt(i);
		}
		return lcs(s,s1,s.length(),s1.length());
    }
    
    public static int lcs(String a, String b, int m, int n) {
		// TODO Auto-generated method stub
		//base condition
		if(m==0||n==0)
			return 0;
		if(t[m][n] != -1)
			return t[m][n];
		//recursive approach
		if(a.charAt(m-1) == b.charAt(n-1))
			return t[m][n] = 1 + lcs(a, b, m-1, n-1);
		else
			return t[m][n] = Math.max(lcs(a, b, m-1, n) , lcs(a, b, m, n-1));
		
	}
    
    public static boolean isPalindrome(String s) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			}
			else
				return false;
		}
		return true;
	}

}

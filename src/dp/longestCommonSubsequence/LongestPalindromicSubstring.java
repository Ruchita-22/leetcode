package longestCommonSubsequence;

import java.util.Arrays;

public class LongestPalindromicSubstring {
	static int t[][] = new int[1001][1001];
    static int length = 0, row =0 , col=0;
	static String res = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="cbbd";
		System.out.println(longestPalindrome(s));

	}
	 public static String longestPalindrome(String s) {
	        if(s.length()==0)
				return null;
			if(isPalindrome(s))
				return s;
	        else {
	            //initialize dp
	            for (int[] temp : t) {
				Arrays.fill(temp, -1);
			    }
	            //reverse the string
	            String rev = reverse(s);
			    return lcs(s,rev, s.length(),rev.length());
	        }
	            
	    }
	    public static String reverse(String s) {
	    	String temp = "";
            for (int i = s.length()-1; i >=0 ; i--) {
                temp += s.charAt(i);
            }
            return temp;
	    }
		public static String lcs(String X, String Y, int m, int n) {
			//Base Condition
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
	        
			return getSubString(X,Y);
		}
		public static String getSubString(String X, String Y) {
	        while (t[row][col]!=0) {
				res += X.charAt(row-1);
				length--;
				row--;
				col--;
			}
			// reverse the string
	        return reverse(res);
	    }    
	    
	    public static boolean isPalindrome(String s) {
			// Check whether string is palindrome or not 
			int i=0;
			int j=s.length()-1;
			while(i<j) {
				if(s.charAt(i)==s.charAt(j)) {
					i++;
					j--;
				}
				else {
					return false;
				}
			}
			return true;
		}
	}
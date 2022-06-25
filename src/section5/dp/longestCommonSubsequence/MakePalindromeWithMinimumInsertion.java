package section5.dp.longestCommonSubsequence;

public class MakePalindromeWithMinimumInsertion {
	static int t[][] = new int[1001][1001];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "mbadm";
		System.out.println(minInsertions(s));

	}
	public static int minInsertions(String s) {
		if(s==null||s.length()==0 || isPalindrom(s))
			return 0;
		else {
			String rev = reverse(s);
			System.out.println(rev);
			return s.length() - lcs(s,rev,s.length(),rev.length());
		}
			

    }
	private static int lcs(String a, String b, int m, int n) {
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
				else {
					if(a.charAt(i-1)==b.charAt(j-1)) {
						t[i][j] = 1+t[i-1][j-1];
					}
					else {
						t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
					}
					
				}
			}
			
		}
		return t[m][n];
	}
	public static String reverse(String s) {
		String temp = "";
		for (int i = s.length()-1; i >=0; i--) {
			temp += s.charAt(i);
		}
		return temp;
	}
	public static boolean isPalindrom(String s) {
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

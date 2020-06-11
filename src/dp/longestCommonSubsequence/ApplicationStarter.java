package longestCommonSubsequence;

public class ApplicationStarter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abad";
		System.out.println(countSubstrings(s));

	}
	public static int countSubstrings(String s) {
		//base condition
		if(s==null)
			return 0;
		//recursive approach
		int count = s.length();
		if(isPalindrome(s))
			count++;
		String s1 = "";
		for (int i = s.length()-1; i >=0 ; i--) {
			s1 += s.charAt(i);
		}
		count += lcs(s,s1,s.length(),s1.length());
		
		
		return count;
        
    }
	private static int lcs(String a, String b, int m, int n) {
		// TODO Auto-generated method stub
		//base condition
		if(m==0||n==0)
			return 0;
		//recursive approach
		if(a.charAt(m-1) == b.charAt(n-1))
			return 1 + lcs(a, b, m-1, n-1);
		else
			return lcs(a, b, m-1, n) + lcs(a, b, m, n-1);
		
		
	}
	private static boolean isPalindrome(String s) {
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

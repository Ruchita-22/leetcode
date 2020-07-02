package other;


import java.util.*;

public class PermutationSequence {
	public static List<Integer> fact = new ArrayList();
	public static List<Integer> digit = new ArrayList();
	static String ans = "";
	public static void main(String[] args) {
		int n = 4;
		int k = 14;
		System.out.println(permutute(n,k));
		
	}

	public static String permutute(int n, int k) {
		fact.add(1);
		int f = 1;
		for (int i = 1; i < n; i++) {
			f = f *i;
			fact.add(f);
		}
		for (int i = 1; i < n+1; i++) {
			digit.add(i);
		}
		permuteSequence(n,k);
		return ans;
	}

	private static String permuteSequence(int n, int k) {
		int index = k/fact.get(n-1);
		if(k%fact.get(n-1)==0)
			index -= 1;
		ans += digit.get(index).toString();
		digit.remove(index);
		k = k - fact.get(n-1)*index;
		permuteSequence(n-1, k);
		return ans;
	}
	
}

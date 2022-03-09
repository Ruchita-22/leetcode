package recursion;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//printNNaturalNumber(7);
		printPowerSet("ab","");

	}
	private static void printNNaturalNumber(int n) {
		// TODO Auto-generated method stub
		if(n==0)
			return;
		printNNaturalNumber(n-1);
		System.out.println(n);
	}
	
	private static void printPowerSet(String in,String op) {
		// TODO Auto-generated method stub
		if(in.length()==0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op2 = op2+ in.charAt(0);
		in.substring(1);
		printPowerSet(in.substring(1), op+in.charAt(0));
		printPowerSet(in.substring(1), op);
		return ;

	}
	
}

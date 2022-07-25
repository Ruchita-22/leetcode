package section4.recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printNNaturalNumber(7);
		String in = "ABC";
		String op = "";
		op = op + in.charAt(0);
		in = in.substring(1);

		// printNBitBinaryWhereOneIsGreaterThanZero("",0,0,5);

		System.out.println(generateGrammer(4, 3));

	}

	// IBH
	private static void printNNaturalNumber(int n) {
		// TODO Auto-generated method stub
		if (n == 0)
			return;
		printNNaturalNumber(n - 1);
		System.out.println(n);
	}

	// 509. Fibonacci Number
	private static int findAthFibonacci(int A) {
		if (A < 2)
			return A;
		return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
	}

	// Find Factorial!
	private static int fact(int n) {
		if (n < 2)
			return 1;
		return n * fact(n - 1);
	}

	// Print reverse string
	private static void reverse(String str, int n) {
		if (n == -1)
			return;
		System.out.print(str.charAt(n));
		reverse(str, n - 1);
	}

	// Check Palindrome
	private static int isPalin(String str, int s, int e) {
		if (s > e)
			return 1;
		else if (str.charAt(s) == str.charAt(e)) {

			return isPalin(str, s + 1, e - 1);
		} else
			return 0;
	}

	// Sum of Digits!
	private static int sumOfDigit(int n, int sum) {
		if (n < 1)
			return sum;
		sum = sum + (n % 10);
		return sumOfDigit(n / 10, sum);
	}

	// Is magic?
	private static int sum(int n) {
		while (n > 9) {
			n = sumDigit(n);
			System.out.println(n);
		}
		if (n == 1)
			return 1;
		else
			return 0;

	}

	private static int sumDigit(int n) {
		if (n < 10)
			return n;
		return n % 10 + sumDigit(n / 10);
	}

	// Implement Power Function
	public int pow(int a, int n, int m) {
		if (a == 0)
			return 0;
		if (n == 0)
			return 1;
		int pow = pow(a, n / 2, m);
		if (n % 2 == 0)
			return (int) ((((pow * 1L * pow) % m) + m) % m);
		else
			return (int) (((((pow * 1L * pow) % m * a % m) % m) + m) % m);
	}

	private static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		int h = Math.max(left, right) + 1;
		return h;
	}

	private static int[] sort(int arr[], int n) {
		// TODO Auto-generated method stub
		/*
		 * To Run int arr[] = new int[] {2,3,7,6,4,5,9}; print(arr); print(sort(arr,
		 * arr.length));
		 */
		if (n == 1)
			return arr;
		sort(arr, n - 1);
		for (int i = 0; i < n; i++) {
			if (arr[i] > arr[n - 1]) {
				int t = arr[i];
				arr[i] = arr[n - 1];
				arr[n - 1] = t;
			}
		}
		return arr;

	}
	// 779. K-th Symbol in Grammar
	private static int generateGrammer(int n, int k) {
		// base condition
		if (n == 1 && k == 1)
			return 0;
		int mid = (int) (Math.pow(2, n - 1) / 2);
		if (k <= mid)
			return generateGrammer(n - 1, k);
		else
			return generateGrammer(n - 1, k - mid) == 0 ? 1 : 0;
	}
	//89. Gray Code
    static List<Integer> list = new ArrayList<Integer>();

    public List<Integer> grayCode(int n) {
        list.clear();
        return solve(n);
    }    
    private static List<Integer> solve(int n){
        if(n==1){
            list.add(0);
            list.add(1);
            return list;
        }
        list = solve(n-1);

        int i = list.size()-1;
        while(i>=0){
            list.add( (list.get(i)) + (1<<(n-1)) );
            i--;
        }
        return list;
    } 

	/////////////////////////////////////////////////////////////////////////////////////////////
	// Input output method
	// Recursion tree
	private static void printPowerSet(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op2 = op2 + in.charAt(0);
		in = in.substring(1);
		printPowerSet(in, op2);
		printPowerSet(in, op1);
		return;
	}

	private static void permuteWithSpace(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op1 = op1 + " " + in.charAt(0);
		op2 = op2 + in.charAt(0);
		in = in.substring(1);
		permuteWithSpace(in, op2);
		permuteWithSpace(in, op1);
		return;
	}

	private static void permuteWithCaseChange(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		String op1 = op;
		String op2 = op;
		op1 = op1 + in.charAt(0);
		op2 = op2 + Character.toUpperCase(in.charAt(0));
		in = in.substring(1);
		permuteWithCaseChange(in, op2);
		permuteWithCaseChange(in, op1);
		return;
	}

	private static void letterChange(String in, String op) {
		// TODO Auto-generated method stub
		if (in.length() == 0) {
			System.out.println(op);
			return;
		}
		char ch = in.charAt(0);
		if (Character.isAlphabetic(ch)) {
			String op1 = op;
			String op2 = op;
			op1 = op1 + Character.toLowerCase(ch);
			op2 = op2 + Character.toUpperCase(ch);
			in = in.substring(1);
			letterChange(in, op1);
			letterChange(in, op2);
			return;

		} else {
			String op1 = op;
			op1 = op1 + ch;
			in = in.substring(1);
			letterChange(in, op1);
			return;

		}
	}

	private static void printNBitBinaryWhereOneIsGreaterThanZero(String op, int one, int zero, int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			System.out.println(op);
			return;
		}
		printNBitBinaryWhereOneIsGreaterThanZero(op + "1", one + 1, zero, n - 1);
		if (one > zero) {
			printNBitBinaryWhereOneIsGreaterThanZero(op + "0", one, zero + 1, n - 1);
		}
		return;
	}

	/////////////////////////////////////////////////////////////////////////////////////
	private static void solve(int n, int k) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			l.add(i);
		}
		k--;
		josephus(l, k, 0);
	}

	private static void josephus(List<Integer> l, int k, int s) {
		// TODO Auto-generated method stub
		if (l.size() == 1) {
			System.out.println(l.get(0));
			return;
		}
		s = (s + k) % l.size();
		l.remove(s);
		josephus(l, k, s);

	}

	///////////////// Helper Function////////////////////
	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}

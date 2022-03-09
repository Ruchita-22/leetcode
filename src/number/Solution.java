package number;

import java.util.Iterator;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));

	}
	private static int sumOfDigits(int num) {
		int sum=0;
		while(num>0) {
			sum = sum+num%10;
			num=num/10;
		}
		return sum;
	}
	private static int reverse(int num) {
		int res=0;
		while(num>0) {
			res = (res*10)+(num%10);
			num = num/10;
		}
		return res;
	}
	private static boolean armstrong(int num) {
		return sumOfDigits(num)==num? true: false;
	}
	private static int absoluteNumber(int num) {
		return num>0? num: (-num);

	}
	private static boolean prime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i==0)
				return false;
			
		}
		return true;
	}
	private static int factorial(int num) {
		if(num==0)
			return 0;
		if(num==1)
			return 1;
		return num*factorial(num-1);

	}
	
	private static int gcd(int a, int b) {
		while(a!=b) {
			if(a>b)
				a -=b;
			else
				b -=a;
		}
		return b;
	}

}

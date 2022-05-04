package number;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(allFactors(6));
		print(allFactors(6));

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
	
	private static int prime(int n) {
		if(n==0||n==1)
            return 0;
        for(int i=2;i<n/2;i++){
            if(n%i==0) {
                return 0;
            }    
        }
        return 1;
			
		
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
	private static int gcdRecursion(int a, int b) {
		if(b==0)
			return a;
		return gcdRecursion(b,a%b);
	}
	
	
	private static int[] allFactors(int num) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=1;i<=num;i++){
        	if(num%i==0)
        		res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
        
       
    }
	
	static int ans =0;
	private static int middle(int a, int b, int c){
        //code here
        
        if(a<b){
            if(b<c)	ans=b;
            else    middle(a,c,b);
        }
        else if(a>b){
            if(a<c) ans=a;
            else 	middle(b,c,a);
        }
        return ans;    
    }
	
	
	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
	}

}

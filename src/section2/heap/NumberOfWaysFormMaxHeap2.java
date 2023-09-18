package section2.heap;

import java.util.Arrays;

public class NumberOfWaysFormMaxHeap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {15, 15, 35, 48, 49, 66 };
		
		//solve(arr);
		System.out.println(solve(arr));
		//System.out.println(getLeftNode(6));

	}
	
	static int ncr[][] = new int[1002][1002];	//for nck
	static int nrm[] = new int[1002];	//nonRepeating Memoization
	static int rm[] = new int[1002];	//Repeating Memoization
	
	private static int solve(int arr[]) {
		
		for(int i=0;i<1001;i++) {
			Arrays.fill(ncr[i], -1);
		}
		Arrays.fill(rm, -1);
		Arrays.fill(nrm, -1);
		
		//check max is repeating or min is repeating
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for(int e : arr) {
			max = Math.max(max,e);
			min = Math.min(min, e);
		}
		int maxCount=0, minCount=0;
		for(int e : arr) {
			if(e==max)  maxCount++;
			if(e==min)	minCount++;
		}
		//call fn accordingly
		if(maxCount==2)	return nonRepeating(arr.length);
		else	return repeating(arr.length);
		//return 0;
	}
	private static int nonRepeating(int n) {
		//System.out.println("n="+n);
		if(n==0) return 0;
		if(n==1 || n==2) return 1;
		if(nrm[n]!= -1)	return nrm[n];
		
		int l=getLeftNode(n);
		int r=n-l-1;
		int case1 = mul(ncr(n-1,l),mul(nonRepeating(l),nonRepeating(r)));
		nrm[n] = case1;
		return nrm[n];
	}
	
	private static int repeating(int n) {
		if(n==0) return 0;
		if(n<4) return 1;
		if(n==4)	return 2;
		if(n==5)	return 4;
        if(rm[n]!= -1)	return rm[n];
        
		int l = getLeftNode(n);
		int r = n-l-1;
		
		int case1 = mul(ncr(n-3,l-2),mul(repeating(l),nonRepeating(r)));
		int case2 = mul(ncr(n-3,l-1),mul(nonRepeating(l),nonRepeating(r)));
		int case3 = mul(ncr(n-3,l),mul(nonRepeating(l),repeating(r)));
		int ans = add(case1,add(case2,case3));
		rm[n] = ans;
		return rm[n];
	}
	private static int getLeftNode(int n) {
		// TODO Auto-generated method stub
		int h = (int)(Math.log(n)/Math.log(2)); //height
		int maxNodeAtLastLevelCanBe = 1<<h;     //node at last level
		int maxNodeToPreviousLevel = (1<<h)-1; // total node except the last level
		int p = n-maxNodeToPreviousLevel; //node at last
		int maxNodeAtLastLevelPresent = p;
		int m = maxNodeAtLastLevelCanBe;
		if(p>=m/2)	return (1<<h)-1;	//left sub tree is CBT with 1 height less than whole tree
		else return ((1<<h)-1)-(m/2 - p) ;
		
	}
	
	private static int ncr(int n, int r) {
		// TODO Auto-generated method stub
		if(n<r || r<0)	return 0;
		if(r==0||n<=1)	return 1;
		if(n-r<r)	r=n-r;
		if(ncr[n][r]!=-1)	return ncr[n][r];
		ncr[n][r] = add(ncr(n-1,r-1),ncr(n-1,r));
		return ncr[n][r];
	}
	
	
	
	
	////////////////Helper/////////////////////
	public static int add(int a, int b) {
        int mod = (int) (1e9+7);
		return (int) (((a % mod) * 1L + (b % mod) + mod) % mod);
	}
    public static int sub(int a, int b) {
        int mod = (int) (1e9+7);
		return (int) (((a % mod) * 1L - (b % mod) + mod) % mod);
	}

    public static int mul(int a, int b) {
        int mod = (int) (1e9+7);
		return (int) (((a % mod) * 1L * (b % mod) + mod) % mod);
	}

}

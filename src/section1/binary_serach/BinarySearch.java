package section1.binary_serach;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    private static int searchInsert(int[] arr, int target) {
        int l=0,r=arr.length-1;
        int ans=-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(arr[m]==target){
                return m;
            }   
            else if(arr[m]<target)  {
                ans=m;
                l=m+1;
            }  
            else if(arr[m]>target) {
                r=m-1;
            }
        }
        return ans+1;
    }
    private static int peakElement(int[] arr) {
        int n=arr.length;
        //Edge Cases
        if(n==1)    return arr[0];
        if(arr[0]>arr[1])   return arr[0];
        if(arr[n-1]>arr[n-2])   return arr[n-1];

        int l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;

            if((arr[m-1])<=arr[m] && arr[m]>=arr[m+1])	return arr[m];
            else if(arr[m-1]>arr[m] && arr[m]>arr[m+1])	r=m-1;
            else	l=m+1;        
        }
        return -1;

    }
 
    //Q1. Square Root of Integer
    private static int sqrt(int n) {
        long l=1,r=n;
        long ans=0;
        while(l<=r){
            long m = l+(r-l)/2;
            if(m*m==n)  
                return (int) m;
            else if(m*m<n) {
                ans = m;
                l=m+1;
            } 
            else    r=m-1;
        }
        return (int) ans;
    }
    //Q4. Ath Magical Number
    private static int athMagicalNumber(int k1, int a1, int b1) {
        long k=k1,a=a1,b=b1;
        long l = Math.min(a,b);
        long r = k * Math.min(a,b);
        long lcm = lcm(a,b);
        long ans = 0;
        while(l<=r){
            long m = l+(r-l)/2;

            long count = (m/a)+ (m/b) -(m/lcm);

            if(count==k){
                ans = m;
                r=m-1;
            }
            else if(count<k)    l=m+1;
            else                r=m-1;
        }
        int mod =(int)(1e9+7);
        return (int) (ans%mod);
    }
    private static long lcm(long a,long b){
        return (a*b)/gcd(a,b);
    }
    private static long gcd (long a, long b){
        if(b==0)    return a;

        return gcd(b,a%b);
    }
 
    
	//Brute Force Approach
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        List<Integer> res = merge(a,b);
        int n = res.size();
        if(n%2==1)
            return res.get(n/2);
        else
            return ((res.get(n/2) * 1D) + (1D *res.get((n-1)/2)))/2;   
	}
    private static List<Integer> merge(List<Integer> a, List<Integer> b){
        int i=0, j=0,k=0;
        List<Integer> res= new ArrayList<>();
        while(i<a.size() && j<b.size()){
            if(a.get(i)<=b.get(j)){
                res.add(k,a.get(i));
                i++; k++;
            }
            else if(a.get(i)>b.get(j)){
                res.add(k,b.get(j));
                j++; k++;
            }
        }
        while(i<a.size()){
            res.add(k,a.get(i));
            i++; k++;
        }
        while(j<b.size()){
            res.add(k,b.get(j));
            j++; k++;
        }
        return res;
    }
}

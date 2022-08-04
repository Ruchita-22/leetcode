package section0d.array;

import java.util.ArrayList;

public class Kadane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//53. Maximum Subarray
	//https://leetcode.com/problems/maximum-subarray/
	public int maxSubArray(final int[] arr) {
		int sum = 0, ans = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			ans = Math.max(ans, sum);
			if (sum < 0) {
				sum = 0;
			}
		}
		return ans;
	}
	
	//152. Maximum Product Subarray
	//https://leetcode.com/problems/maximum-product-subarray/
    public int maxProduct(int[] arr) {
        int product = 1, ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            product = product*arr[i];
            ans = Math.max(ans,product);
            if(product==0)
                product=1;
        }
        product=1;
        for(int i=arr.length-1;i>=0;i--){
            product = product*arr[i];
            ans = Math.max(ans,product);
            if(product==0)
                product=1;
        }
        
        return ans;
        
    }
	public int maxSubArray1(final int[] arr) {
		int l=0,r=0,lmax=-1,rmax=-1;
		int sum = 0, ans = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(ans<sum){
				ans=sum;
				r=i;
                lmax=l;
                rmax=r;
			}		
            if(sum<0){
                sum=0;
				l=i+1;
				r=i+1;
			}	
		}
		System.out.println(lmax+" "+rmax+" "+(rmax-lmax+1));
		return ans;
	}
    //Q3. Flip
    //https://www.scaler.com/academy/mentee-dashboard/class/32052/homework/problems/329?navref=cl_tt_lst_nm
    public int[] flip(String str) {
        int l=0,r=0,lmax=-1,rmax=-1;
        int sum=0,ans = Integer.MIN_VALUE;
        int arr[] = new int[str.length()];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='0')
                arr[i] = 1;
            else 
                arr[i] = -1;    

        }
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
			if(ans<sum){
				ans=sum;
				r=i;
                lmax=l;
                rmax=r;
			}		
            if(sum<0){
                sum=0;
				l=i+1;
				r=i+1;
			}	
        }
        if(lmax==0 && rmax==0){
            if(str.charAt(0)=='1')
                return new int[0];
        }
        return new int[]{lmax+1,rmax+1};
        
       
    }
    //Q2. Max Non Negative SubArray
    //https://www.scaler.com/academy/mentee-dashboard/class/32052/homework/problems/266?navref=cl_tt_nv
    public int[] maxset(int[] arr) {
        int i=0,j=0;
        int s=0,e=0;
        long sum=0,maxSum=Integer.MIN_VALUE;

        while(j<arr.length){
            if(arr[j]>=0){
                sum += arr[j];
                j++;
            }
            else {
                if(maxSum<sum){
                    maxSum = sum;
                    s=i;
                    e=j; 
                }
                sum=0;
                j++;
                i=j;
            }
        }
        if(maxSum<sum){
            maxSum = sum;
            s=i;          
            e=j;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int k=s;k<e;k++){
            list.add(arr[k]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();

    }

}

package section0d.array.prefixSum;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//1480. Running Sum of 1d Array
    public int[] runningSum(int[] arr) {
        int n=arr.length;
        int ps[]=new int[n];
        ps[0]=arr[0];
        for(int i=1;i<n;i++)
            ps[i]=ps[i-1]+arr[i];
        return ps;
        
    }
	//1732. Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int pf[] = new int[gain.length+1];
        pf[0] =0;
        for(int i=0;i<gain.length;i++){
            pf[i+1] = pf[i]+gain[i]; 
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<pf.length;i++){
            max = Math.max(max,pf[i]);
        }
        return max;
        
    }	
	//1991. Find the Middle Index in Array
    public int findMiddleIndex(int[] nums) {
        int pf[] = pfConstruct(nums);
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int ls=0,rs=0;
            if(i==0){
                ls=0;
                rs=pf[n-1] - pf[i];    
            }
            else if(i==n-1){
                ls=pf[i-1];
                rs=0;
            }
            else {
                ls=pf[i-1];
                rs = pf[n-1]-pf[i];
            }
            if(ls==rs){
                return i;
            }
        }
        return -1;
        
    }
    private static int[] pfConstruct(int arr[]){
        int pf[] = new int[arr.length];
        pf[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            pf[i] = pf[i-1]+arr[i];
        }
        return pf;
    }	
    //1685. Sum of Absolute Differences in a Sorted Array
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int pf[] = pfConstruct(nums);
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            int left = (i)*nums[i]-pf[i];
            int right = pf[pf.length-1] - pf[i+1]-(n-1-i)*nums[i];
            res[i] = left+right;
            
            
        }
        return res;
        
    }
    //238. Product of Array Except Self
    public int[] productExceptSelf(int[] arr) {
        int n=arr.length;
        int l[] = pfLeftCompute(arr,n);
        int r[] = pfRightCompute(arr,n);
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            if(i==0)
                 res[i] =  r[i+1];
            else if(i==n-1)
                 res[i] = l[i-1];
            else    
                res[i] = l[i-1]*r[i+1];
        } 
        return res;
    }
    private static int[] pfLeftCompute(int arr[],int n){
        int left[] = new int[n]; 
        left[0] = arr[0];
        for(int i=1;i<n;i++){
            left[i] = left[i-1]*arr[i];
        }
        return left;
    }
    private static int[] pfRightCompute(int arr[], int n){
        int right[] = new int[n]; 
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1]*arr[i];
        }
        return right;
    }
	//1829. Maximum XOR for Each Query
    private static int[] pfxor(int arr[]){
        int pf[]  = new int[arr.length];
        pf[0] = arr[0];
        for(int i=1;i<arr.length;i++){
            pf[i] = pf[i-1]^arr[i];
        }
        return pf;
    }
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int pf[] = pfxor(nums);
        int k = (1<<maximumBit)-1;
        int n = nums.length;
        int ans[] = new int[n];
        for(int i=0;i<nums.length;i++){
            ans[i] = pf[n-1-i]^k;
        }
        return ans;
    }
	//1310. XOR Queries of a Subarray
    public int[] xorQueries(int[] arr, int[][] queries) {
        int pf[] = pfxor(arr);
        int res[] = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(l==0)
                res[i] = pf[r];
            else        
                res[i] = pf[r]^pf[l-1];
        }
        return res;
    }
}

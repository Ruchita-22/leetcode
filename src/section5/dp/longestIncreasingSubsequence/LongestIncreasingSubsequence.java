package section5.dp.longestIncreasingSubsequence;

import java.util.Arrays;

//674. Longest Continuous Increasing Subsequence
//300. Longest Increasing Subsequence
//1027. Longest Arithmetic Subsequence
//1048. Longest String Chain
//491. Increasing Subsequences
//300. Longest Increasing Subsequence

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[] {1,3,5,4,7};
		System.out.println(findNumberOfLIS(arr));
		
		
		
	}
	
	//674. Longest Continuous Increasing Subsequence
    public int findLengthOfLCIS(int[] arr) {
        int c=1,max=0;
          for(int i=1;i<arr.length;i++ ){
              if(arr[i]>arr[i-1]){
                  c++;
              }
              else {
                  max = Math.max(max,c);
                  c=1;
              }
          }
          max = Math.max(max,c);
          return max;
          
      }
      
	//673. Number of Longest Increasing Subsequence
    static int dp[][] = new int[2001][2001];
    private static int findNumberOfLIS(int[] arr) {
        for(int temp[]: dp) {
			Arrays.fill(temp, -1);
		}
        return lis(arr,0,-1);
    }
    
	// i=current
	//j = prev
    private static int lis(int arr[],int i,int j) {
		
		if(i == arr.length)
			return 0;
		
		if(dp[i][j+1] != -1)
			return dp[i][j+1];
		
		int len = 0 + lis(arr,i+1,j);
		if(j==-1 || arr[i]>arr[j]) 
			len = Math.max(len, 1+lis(arr,i+1,i));
		
		return dp[i][j+1] = len;	
		
	}
    //another approach
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
                max=Math.max(max,dp[i]);
        }
        return max;
    }
    
    static int count=0;
    private static int findNumberOfLIS1(int[] arr) {
        for(int temp[]: dp) {
			Arrays.fill(temp, -1);
		}
        int l = lis(arr,0,-1);
        print(dp,arr.length+1,arr.length+2);
        System.out.println("=========================");
        for(int i=0;i<arr.length;i++){
            for(int j=0; j<arr.length+1;j++){
                if(dp[i][j]==l)
                    count++;
            }
        }
        return count;
    }
    private static void print(int arr[][],int n,int m ) {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			System.out.print(arr[i][j]+"||");
    		}
    		System.out.println();
    	}
    }

	//////////////////////////////////////////////////////////////////
	//Tabulation 
	private static int lis1(int arr[]) {
		
		for(int j= arr.length-1;j>=0;j--) {
			for (int i = j-1; i >=-1; i--) {
				int len = 0+dp[j+1][i+1];
				if(i==-1 || arr[j]>arr[i]) 
					len = Math.max(len, 1+dp[j+1][i+1]);
				dp[j+1][i+1] = len;
			}
		}
		
		
		return dp[0][-1+1];	
		
	}
	private static int lis2(int arr[]) {
		int t[] = new int[arr.length];
		Arrays.fill(t, 1);
		int max=1;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i])
					t[i] = Math.max(t[i], 1+t[j]);
				
			}
			max = Math.max(max, t[i]);
		}
		
		
		return max;
		
	}
	

}

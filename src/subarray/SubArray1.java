package subarray;

import java.util.*;

public class SubArray1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,7,2,5};
		

	}
	//Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
	int subArraySum(int arr[], int n, int sum) { 
		//Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
		//Ouptut: Sum found between indexes 2 and 4
		
        int curr_sum = arr[0], start = 0, i; 
        for (i = 1; i <= n; i++) { 
            while (curr_sum > sum && start < i - 1) { 
                curr_sum = curr_sum - arr[start]; 
                start++; 
            } 
            if (curr_sum == sum) { 
                int p = i - 1; 
                System.out.println( 
                    "Sum found between indexes " + start 
                    + " and " + p); 
                return 1; 
            } 
            if (i < n) 
                curr_sum = curr_sum + arr[i]; 
        } 
  
        System.out.println("No subarray found"); 
        return 0; 
    } 
	public int maxSubArray(int[] a) {
//		/[-2,1,-3,4,-1,2,1,-5,4] kadane's algo
        int max_so_far = a[0]; 
	    int curr_max = a[0]; 
	  
	    for (int i = 1; i < a.length; i++) 
	    { 
	        curr_max = Math.max(a[i], curr_max+a[i]); 
	        max_so_far = Math.max(max_so_far, curr_max); 
	    } 
	    return max_so_far; 
    }
	//Longest subarray in which all elements are greater than K
	static int longestSubarray(int a[], int n, int x) 
	{ 	//Input: a[] = {3, 4, 5, 6, 7, 2, 10, 11}, K = 5
		//Output: 2
	    int count = 0; 
	    int length = 0; 
	    for (int i = 0; i < n; i++) {
	        if (a[i] > x) { 
	            count += 1; 
	        } 
	        else { 
	            length = Math.max(length, count); 
	            count = 0; 
	        } 
	    } 
	    if (count>0) 
	        length = Math.max(length, count); 
	    return length; 
	} 
	public static int subarraysDivByK(int[] arr, int x) {
		//A = [4,5,0,-2,-3,1], K = 5
		Map<Integer,Integer> map =  new HashMap<>();
		map.put(0, 1);
		int current_sum = 0;
		int count = 0;
		
		
		for (int i = 0; i < arr.length; i++) {
			current_sum += arr[i];
			int key = current_sum % x;
			if(key < 0)
				key += x;
			if(map.containsKey(key)) {
				count += map.get(key);                //map.put(key, map.get(key)+1);
			}
			map.put(key, map.getOrDefault(key, 0)+1);
			
		}
		return count;
        
    }
	public List<Integer> largestDivisibleSubset(int[] arr) {
        int dp[] = new int[5001];
	     int max = 1;
	    List<Integer> list = new ArrayList<>();
   
       if(arr.length==0 || arr == null)
           return list;
       
		Arrays.sort(arr);
		Arrays.fill(dp, 1);
       
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if(arr[i]%arr[j]==0 && 1+dp[j]>dp[i]) {
					dp[i] = 1+dp[j];
                   if(max<dp[i])
                       max = dp[i];
				}
			}
		}
		//Now push the listwer LIS
       int prev = -1;
       for(int i=arr.length-1;i>=0;i--)
       {
           if(dp[i]==max &&  (prev%arr[i]==0 || prev==-1))
           {
               list.add(arr[i]);
               max -=1;
               prev = arr[i];
           }
       }
       return list;
       
   }

}

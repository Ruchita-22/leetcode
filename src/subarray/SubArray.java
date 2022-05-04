package subarray;

import java.util.*;

public class SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		System.out.println(subsets(arr));

	}
	public static int sumOfAllTheSubArray(int arr[]) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i] * (n-i) * (i+1);
		}
		return sum;
	}
	//https://www.geeksforgeeks.org/sum-products-possible-subsets/
	public static int productOfSubsetSums(int arr[]) { 
        int ans = 1; 
        for (int i = 0; i < arr.length; ++i ) 
            ans = ans * (arr[i] + 1); 
        return ans-1; 
    } 
	/*
	find the sum of contiguous subarray which has the largest sum. = kadane's algo
	{-2, -3, 4, -1, -2, 1, 5, -3}
	max Sum(SubArray)
	*/
	public static int maxSubArraySum(int arr[]) {
		int msf = 0;
		int meh = 0;
		for (int i = 0; i < arr.length; i++) {
			meh = Math.max(meh+arr[i], arr[i]);
			msf = Math.max(msf, meh);
		}
		return msf;
		
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
	//Backtracking is used in below question
	//78. Subsets
	//Given a set of distinct integers, nums, return all possible subsets (the power set).
	//static List<List<Integer>> result = new ArrayList<>();  //better to pass this array in function
	//https://www.youtube.com/watch?v=taIvqOIT3cM&t=108s
	public static List<List<Integer>> subsets(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr==null||arr.length==0)
			return result;

		List<Integer> subset = new ArrayList<>();
		findAllSubset(arr, result, subset,0);
		return result; 
    }
	 
	public static void findAllSubset(int[] arr,List<List<Integer>> result, List<Integer> subset, int startIndex) {
		if(startIndex==arr.length) {
			result.add(new ArrayList<>(subset));
			return;
		}
	   
		   subset.add(arr[startIndex]);
		   findAllSubset(arr, result, subset, startIndex+1);
		   subset.remove(subset.size()-1);
		   findAllSubset(arr,result, subset, startIndex+1);
	   
	}
	//90. Subsets II
	public static List<List<Integer>> subsetsWithDup(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr==null||arr.length==0)
			return result;
		Arrays.sort(arr);
		List<Integer> subset = new ArrayList<>();
		findAllSubset1(arr, result, subset,0);
		return result; 
    }
	
	public static void findAllSubset1(int[] arr,List<List<Integer>> result, List<Integer> subset, int startIndex) {
		if(startIndex==arr.length) {
			result.add(new ArrayList<>(subset));
			return;
		}
		subset.add(arr[startIndex]);
		findAllSubset1(arr, result, subset, startIndex+1);
		subset.remove(subset.size()-1);
		while (startIndex+1 < arr.length && arr[startIndex+1] == arr[startIndex]) {
			startIndex++;
		}
		findAllSubset1(arr,result, subset, startIndex+1);
	   
	}
	
	//46. Permutations
	//https://leetcode.com/problems/permutations/
	//Given a collection of distinct integers, return all possible permutations
	static List<List<Integer>> result = new ArrayList<>();
	public static List<List<Integer>> permute(int[] arr) {
		if(arr==null || arr.length==0)	return result;
		findAllPermutation(arr, new ArrayList<Integer>(), new boolean[arr.length]);
        return result;
    }
	public static void findAllPermutation(int[] arr, List<Integer> subset, boolean visited[]) {
		if(subset.size() == arr.length) {
			result.add(new ArrayList<Integer>(subset));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				subset.add(arr[i]);
				visited[i] = true;;
				findAllPermutation(arr, subset, visited);
				subset.remove(subset.size()-1);
				visited[i] = false;
			}
			else
				continue;
		}
			
     
    }
	//47. Permutations II
	public static List<List<Integer>> permuteUnique(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
		if(arr == null || arr.length==0)	return result;
        Arrays.sort(arr);
		findAllPermutation(arr, result, new ArrayList<Integer>(), new boolean[arr.length]);
        return result;
    }
	public static void findAllPermutation(int[] arr, List<List<Integer>> result, List<Integer> subset, boolean visited[]) {
		if(subset.size() == arr.length) {
			result.add(new ArrayList<Integer>(subset));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            if(i>0 && arr[i]==arr[i-1] && !visited[i-1]) continue;
			if(!visited[i]) {
				subset.add(arr[i]);
				visited[i] = true;;
				findAllPermutation(arr, result, subset, visited);
				subset.remove(subset.size()-1);
				visited[i] = false;
			}
		}
    }
	
	// Prints sums of all  = https://www.geeksforgeeks.org/print-sums-subsets-given-set/
    // subsets of arr[l..r] 
	//subsetSums(arr, 0, 0)
    static void subsetSums(int []arr, int s, int sum ) { 
        if (s > arr.length-1) 
        { 
            System.out.print(sum + " "); 
            return; 
        } 
        // Subset including arr[l] 
        subsetSums(arr, s + 1, sum + arr[s]); 
      
        // Subset excluding arr[l] 
        subsetSums(arr, s + 1, sum); 
    } 
    
}

package subarray;


import java.util.*;

public class Sum {

	public static void main(String[] args) {
		int arr[] = {4, 5, 0, -2, -3, 1};
		int k = 5;
		System.out.println(subCount(arr, k));
		//calcSum(arr, k);

	}
	///////////////////////count/////////////////////////////////////
	/*Smallest subarray whose sum is multiple of array size
		Given an array of size N, we need to find smallest sized subarray whose sum is divisible by array size N.
		
		Examples :
		
		Input  : arr[] = [1, 1, 2, 2, 4, 2]    
		Output : [2 4]
		Size of array, N = 6    
		Following subarrays have sum as multiple of N
		[1, 1, 2, 2], [2, 4], [1, 1, 2, 2, 4, 2]
		The smallest among all is [2 4]
	 * 
	 * */
	public static void printSubarrayMultipleOfN(int arr[],  int k) {
		int current_sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			current_sum += arr[i];
			int key = current_sum % k;
			//not completed
		}
	}
	
	/*Count all sub-arrays having sum divisible by k
	You are given an array of positive and/or negative integers and a value K . The task is to find count of all sub-arrays whose sum is divisible by K?

	Examples :

	Input  : arr[] = {4, 5, 0, -2, -3, 1}, 
	         K = 5
	Output : 7
	// there are 7 sub-arrays whose is divisible by K
	// {4, 5, 0, -2, -3, 1}
	// {5}
	// {5, 0}
	// {5, 0, -2, -3}
	// {0}
	// {0, -2, -3}
	// {-2, -3}
	*/
	
	public static int subCount(int arr[], int k) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		// Map<Remainder,Frequency>
		map.put(0, 1);
		int current_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			current_sum += arr[i];
			int key = current_sum % k;
			if(map.containsKey(key)) {
				ans += map.get(key); 
				map.put(key, map.get(key)+1);
			}
			else
				map.put(key, map.getOrDefault(key, 0)+1);
		}
		return ans; 
    }
    
	////////////////////////////find length////////////////////////////////////////////////////////////
	/*Smallest subarray such that all elements are greater than K
	Given an array of N integers and a number K, the task is to find the length of the smallest subarray in which all the elements are greater than K. If there is no such subarray possible, then print -1.

	Examples:

	Input: a[] = {3, 4, 5, 6, 7, 2, 10, 11}, K = 5
	Output: 1
	The subarray is {10}

	Input: a[] = {1, 2, 3}, K = 13
	Output: -1
	
	//min length in this case is either 0 or 1
	*/
	public static int smallestSubarray(int arr[], int k) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > k) {
				return 1;
			}
		}
		return -1;
	}
	/*Longest subarray in which all elements are greater than K
	Given an array of N integers and a number K, the task is to find the length of the longest subarray in which all the elements are greater than K.
	Input: a[] = {3, 4, 5, 6, 7, 2, 10, 11}, K = 5
	Output: 2
	There are two possible longest subarrays of length 2.
	They are {6, 7} and {10, 11}.

	Input: a[] = {8, 25, 10, 19, 19, 18, 20, 11, 18}, K = 13
	Output: 4
	The longest subarray is {19, 19, 18, 20}.
	max length(Subarray each element > k)
	*/
	public static int longestSubarray(int arr[], int k) {
		int length = 0;
		int count = 0;
		int end = 0;
		while(end < arr.length) {
			if(arr[end++] > k) {
				count++;
			}
			else {
				length = Math.max(length, count);
				count = 0;
			}	
		}
		return length;
	}
	//sliding window wala 
	/*Sum of all subarrays of size K
	Given an array arr[] and an integer K, the task is to calculate the sum of all subarrays of size K.
	nput: arr[] = {1, 2, 3, 4, 5, 6}, K = 3
	Output: 6 9 12 15
	*/
	static void calcSum(int arr[], int k) {
		int start = 0;
		int end = 0;
		int temp = k;
		int current_sum = 0;
		while(temp>0) {
			current_sum += arr[end++];
			temp--;
		}
		System.out.print(current_sum);
		while(end<arr.length) {
			current_sum = current_sum - arr[start++] + arr[end++];
			System.out.print(" "+current_sum);
		}
	}
	//////////////////////////////////////////////////////////
	
	/*Smallest subarray with sum greater than a given value
	Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
	arr[] = {1, 4, 45, 6, 0, 19}
	   x  =  51
	Output: 3
	All positive number
	min length(Sum(SubArray) > x)
	*/
	public static int smallestSubWithSum(int arr[], int sum) {
		int min_length = arr.length;
		int start = 0;
		int end = 0;
		int current_sum = 0;
		while(end<arr.length) {
			if(current_sum < sum) {
				current_sum += arr[end++];
			}
			else if(current_sum > sum && start < end) {
				min_length = Math.min(min_length, end-start);
				current_sum -= arr[start++];
			}
			else
				break;
		}
		return min_length;
		
	}
	
	
	/*Given an array of n elements and an integer k. The task is to find the count of subarray which has maximum element greater than K.
	https://www.geeksforgeeks.org/count-subarrays-whose-maximum-element-greater-k/
	Input : arr[] = {1, 2, 3} and k = 2.
	Output : 3
	*/
	public static int countSubarray(int arr[], int k) {
		int n = arr.length;
		Arrays.sort(arr);
		int i=0;
		while(arr[i]<k)
			i++;
		int x =i+1;
		int count = n*(n+1)/2 - x * (x+1)/2;
		return count;
		
	}
	
	
	/*
	Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
	https://www.geeksforgeeks.org/find-subarray-with-given-sum/
	Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
	Ouptut: Sum found between indexes 2 and 4
	*/
	public static int subArraySum(int arr[], int sum) {
		//This is nave approach O(n2)
		// for positive number
//		for (int i = 0; i < arr.length; i++) {
//			int current_sum = arr[i];
//			for (int j = i+1; j < arr.length; j++) {
//				if(current_sum < sum)
//					current_sum += arr[j];
//				else if(current_sum == sum) {
//					System.out.println("Sum found between indexes "+ i +" "+ (j-1));  
//					return 0;
//				}		
//			}
//		}
//		System.out.println("No such index found");  
//		return 0;
//		
		//sliding window O(n) for positive number
//		int current_sum = 0;
//		for (int start = 0, end = 0; end < arr.length;) {
//			
//			while(current_sum < sum) {
//				current_sum +=arr[end];
//				end++;
//			}
//			while(current_sum > sum && start < end) {
//				current_sum -= arr[start];
//				start++;
//			}
//			if(current_sum == sum) {
//				System.out.println("Sum found between indexes "+ start +" and "+ (end-1));  
//				return 0;
//			}
//		}
//		System.out.println("No such index found");  
//		return 0;
		
		//for negative number https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
		//arr[] = {10, 2, -2, -20, 10}, sum = -10
		Map<Integer, Integer> map = new HashMap<>();
		int current_sum = 0;
		for (int i = 0; i < arr.length; i++) {
			current_sum += arr[i];
			if(current_sum == sum) {
				System.out.println("Sum found between indexes 0 and "+ i);
				return 0;
			}
			if(map.containsKey(current_sum-sum)) {
				System.out.println("Sum found between indexes "+ (map.get(current_sum - sum)+1) + " and " +i);
			}
			else
				map.put(current_sum, i);
		}
		return current_sum;
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

}

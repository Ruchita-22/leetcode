package binary_serach;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {10,9,8,7,6,5,4,3,2};
		int arr1[] = new int[] {1,1,2,4,5,5,5,5,7,8};
		int arr2[] = new int[] {4,5,6,7,1,2,3};
		int key = 5;
		System.out.println(numberOfTimesRotated(arr2));

	}
	private static int binarySearch(int arr[], int x) {
		//Increasing sorted Array
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			
			int mid = start+(end-start)/2;
			
			if(x<arr[mid])
				end=mid-1;
			else if(x>arr[mid])
				start = mid+1;
			else
				return mid;
					
		}
		return -1;
	}
	private static int binarySearch1(int arr[], int x) {
		//Decreasing sorted Array
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			
			int mid = start+(end-start)/2;
			
			if(x<arr[mid])
				start = mid+1;
			else if(x>arr[mid])
				end=mid-1;
			else
				return mid;
					
		}
		return -1;
	}
	private static int agnosticBinarySearch(int arr[], int x) {
		//sorted Array not known ascending or decending
		if(arr[0]<arr[1])
			return binarySearch(arr, x);
		else if(arr[0]>arr[1])
			return binarySearch1(arr, x);
		else 
			return -1;
	}
	private static int firstOccuranceOfKeyInSortedArray(int arr[], int x) {
		// first occurance of key in increasing sorted array
		int res = -1;
		int start = 0;
		int end = arr.length -1; 
		while(start <=end ) {
			int mid =  start + (end - start )/2;
			if(x<arr[mid])
				end=mid-1;
			else if(x>arr[mid])
				start = mid+1;
			else {
				res=mid;
				end = mid-1;
			}
					
		}
		return res;			
	}
	private static int lastOccuranceOfKeyInSortedArray(int arr[], int x) {
		// first occurance of key in increasing sorted array
		int res = -1;
		int start = 0;
		int end = arr.length -1; 
		while(start <=end ) {
			int mid =  start + (end - start )/2;
			if(x<arr[mid])
				end=mid-1;
			else if(x>arr[mid])
				start = mid+1;
			else {
				res=mid;
				start = mid+1;
			}
					
		}
		return res;			
	}
	private static int countNumberOfElementInSortedArray(int arr[], int x) {
		// TODO Auto-generated method stub
		int firstOccurance = firstOccuranceOfKeyInSortedArray(arr, x);
		int lastOccurance = lastOccuranceOfKeyInSortedArray(arr, x);
		return lastOccurance-firstOccurance+1;

	}
	private static int numberOfTimesRotated(int arr[]) {
		int start=0;
		int end = arr.length-1;
		int n=arr.length-1;
		int mid=0;
		while(start<=end) {
			mid = start + (end-start)/2;
			int next = (mid+1)%n;
			int prev = (mid+n-1)%n;
			if(arr[mid]<=arr[prev] && arr[mid]<=arr[next])
				return mid;
			if(arr[start]<=arr[mid])
				start = mid+1;
			else if(arr[end]>= arr[mid])
				end = mid-1;
			
			
		}
			
		return mid;
		
		

	}

}

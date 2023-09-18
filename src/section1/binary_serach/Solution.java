package section1.binary_serach;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {1,2,3,4,8,10,10,12,19};
		int arr1[] = new int[] {1,1,2,4,5,5,5,5,7,8};
		int arr2[] = new int[] {4,5,6,7,1,2,3};
		int key = 5;
		System.out.println(ceilElementInSortedArray(arr,5));

	}
	private static int binarySearchAsc(int arr[], int x) {
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
	private static int binarySearchDesc(int arr[], int x) {
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
			return binarySearchAsc(arr, x);
		else if(arr[0]>arr[1])
			return binarySearchDesc(arr, x);
		else 
			return -1;
	}
	private static int firstOccuranceOfKeyInSortedArray(int arr[], int x) {
		// first occurance of key in increasing sorted array
		int res = -1;		//index
		int start = 0;
		int end = arr.length -1; 
		while(start <=end ) {
			int mid =  start + (end - start )/2;
			if(x==arr[mid]) {
				res=mid;
				end = mid-1;
			}
			else if(x<arr[mid])
				end=mid-1;
			else if(x>arr[mid])
				start = mid+1;
		
					
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
			
			if(x==arr[mid]) {
				res=mid;
				start = mid+1;
			}
			else if(x<arr[mid])
				end=mid-1;
			else if(x>arr[mid])
				start = mid+1;
				
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
	private static int floorElementInSortedArray(int arr[], int key) {
		int start = 0, end=arr.length-1;
		int res=-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key)
				return arr[mid];
			else if(arr[mid]<key) {
				res=arr[mid];
				start= mid+1;
			}
			else if(arr[mid]>key)
				end= mid-1;
		}
		return res;
	}
	private static int ceilElementInSortedArray(int arr[], int key) {
		int start = 0, end=arr.length-1;
		int res=-1;
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(arr[mid]==key)
				return arr[mid];
			else if(arr[mid]<key) {
				start= mid+1;
			}
			else if(arr[mid]>key)
				res=arr[mid];
				end= mid-1;
		}
		return res;
	}
	private static char nextLetter(char arr[],int key) {
		
		return 0;
		

	}
    public int findPeakElement(int[] arr) {
        
        if(arr.length==1)
            return 0;
      
      
        int n = arr.length-1;
        int s = 0 , e = arr.length-1;
        
        while(s<=e){
            int m = s+(e-s)/2;
            
            if(m==0){
                if(arr[m]>arr[m+1])
                    return m;
                else 
                    return m+1;
               
            }
            else if(m==arr.length-1){
                if(arr[m]>arr[arr.length-2])
                    return m;
                else
                    return m-1;
               
                
            }
            else {
                if(arr[m]>arr[m-1] && arr[m] > arr[m+1])
                    return m;
                else if(arr[m] < arr[m-1])
                    e = m-1;
                else if(arr[m] < arr[m+1])
                    s = m+1;
                
            }
        }
        return -1;
        
        
    }
}

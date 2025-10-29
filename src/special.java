import java.util.Arrays;

public class special {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//2134. Minimum Swaps to Group All 1's Together II
	public int minSwaps(int[] arr) {
        int k = 0;      // window size
        for(int e : arr) {
            if(e == 1) k++;
        }
        int res[] = new int[2*arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[i];
            res[i+arr.length] = arr[i];
        }
        int minZero = Integer.MAX_VALUE, currMinZero = 0;
        int i = 0, j = 0;
        for(j = 0; j < k ; j++) {
            if(res[j] == 0) currMinZero++;
        }
        minZero = Math.min(minZero, currMinZero);
        
        while(j < res.length) {
            if(res[j] == 0) currMinZero++;
            if(res[i] == 0) currMinZero--;
            i++; j++;
            minZero = Math.min(minZero, currMinZero);
        }
        return minZero;
      
    }
	// if no rotation no swap
	public int maxNoOfOnce(int[] arr) {
		
		int count = 0, maxOne = 0;
		int j = 0;
		while(j < arr.length) {
			if(arr[j] == 1)	count++;
			else {
				maxOne = Math.max(maxOne, count);
				count = 0;
			}
			j++;
		}
		return maxOne;
    }
	//Q1. Minimum Swaps
	//Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
	
	public int solve(int[] arr, int b) {
        int windowSize = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=b)
                windowSize++;
        }
        int i=0,j=0;
        int count = 0;
        int swap = Integer.MAX_VALUE;

        for(j = 0; j < windowSize; j++) {
            if(arr[j] > b)  count++;
        }
        swap = Math.min (swap, count);
        while(j < arr.length) {
            if(arr[j] > b) count++;
            if(arr[i] > b) count--;
            i++; j++;
            swap = Math.min (swap, count);
        }
        return swap==Integer.MAX_VALUE ? 0 : swap;
    }
	//1838. Frequency of the Most Frequent Element
	public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        
        int result = 0;
        
        int i = 0, j = 0;
        long currSum = 0;
		
        while( j < arr.length) {
            
            long windowSum = (j - i + 1) * 1L * arr[j];
            currSum += arr[j];
			long op = windowSum - currSum;
            
            while (op > k && i<j) {
                currSum -= arr[i];
                i++;
                windowSum = (j - i + 1) * 1L * arr[j];
				op = windowSum - currSum;
            }
            
            result = Math.max(result, j - i + 1);
			j++;
            
        }
        return result;
    }
	
	

}

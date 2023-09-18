package section1.binary_serach;

public class Special_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   //Q3. Special Integer
    public int solve(int[] arr, int sum) {
        long ans=0;
        long l=0,r=arr.length;
        while(l<=r){
            long m = l+(r-l)/2;
            if(checkSumOfSizeK(arr,sum,m)){
                ans=m;
                l=m+1;
            }
            else r=m-1;
        }
        return (int) ans;
    }
    private static boolean checkSumOfSizeK(int arr[],int targetSum, long k){
        //for first window
        long sum = 0;
        int i=0,j=0;
        for(j=0;j<k;j++){
            sum += arr[j];
        }
        if(sum>targetSum)   return false;

        while(j<arr.length){
            sum = sum + arr[j]-arr[i];
            if(sum>targetSum)   
                return false;
            i++; j++;    

        }
        return true;
        
    }

}

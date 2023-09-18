package section1.binary_serach;

public class Search_in_Bitonic_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int searchInBitonicArray(int[] arr, int target) {
        int n=arr.length;
        int por = findPeek(arr,n);
       
        int inc =  binarySearchInc(arr,0,por,target);
        int dec = binarySearchDec(arr,por+1,n-1,target); 
     
        if(inc==-1 && dec==-1)  return -1;
        else if(inc==-1)    return dec;
        else    return inc;
                
              
    }
    private static int findPeek(int arr[],int n){
        if(n==1)    return 0;
        if(arr[0]>arr[1])   return 0;
        int l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            
            if(arr[m-1]<arr[m] && arr[m]>arr[m+1])  return m;
            else if(arr[m]>arr[m-1]) l=m+1;
            else r=m-1;
        }
        return -1;
    }
    private static int binarySearchInc(int arr[],int start, int end, int target){
        int l=start,r=end;
        while(l<=r){
            int m=l+(r-l)/2;

            if(arr[m]==target)  return m;
            else if( arr[m] > target) r=m-1;
            else l=m+1;
        }
        return -1;
    }
    private static int binarySearchDec(int arr[],int start, int end, int target){
        int l=start,r=end;
        while(l<=r){
            int m=l+(r-l)/2;

            if(arr[m]==target)  return m;
            else if(arr[m]>target) l=m+1;
            else r=m-1;
        }
        return -1;
    }
    public int search(final int[] arr, int B) {
        int N = arr.length;
        int s = 0;
        int e = N-1;
        
        while(s<=e){
            int m = (s+e)/2;
            if (arr[m]==B){
                return m;
            }
			else if(arr[0]<arr[m]){
                if(arr[0]<=B && arr[m]>B){
                    e = m-1;
                }else{
                    s = m+1;
                }
            }
			else{
                if(arr[m]<=B && arr[N-1]>=B){
                    s = m+1;
                }else{
                    e = m-1;
                }
            }
        }
        return -1;
    }

}

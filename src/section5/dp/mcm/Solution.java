package section5.dp.mcm;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {10,20,30,40,50};
		mcm(arr,0,arr.length-1);
		
	}
	private static int solve(int arr[],int i,int j) {
		if(i>j)
			return 0;
		int ans=0;
		for (int k = i; k < j; k++) {
			int temp = solve(arr,i,k)+solve(arr,k,j);
			ans = Math.max(ans, temp);
		}
		return ans;
		
	}
	//MCM
	private static int mcm(int arr[],int i,int j) {
		if(i>=j)
			return 0;
		int ans=Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = mcm(arr,i,k)+mcm(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			ans = Math.max(ans, temp);
		}
		return ans;
		
	}
	//Palindrome Partition 
	private static int palindromPartition(String s,int i,int j) {
		if(i>j)
			return 0;
		int ans=0;
		for (int k = i; k < j; k++) {
			int[] arr = null;
			int temp = solve(arr,i,k)+solve(arr,k,j);
			ans = Math.max(ans, temp);
		}
		return ans;
		
	}

}

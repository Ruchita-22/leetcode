package section5.dp.longestCommonSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//It is a variation of LCS
public class LongestDivisibleSubArray {
	static int dp[] = new int[5001];
	static int max = 1;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,2,7};
		System.out.println(largestDivisibleSubset(arr));
	}
	public static List<Integer> largestDivisibleSubset(int[] arr) {
		if(arr.length==0 || arr == null)
            return list;
		Arrays.sort(arr);
		//convert array into list
//		List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
//		System.out.println(list1);
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

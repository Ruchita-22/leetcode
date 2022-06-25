package section5.dp.knapsack_0_1;

import java.util.Arrays;
import java.util.Scanner;

public class ApplicationStarter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int w[] = {1,2,3};
		int v[] = {4,5,1};
		int W = 4;
//		Scanner scanner = new Scanner(System.in);
//		int t = scanner.nextInt();
//		for (int i = 0; i < t; i++) {
//			int n = scanner.nextInt();
//			int W = scanner.nextInt();
//			int w[] = new int[n];
//			int v[] = new int[n];
//			for (int j = 0; j < n; j++) {
//				w[i] = scanner.nextInt();
//			}
//			for (int j = 0; j < n; j++) {
//				v[i] = scanner.nextInt();
//			}
//		}
		
		KnapsackApplication knapsackApplication = new KnapsackApplication();
		System.out.println(knapsackApplication.knapsack(w,v,W, w.length));

//		int arr[] = {1,4,5,7};
//		int sum = 7;
//		int diff = 4;
//		SubsetSum subsetSum = new SubsetSum(); 
//		SubsetSum1 subsetSum1 = new SubsetSum1(); 
////		System.out.println(subsetSum.subsetSum(arr,sum));
////		System.out.println(subsetSum.equalSumSubset(arr));
//		System.out.println(subsetSum1.countOfSubsetSum(arr, sum));
//		System.out.println(subsetSum.subsetDiff(arr, diff));

	}

	

}

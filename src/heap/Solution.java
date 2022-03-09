package heap;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solve();
		int arr[] = new int[] {6,5,3,2,8,10,9};
		print(arr);
		arr = heapSort(arr, 3);
		print(arr);
		
		//System.out.println(KthLargestElemet(arr, 3));

	}
	private static void solve() {
		// TODO Auto-generated method stub
		//Min Heap
		//insert it any where but remove the smallest element
		PriorityQueue<Integer> min = new PriorityQueue<>();
		
		//Max heap
		//insert it any where but remove the largest element
		PriorityQueue<Integer> max = new PriorityQueue<>(3,Collections.reverseOrder());
	}
	
	private static int KthSmallestElemet(int arr[],int k){
		//input= 7,10,4,3,20,15
		PriorityQueue<Integer> max = new PriorityQueue<>(arr.length,Collections.reverseOrder());
		
		for (int i = 0; i < arr.length; i++) {
			max.add(arr[i]);
			if(max.size()>k)
				max.poll();
		}
		return max.peek();
	}
	private static int KthLargestElemet(int arr[],int k){
		//input= 7,10,4,3,20,15
		PriorityQueue<Integer> max = new PriorityQueue<>(arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			max.add(arr[i]);
			if(max.size()>k)
				max.poll();
		}
		return max.peek();
	}
	private static int[] heapSort(int arr[],int k) {
		// TODO Auto-generated method stub
		////input= 6,5,3,2,8,10,9
		PriorityQueue<Integer> min = new PriorityQueue<>();
		int j=0;
		for (int i = 0; i < arr.length; i++) {
			min.add(arr[i]);
			if(min.size()>k) {
				arr[j]=min.poll();
				j++;
			}
		}
		return arr;
		

	}
	private static void print(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();

	}
}

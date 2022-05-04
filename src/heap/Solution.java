package heap;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solve();
		int arr[] = new int[] {1,2,3,4,5};
		int arr1[][]= {{1,2},{-2,-2},{5,8},{0,1}};
		
//		kClosedElement(arr,3,6);
//		kCloseestToOrigin(arr1);
//		solve1();
//		print(arr);
//		arr = heapSort(arr, 3);
//		print(arr);
		
		System.out.println(connectRopeWithMinCost(arr));

	}
	private static void solve() {
		// TODO Auto-generated method stub
		//Min Heap
		//insert it any where but remove the smallest element
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Pair> min1 = new PriorityQueue<>((o1,o2)->o1.getKey()-o2.getKey());
		
		//Max heap
		//insert it any where but remove the largest element
		PriorityQueue<Integer> max = new PriorityQueue<>(3,Collections.reverseOrder());
		PriorityQueue<Pair> max1 = new PriorityQueue<>((o1,o2)->o2.getKey()-o1.getKey());
	}
	private static void solve1() {
		// TODO Auto-generated method stub
		Pair a[] = {new Pair(1,1),new Pair(2,2), new Pair(3,3)};
		//PriorityQueue<Pair> min = new PriorityQueue<>(new MyComparator());
		PriorityQueue<Pair> min = new PriorityQueue<>((o1,o2)->o2.getKey()-o1.getKey());
		min.add(new Pair(1,1));
		min.add(new Pair(3,3));
		min.add(new Pair(2,2));
		while(min.size()>0)
		{
			System.out.println(min.poll().key);
		}
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
		while(!min.isEmpty()) {
			arr[j] = min.poll();
			j++;
		}
		return arr;
		

	}
	private static void kClosedElement(int arr[],int k,int n) {
		// TODO Auto-generated method stub
		PriorityQueue<Pair> pq = new PriorityQueue<Pair> (new MyComparator());
		for (int i = 0; i < arr.length; i++) {
			pq.add(new Pair((arr[i]-n), arr[i]));
			if(pq.size()>k)
				pq.poll();
		}
		while (pq.size()>0) {
			System.out.println(pq.peek().getValue());
			pq.poll();
		}
	}
	private static void kFrequentElement(int arr[],int k) {
		// TODO Auto-generated method stub
		//input = 1,1,1,3,2,2,4    n=2
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i],0)+1);
		}
		System.out.println(map);
		//sort on value/ frequency
		Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
		for (int n1: map.keySet()) {
	          pq.add(n1);
	          if (pq.size() > k) 
	        	  pq.poll();    
	    }
		while(pq.size()>0) {
			System.out.println(pq.poll());
		}
	}
	private static void frequentSort(int arr[]) {
		// TODO Auto-generated method stub
		//input = 1,1,1,3,2,2,4
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i],0)+1);
		}
		System.out.println(map);
		Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
		for (int n1: map.keySet()) {
	          pq.add(n1);   
	    }
		while (!pq.isEmpty()) {
			System.out.print(pq.poll()+" ");
		}
	}
	
	
	private static void kCloseestToOrigin(int arr[][]) {
		// TODO Auto-generated method stub
		// input int arr1[][]= {{1,2},{-2,-2},{5,8},{0,1}};
		PriorityQueue<Pair1> pq = new PriorityQueue<>((o1,o2)->o2.getKey()-o1.getKey());
		for (int i = 0; i < arr.length; i++) {
			int x=arr[i][0],y=arr[i][1];
			int d = (x*x)+(y*y);
			pq.add(new Pair1(d,x,y));
			if(pq.size()>1)
				pq.poll();
		}
		System.out.println(pq.peek().getX()+" "+pq.peek().getY());
		
	}
	private static int connectRopeWithMinCost(int arr[]) {
		// TODO Auto-generated method stub
		//input 1,2,3,4,5
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}
		int t=0;
		while(pq.size()>1) {
			int sum = pq.poll()+pq.poll();
			t=t+sum;
			pq.add(sum);
		}
		return t;

	}
	private static void print(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();

	}
	private static int maxTripletSum(int arr[]) {
		// TODO Auto-generated method stub
		int k=3;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i:arr) {
			pq.add(i);
			if(pq.size()>3)
				pq.poll();
		}
		System.out.println(pq);
		int sum = 0;
		while(pq.size()>0) {
			sum = sum+pq.poll();
		}
		return sum;
	}
}

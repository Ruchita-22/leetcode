package section2.heap;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// solve();
		int arr[] = new int[] {1,2,3,4,5};
		System.out.println(KthLargestElemet(arr, 3));
		
//		int arr1[][]= {{1,2},{-2,-2},{5,8},{0,1}};
//		int workers[][] = new int[][] {{0,0},{2,1}}; 
//		int bikes[][] = new int[][] {{1,2},{3,3}};
//		print(assignBikes(workers, bikes));

//		int baseCosts[] = new int[] {2,3};
//		int toppingCosts[] = new int[] {4,5,100};
//		System.out.println(closestCost(baseCosts,toppingCosts,18));
	}


	
	private static int KthSmallestElemet(int arr[], int k) {
		// input= 7,10,4,3,20,15
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

		for (int i : arr) {
			pq.add(i);
			if (pq.size() > k)
				pq.poll();

		}
		return pq.peek();
	}

	private static int KthLargestElemet(int arr[], int k) {
		// input= 7,10,4,3,20,15
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
		for (int i : arr) {
			pq.add(i);
			if (pq.size() > k)
				pq.poll();

		}
		return pq.peek();
	}

	private static int kthSmallest(int[][] arr, int n, int k) {
		// code here.
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				pq.add(arr[i][j]);
				if (pq.size() > k)
					pq.poll();
			}
		}
		return pq.peek().intValue();

	}
	// no. in form of string
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(
            (o1,o2) -> o1.length() != o2.length() ? o1.length() - o2.length() : o1.compareTo(o2)
                    );
        for(String s : nums){
            pq.add(s);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
        
    }
	// K sorted array
	private static int[] heapSort(int arr[], int k) {
		// TODO Auto-generated method stub
		//// input= 6,5,3,2,8,10,9
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
			if (pq.size() > k) {
				arr[j] = pq.poll();
				j++;
			}
		}
		while (pq.size()>0) {
			arr[j] = pq.poll();
			j++;
		}
		return arr;

	}
	// k closed number to x
	static class Pair{
	    int x;		// diff
	    int y;		// element
	    public Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		
		PriorityQueue<Pair> q = new PriorityQueue<>((o1, o2) -> o1.x != o2.x ? o2.x - o1.x : o2.y - o1.y);
		for (int i = 0; i < arr.length; i++) {
			q.add(new Pair(Math.abs(arr[i] - x), arr[i]));
			while (q.size() > k)
				q.poll();
		}
		List<Integer> res = new ArrayList<Integer>();
		while (q.size() > 0) {
			res.add(q.poll().y);
		}
		Collections.sort(res);
		return res;
    }
	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
		Map<Integer, Integer> map = new HashMap<>();
		// e , diff

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> map.get(o1) != map.get(o1) ? map.get(o2) - map.get(o1) : o2 - o1);
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], Math.abs(arr[i] - x));
			q.add(arr[i]);
			while (q.size() > k)
				q.poll();
		}
		List<Integer> res = new ArrayList<Integer>();
		while (q.size() > 0) {
			res.add(q.poll());
		}
		Collections.sort(res);
		return res;
    }
	//////////////////////////////////////////////////////////////////
	private static void kFrequentElement(int arr[], int k) {
		// TODO Auto-generated method stub
		// input = 1,1,1,3,2,2,4 n=2
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int e : arr){
            map.put(e,map.getOrDefault(e,0)+1);
            
        }
		
		// sort on value/ frequency
		PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
		for (int n1 : map.keySet()) {
			pq.add(n1);
			if (pq.size() > k)
				pq.poll();
		}
		while (pq.size() > 0) {
			System.out.println(pq.poll());
		}
	}
	//1636. Sort Array by Increasing Frequency
    public int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e : arr){
            map.put(e,map.getOrDefault(e,0)+1);
            
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) ->  map.get(n1) != map.get(n2) ?                                            
                map.get(n1) - map.get(n2) : n2-n1);
		for (int n1 : map.keySet()) pq.add(n1);
		
		int i=0;
		while (pq.size() > 0) {
			int n = pq.poll();
			int f = map.get(n);
			while(f>0){
                arr[i] = n;
                i++;
                f--;
            }
			
		}

        return arr;
        
    }
    //451. Sort Characters By Frequency
    //https://leetcode.com/problems/sort-characters-by-frequency/
    public String frequencySort(String s) {
        //List<Integer> res =  new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
        
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        for(char c : map.keySet()){
            pq.add(c);
        }
        StringBuilder res = new StringBuilder();
        while(pq.size()>0){
            char c = pq.poll();
            int f = map.get(c);
            for(int i = 0;i<f;i++)
                res.append(c);
        }
        return new String(res);
        
        
    }    

	// 692. Top K Frequent Words
	private static List<String> topKFrequent(String[] words, int k) {
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>(k,
				(o1, o2) -> (int) map.get(o1) != map.get(o2) ? map.get(o2) - map.get(o1) : o1.compareTo(o2));

		for (String str : map.keySet()) {
			pq.add(str);
		}
		List<String> res = new ArrayList<>();

		while (k > 0) {
			res.add(pq.poll());
			k--;
		}

		return res;

	}
	
	static class Pair1 {
		int key,x,y;

		public Pair1(int key, int x, int y) {
			super();
			this.key = key;
			this.x = x;
			this.y = y;
		}
	}	
	private static void kCloseestToOrigin(int arr[][]) {
		// TODO Auto-generated method stub
		// input int arr1[][]= {{1,2},{-2,-2},{5,8},{0,1}};
		PriorityQueue<Pair1> pq = new PriorityQueue<>((o1, o2) -> o2.key - o1.key);
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i][0], y = arr[i][1];
			int d = (x * x) + (y * y);
			pq.add(new Pair1(d, x, y));
			if (pq.size() > 1)
				pq.poll();
		}
		System.out.println(pq.peek().x + " " + pq.peek().y);

	}

	private static int connectRopeWithMinCost(int arr[]) {
		// TODO Auto-generated method stub
		// input 1,2,3,4,5
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : arr) {
			pq.add(i);

		}
		int res = 0;
		while (pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			int sum = a+b;
			res = res + sum;
			pq.add(sum);
		}
		return res;

	}

	
	private static int maxTripletSum(int arr[]) {
		// TODO Auto-generated method stub
		int k = 3;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i : arr) {
			pq.add(i);
			if (pq.size() > 3)
				pq.poll();
		}
		System.out.println(pq);
		int sum = 0;
		while (pq.size() > 0) {
			sum = sum + pq.poll();
		}
		return sum;
	}
	
	// 373. Find K Pairs with Smallest Sums
	static class Pair2 {
		 int a,b,c;
	     public Pair2(int a, int b,int c) {
	         super();

	         this.a  = a;
	         this.b = b;
	         this.c = c;

		 }   
	}     
	private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		PriorityQueue<Pair2> pq = new PriorityQueue<>((o1, o2) -> o2.c - o1.c);

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {

				int a = nums1[i];
				int b = nums2[j];
				int c = a + b;

				pq.add(new Pair2(a, b, c));
				if (pq.size() > k)
					pq.poll();
			}
		}

		List<List<Integer>> res = new ArrayList<>();
		while (pq.size() > 0) {
			List<Integer> l = new ArrayList<>();
			l.add(pq.peek().a);
			l.add(pq.peek().b);
			res.add(l);
			pq.poll();
		}

		return res;
	}

	// https://goodtecher.com/leetcode-1057-campus-bikes/
	static class Pair3 {
		int wi,bi,d;
		public Pair3(int wi, int bi,int d) {
			super();
			
			this.wi = wi;
			this.bi = bi;
			this.d = d;
		}
	}	
	private static int[] assignBikes(int[][] workers, int[][] bikes) {

		if (workers.length == 0)
			return new int[0];

		ArrayList<Integer> l = new ArrayList<>(workers.length);

		for (int i = 0; i < workers.length; i++) {
			l.add(i, -1);
		}

		PriorityQueue<Pair3> pq = new PriorityQueue<>(
				(o1, o2) -> o1.d != o2.d ? o1.d - o2.d : o1.wi - o2.wi);

		for (int i = 0; i < workers.length; i++) {
			for (int j = 0; j < bikes.length; j++) {
				int d = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
				pq.add(new Pair3(i, j, d));
			}
		}

		while (pq.size() > 0) {
			Pair3 p = pq.poll();
			if (l.contains(p.bi) || l.get(p.wi) != -1)
				continue;
			else
				l.set(p.wi, p.bi);
		}
		return l.stream().mapToInt(Integer::intValue).toArray();
	}

	// Profit Maximisation
	// https://www.interviewbit.com/problems/profit-maximisation/
	private static int maxProfit(int[] arr, int b) {
		int n = arr.length;
		PriorityQueue<Integer> pq = new PriorityQueue(n, Collections.reverseOrder());
		for (int e : arr)
			pq.add(e);
		
		int p = 0;
		for (int i = b; i > 0; i--) {
			int t = pq.poll();
			p = p + t;
			t--;
			if (t != 0)
				pq.add(t);

		}
		return p;
	}

	// Merge K sorted arrays
	// https://www.interviewbit.com/problems/merge-k-sorted-arrays/
	public class Element {
		int data;
		int row;
		int col;
		
		public Element(int data, int row, int col) {
			super();
			this.data = data;
			this.row = row;
			this.col = col;
		}
	}	
	public int[] mergeKSortedArray(int[][] arr) {
		
		PriorityQueue<Element> pq = new PriorityQueue<>((o1, o2) -> o1.data - o2.data);
		
		for (int i = 0; i < arr.length; i++) {
			pq.add(new Element(arr[i][0], i, 0));
		}
		int res[] = new int[arr.length * arr[0].length];
		int i = 0;
		while (pq.size() > 0) {
			Element e = pq.poll();
			res[i] = e.data;
			i++;
			int r = e.row;
			int c = e.row;
			if(c+1 < arr[0].length)
				pq.add(new Element(arr[r][c + 1], r, c + 1));
		}
		return res;

	}
	//2233. Maximum Product After K Increments
	//https://leetcode.com/problems/maximum-product-after-k-increments/
	public int maximumProduct(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int e : arr) {
			pq.add(e);
		}
		while (k > 0 && pq.size() > 0) {
			int n = pq.poll();
			n++;
			k--;
			pq.add(n);
		}
		int ans = 1;
		while (pq.size() > 0) {
			ans = mul(ans, pq.poll());
		}
		return ans;

	}
	
	public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		int ans = 0;
		int d = Integer.MAX_VALUE, dmin = Integer.MAX_VALUE;
		
		for (int i = 0; i < baseCosts.length; i++) {
			int cost = 0;
			cost = cost + baseCosts[i];
			d = Math.abs(cost - target);

			if (d < dmin) {
				dmin = d;
				ans = cost;
			}
			for (int j = 0; j < toppingCosts.length - 2; j++) {
				int costWithTopping = cost;
				for (int k = j; k < j + 2; k++) {
					costWithTopping = costWithTopping + toppingCosts[k];
					d = Math.abs(costWithTopping - target);
					if (d < dmin) {
						dmin = d;
						ans = costWithTopping;
					}
				}
			}
		}
		return ans;

	}

	private static void solve() {
		// TODO Auto-generated method stub
		// Min Heap
		// insert it any where but remove the smallest element
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Pair> min1 = new PriorityQueue<>((o1, o2) -> o1.x - o2.x);

		// Max heap
		// insert it any where but remove the largest element
		PriorityQueue<Integer> max = new PriorityQueue<>(3, Collections.reverseOrder());
		PriorityQueue<Pair> max1 = new PriorityQueue<>((o1, o2) -> o2.x - o1.x );
	}

	private static void solve1() {
		// TODO Auto-generated method stub
		Pair a[] = { new Pair(1, 1), new Pair(2, 2), new Pair(3, 3) };
		// PriorityQueue<Pair> min = new PriorityQueue<>(new MyComparator());
		PriorityQueue<Pair> min = new PriorityQueue<>((o1, o2) -> o2.x - o1.x);
		min.add(new Pair(1, 1));
		min.add(new Pair(3, 3));
		min.add(new Pair(2, 2));
		while (min.size() > 0) {
			System.out.println(min.poll().x);
		}
	}
	
	//////////////////Helper Function///////////////////
	private static void print(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	private static int mul(int a, int b){
        int mod = (int)(1e9+7);
        return (int)(((a % mod)*1L*(b % mod)+ mod) % mod);
    }


}

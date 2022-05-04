package two_pointer;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(twoSum(new int[] {3,2,4},6));

	}
	
	private static int[] union(int a[],int b[]) {
		//Union of two sorted array
		/* run process
		 * print(union(new int[] {1,3,4,5,7}, new int[] {2,3,5,6}));
		 * */
		Set<Integer> s = new LinkedHashSet<>();
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]==b[j]) {
				s.add(a[i]);
				i++; j++;
			}
			else if(a[i]<b[j]) {
				s.add(a[i]);
				i++;
			}
			else if(a[i]>b[j]) {
				s.add(b[j]);
				j++;
			}
		}
		while(i<a.length) {
			s.add(a[i]);
			i++;
		}
		while(j<b.length) {
			s.add(b[j]);
			j++;
		}
		return s.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private static int[] intersection(int a[],int b[]) {
		//Intersection of two sorted array
		/* run process
		 * print(intersection(new int[] {1,3,4,5,7}, new int[] {2,3,5,6}));
		 * */
		Set<Integer> s = new LinkedHashSet<>();
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]==b[j]) {
				s.add(a[i]);
				i++; j++;
			}	
			else if(a[i]<b[j]) {
				i++;
			}
			else if(a[i]>b[j]) {
				j++;
			}
		}
		return s.stream().mapToInt(Integer::intValue).toArray();
	}
	
	private static List<Integer> intersectionOfArrays(int[][] n) {
		 int res[]=n[0];
	     Arrays.sort(res);
	     for(int i=1;i<n.length;i++) {
	    	 Arrays.sort(n[i]);
	         res = intersection(n[i],res);
	     }
	     return Arrays.stream(res).boxed().collect(Collectors.toList());
   }
	
	private static int countWords(String[] w1, String[] w2) {
		/* to run
		 System.out.println(countWords(new String[]{"leetcode","is","amazing","as","is"},new String[] {"amazing","leetcode","is"}));
	
		 * */
		Map<String,Integer> m1 = new LinkedHashMap();
		Map<String,Integer> m2 = new LinkedHashMap();
		for(String s:w1) {
			m1.put(s, m1.getOrDefault(s, 0)+1);
		}
		for(String s:w2) {
			m2.put(s, m2.getOrDefault(s, 0)+1);
		}
		System.out.println(m1);
		System.out.println(m2);
		int c=0;
		for(String s:m1.keySet()) {
			if(m2.containsKey(s)) {
				if(m1.get(s)==m2.get(s)&&m1.get(s)==1&&m2.get(s)==1)
					c++;
			}
		}
		
		return c;
        
    }
	public int maxOperations(int[] arr, int k) {
		//1679. Max Number of K-Sum Pairs
		//https://leetcode.com/problems/max-number-of-k-sum-pairs/
        Arrays.sort(arr);
        int s=0,e=arr.length-1;
        int count = 0;
        while(s<e){
            if(arr[s]+arr[e]<k)
                s++;
            else if(arr[s]+arr[e]>k)
                e--;
            else if(arr[s]+arr[e]==k){
                count++;
                s++; e--;
            }
        }
        return count;
        
    }
	public static int[] twoSum(int[] arr, int k) {
		//Not completed
		Map<Integer,Integer> m= new HashMap();
		for (int i = 0; i < arr.length; i++) {
			m.put(arr[i],i);
		}
		Arrays.sort(arr);
		int s=0,e=arr.length-1;
		int res[] = new int[2];
		while(s<=e) {
			if(arr[s]+arr[e]<k)
				s++;
			else if(arr[s]+arr[e]>k)
				e--;
			else if(arr[s]+arr[e]==k) {
				res[0] = m.get(arr[s]);
				res[1] =  m.get(arr[e]);
				return res;
			}
		}
		return res;
        
    }
	private static List<List<Integer>> threeSum(int[] arr) {
	        //not completed
	        Arrays.sort(arr);
	        int n=arr.length;
	         List<List<Integer>> r = new ArrayList<>();
	        
	        for(int i=0;i<n-2;i++){
	            int j=i+1,k=arr.length-1;
	            if(arr[i]+arr[j]+arr[k]==0){
	                List<Integer> l = new ArrayList<Integer>();
	                l.add(arr[i]);
	                l.add(arr[j]);
	                l.add(arr[k]);
	                r.add(l);
	                j++;  k--;
	            }
	            else if(arr[i]+arr[j]+arr[k]<0)
	                j++;
	            else if(arr[i]+arr[j]+arr[k]>0)
	                k--;
	        }
	        return r;
	        
	    }
	private static int maxArea(int[] arr) {
		//11. Container With Most Water
		//https://leetcode.com/problems/container-with-most-water/
		int s=0,e=arr.length-1;
		int area=0;
		while(s<e) {
			int h = Math.min(arr[s], arr[e]);
			int w = e-s;
			int a=h*w;
			area = Math.max(area, a);
			if(arr[s]<=arr[e])
				s++;
			else if(arr[s]>arr[e])
				e--;
		}
		return area;
        
    }
	private static int trap(int[] arr) {
		//0,1,0,2,1,0,1,3,2,1,2,1
		int n=arr.length;
		if(n<3)
			return 0;
        int lm = arr[0], rm = arr[n-1];
		int s = 0, e = n - 2;
	    int ans = 0;
	    
	    while (s <= e) {
	        if (lm < rm) {
	            ans += arr[s] >= lm ? 0 : lm - arr[s];
                lm = arr[s] > lm ? arr[s]:lm;
	            s++;
	        }
	        else {
	            ans += arr[e] >= rm ? 0 : rm - arr[e];
                rm = arr[e] >rm ? arr[e]:rm;
	            e--;
	        }
	    }
	    return ans;    
    }
	
	private static void print(int arr[]) {
		
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();

	}
	
	private static void print(String arr[]) {
		for (String i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	///////////////////////////////////////////////////////////////////////////
	// Slow and fast pointer 
	// slow s
	//fast f
	private static ListNode middleNode(ListNode head) {
	        
	        if(head==null||head.next==null)
	            return head;
	        ListNode s=head,f=head;
	        while(f!=null && f.next!=null && f.next.next!=null){
	            s=s.next;
	            f=f.next.next;
	        }
	        if(f.next==null)
	            return s;
	        else 
	            return s.next;
	        
	}
	private static ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        ListNode s=head,f=head,p=head;
        while(f!=null && f.next!=null && f.next.next!=null){
            p=s;
            s=s.next;
            f=f.next.next; 
        }
        if(f.next==null){
        }
        else {
            p=s;
            s=s.next;
        }
        p.next=s.next;
        s.next=null;
        return head;
        
        
    }
	private static boolean hasCycle(ListNode head) {

        if(head==null||head.next!=null)
            return false;
        
        ListNode s=head,f=head;
        while(f!=null && f.next!=null){
            s = s.next;
            f = f.next.next;
            if(s==f)
                return true;
        }
        
       return false;
    }
	public ListNode cycleFirst(ListNode head) {
        if(head==null||head.next==null)
            return null;
        ListNode s=head, f=head;
        while(f!=null && f.next!=null && f.next.next!=null) {
            s=s.next;
            f=f.next.next;
            if(s==f){
                s=head;
                while(s!=f){
                    s=s.next;
                    f=f.next;
                }
            return s;    
            }
        }
        
        return null;
            
        
        
    }
	
	private static ListNode detectCycleStart(ListNode head) {
        /*
         142. Linked List Cycle II
         https://leetcode.com/problems/linked-list-cycle-ii/
         * */
		if(head==null||head.next==null)
            return null;
		
        ListNode s=head, f=head;
        while(f!=null && f.next!=null && f.next.next!=null) {
            s=s.next;
            f=f.next.next;
            if(s==f){
                s=head;
                while(s!=f){
                    s=s.next;
                    f=f.next;
                }
            return s;    
            }
        }
        
        return null;
    }
}

package sliding_window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largestSubarrayOfSumOfK(new int[] {4,1,1,1,2,3,5},2));
		//System.out.println(longestSubStringWithUniqueCharacter("aabacbebebe"));

	}
	//Fixed window size
	private static int largestSubarrayOfSumOfK(int arr[],int k) {
		int i = 0, j=0,sum=0,res=0;
		while (j<arr.length) {
			//calculation
			sum = sum+arr[j];
			//untill window is achieve
			if ( (j-i+1)<k )   
				j++;
			//maintain window
			else if( (j-i+1)==k ) {
				res = Math.max(sum, res);
				sum = sum - arr[i];
				i++; j++;
			}
			
		}
		return res;

	}
	
	private static int countOccuranceOfAnagram(String s,String p) {
		Map<Character, Integer> map = new HashMap<>();
		char ch[] = p.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			map.putIfAbsent(ch[i], 0);
			map.put(ch[i], map.get(ch[i])+1);
		}
		int i=0,j=0;
		int k = p.length();
		while (j<s.length()) {
			
		}
		return 0;
		

	}
//	private static int[] maxOfAllSubArrayOfSizeK(int arr[],int k) {
//		int i=0;
//		int j=0;
//		int res[] = new int[5];
//		int tmp;
//		Queue<Integer> max=new Queue<>();
//		while(j<arr.length) {
//			tmp = Math.max(tmp, arr[j]);
//			max.add(arr[j]);
//			if((j-i+1)<k)
//				j++;
//			else if(j-i+1==k) {
//				res[t] = max.peek();
//				
//				
//				i++; j++;
//			}
//				
//			
//		}
//		return null;
//	}
	//Variabe Window Size
	private static int largestSubarrayOfSum(int arr[],int k) {
		int i=0,j=0;
		long sum=0;
		int res=0;
		while (j<arr.length) {
			sum = sum+arr[j];
			if(sum<k)
				j++;
			else if(sum==k){
				res = Math.max(j-i+1, res);
				j++;
			}
			else if(sum>k) {
				while(sum>k) {
					sum = sum - arr[i];
					i++;
				}
				j++;
			}
				
		}
		return res;
	}
	private static int longestSubStringWithKUniqueCharacter(String s, int k){
		int i=0,j=0;
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(j<s.length()) {
			//calculation
			map.putIfAbsent(s.charAt(j), 0);
			map.put(s.charAt(j), map.get(s.charAt(j))+1);
			//untill condtion reach
			if(map.size()<k)
				j++;
			//condition match compute candidate ans
			else if(map.size()==k) {
				res = Math.max(j-i+1, res);
				j++;
			}
			
			else if(map.size()>k) {
				while (map.size()>k) {
					map.put(s.charAt(i), map.get(s.charAt(i))-1);
					if(map.get(s.charAt(i))==0)
						map.remove(s.charAt(i));
					i++;
				}
				j++;
			}
			
			
		}
		return res;
	}
	private static int longestSubStringWithUniqueCharacter(String s){
		int i=0,j=0;
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		while(j<s.length()) {
			//calculation
			map.putIfAbsent(s.charAt(j), 0);
			map.put(s.charAt(j), map.get(s.charAt(j))+1);
			//untill condtion reach
//			if(map.size()<(j-i+1))
//				j++;
			//condition match compute cndidate ans
			if(map.size()==(j-i+1)) {
				res = Math.max(j-i+1, res);
				j++;
			}
			
			else if(map.size()<(j-i+1)) {
				while (map.size()<(j-i+1)) {
					map.remove(s.charAt(i));
					i++;
				}
				j++;
			}
		}
		return res;
	}
}

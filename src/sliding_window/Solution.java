package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(largestSubarrayOfSum(new int[] {4,1,1,1,2,3,5},5));
		System.out.println(longestSubStringWithUniqueCharacter("aabacbebebe"));

	}
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
			//condition match compute cndidate ans
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

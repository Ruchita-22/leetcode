package section4.sliding_window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class FixedSizeSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(largestSubarrayOfSumOfK(new int[] {4,1,1,1,2,3,5},2));
		// System.out.println(longestSubStringWithUniqueCharacter("aabacbebebe"));

	}

	// Fixed window size
	private static int largestSubarrayOfSumOfSizeK(int arr[], int k) {
		int i = 0, j = 0, sum = 0, res = 0;
		while (j < arr.length) {
			// calculation
			sum = sum + arr[j];
			// untill window is achieve
			if ((j - i + 1) < k)
				j++;
			// maintain window
			else if ((j - i + 1) == k) {
				res = Math.max(sum, res);
				sum = sum - arr[i];
				i++;
				j++;
			}

		}
		return res;

	}
	// TC = O(n)
	// SC = O(1)
	private static int largestSubarrayOfSumOfSizeK1(int arr[], int k) {
		int sum = 0, res = 0;
		
		// first window
		for (int i = 0; i < k; i++) {
			sum = sum + arr[i];
		}
		res = Math.max(sum, res);
		int i = 0, j=k;
		// slide window and calculate
		while(j<arr.length) {
			sum = sum - arr[i] + arr[j];
			res = Math.max(sum, res);
			i++; j++;
		}
		
		return res;

	}
	// TC = O(n)
	// SC = O(1)


	// 643. Maximum Average Subarray I
	public double findMaxAverage(int[] arr, int k) {
		int i = 0, j = 0, sum = 0, res = Integer.MIN_VALUE;
		while (j < arr.length) {
			sum = sum + arr[j];

			if ((j - i + 1) == k) {
				res = Math.max(res, sum);
				sum = sum - arr[i];
				i++;
			}
			j++;
		}
		return (double) res / k;

	}

	// Given an array of size N, find the subarray of size K with the least average.
	// Fixed Size Sliding Window
	public int solve(int[] arr, int k) {
		int i = 0, j = 0, n = arr.length, sum = 0, res = Integer.MAX_VALUE, index = 0;
		while (j < n) {
			sum += arr[j];
			if ((j - i + 1) < k) {
				j++;
			} else if ((j - i + 1) == k) {
				if (sum < res) {
					res = sum;
					index = i;
				}

				sum -= arr[i];
				i++;
				j++;
			}
		}
		return index;
	}

	// 567. Permutation in String
	// https://leetcode.com/problems/permutation-in-string/
	//// s1 = pattern , s2 = str
	public boolean checkInclusion(String s1, String s2) {
		if(s2.length() < s1.length())   return false;
        
        int fs1[] = new int[26];
        int fs2[] = new int[26];
        
        for(char c : s1.toCharArray())  fs1[c-'a']++;
        
        int k = s1.length();
        
        // first window
        for(int j = 0; j < k; j++){
            char cj = s2.charAt(j);
            fs2[cj - 'a']++;
        }
       
        
        if(Arrays.equals(fs1,fs2))  return true;
        
        int i = 0, j = k;
        
        // slide and check
        while(j < s2.length()){
            char ci = s2.charAt(i);
            char cj = s2.charAt(j);
            fs2[ci - 'a']--;
            fs2[cj - 'a']++;
            i++; j++;
            if(Arrays.equals(fs1,fs2)) return true;
            
        }
        return false;   
	}
	/* TC = O(n*26)
	 * SC = 2*26
	 * */

	// https://leetcode.com/problems/find-all-anagrams-in-a-string/
	// 438. Find All Anagrams in a String
	// s1 = string , s2 pattern
	public List<Integer> findAnagrams(String s1, String s2) {

		if(s1.length() < s2.length())   return new ArrayList();
        
        int fs1[] = new int[26];
        int fs2[] = new int[26];
        
        for(char c : s2.toCharArray())  fs2[c-'a']++;
        
        int k = s2.length();
        
        // first window
        for(int j = 0; j < k; j++){
            char cj = s1.charAt(j);
            fs1[cj - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        
        if(Arrays.equals(fs1,fs2))  list.add(0);
        
        int i = 0, j = k;
        
        // slide and check
        while(j < s1.length()){
            char ci = s1.charAt(i);
            char cj = s1.charAt(j);
            fs1[ci - 'a']--;
            fs1[cj - 'a']++;
            i++; j++;
            if(Arrays.equals(fs1,fs2))  list.add(i);
            
        }
        return list;   
	}
	//Q2. Permutations of A in B
	private static int countOccuranceOfAnagram(String str, String p) {
		if (str.length() < p.length())	return 0;

		int fp[] = new int[26];
		int fs[] = new int[26];
		for (char c : p.toCharArray()) {
			fp[c - 'a']++;
		}
		// before window hit or first window
		for (int i = 0; i < p.length(); i++) {
			char c = str.charAt(i);
			fs[c - 'a']++;
		}
		int s = 0, e = p.length(), count = 0;
		if (Arrays.equals(fp, fs))
			count++;
		// slide window and check
		while (e < str.length()) {
			fs[str.charAt(e) - 'a']++;
			fs[str.charAt(s) - 'a']--;
			s++;
			e++;
			if (Arrays.equals(fp, fs))
				count++;

		}
		return count;
	}

	// 974. Subarray Sums Divisible by K
	//https://leetcode.com/problems/subarray-sums-divisible-by-k/
	//https://www.youtube.com/watch?v=QM0klnvTQzk&t=318s
	public int subarraysDivByK(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		
		map.put(0, 1);
		int sum = 0;
		int count = 0;
		int j = 0;

		while (j < arr.length) {
			sum += arr[j];
			int key = sum % k;
			if (key < 0)	key += k;
			
			if (map.containsKey(key)) {
				count += map.get(key);
			}
			map.put(key, map.getOrDefault(key, 0) + 1);
			j++;

		}
		return count;

	}
	// 1876. Substrings of Size Three with Distinct Characters
	public int countGoodSubstrings(String s) {
		if (s == null || s.length() < 3)		return 0;
		int k = 3;
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<>(); // freq map

		// first window
		for (int j = 0; j < k; j++) {
			char cj = s.charAt(j);
			map.put(cj, map.getOrDefault(cj, 0) + 1);
		}
		if (map.size() == k)		count++;

		int i = 0, j = k;
		// slide and check
		while (j < s.length()) {

			char ci = s.charAt(i);
			char cj = s.charAt(j);

			map.put(ci, map.get(ci) - 1);
			if (map.get(ci) == 0)		map.remove(ci);
			map.put(cj, map.getOrDefault(cj, 0) + 1);

			i++;
			j++;
			if (map.size() == k)		count++;
		}
		return count;

	}
	 
	//239. Sliding Window Maximum
	//Max of all subarray of size k
	public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n = arr.length;
        int res[] = new int[n-k+1];

        Deque<Integer> q = new ArrayDeque<>();

		int  j = 0;
		//first window
		for (j = 0; j < k; j++) {
			while (q.size() > 0 && q.peekLast() < arr[j])
				q.pollLast();
			q.addLast(arr[j]);
		}
		int i = 0;
		j=k;
		// slide and check
		while (j < n) {
			res[i] = q.peekFirst();
			if (q.size() > 0 && q.peekFirst() == arr[i])
				q.pollFirst();
			while (q.size() > 0 && q.peekLast() < arr[j])
				q.pollLast();
			q.addLast(arr[j]);
			i++;
			j++;
		}
        res[i] = q.peekFirst();
        return res;
    }
	//1052. Grumpy Bookstore Owner
	public int maxSatisfied(int[] customers, int[] grumpy, int k) {
        int n = customers.length;
        int satified = 0;
        for(int i=0;i<n;i++){
            if(grumpy[i]==0)    satified += customers[i];
        }

        int i=0,j=0,sum=0, ans=0;
        //first window
        while(j<k) {
            if(grumpy[j]==1)    sum += customers[j];
            j++;
        } 
        ans = Math.max(sum,ans);
        // slide window
        while(j<n){
            if(grumpy[i]==1)    sum -= customers[i];
            if(grumpy[j]==1)    sum += customers[j];
            ans = Math.max(sum,ans);
            i++; j++;
        }
        return satified+ans;
    }
	//2799. Count Complete Subarrays in an Array
	public int countCompleteSubarrays(int[] arr) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int e : arr)    set.add(e);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int i = 0, j = 0, count = 0;
        
        while(j < arr.length){
            int ej = arr[j];
            map.put(ej, map.getOrDefault(ej, 0)+1);
            
            if(map.size() < set.size()) j++;
            
            else if(map.size() == set.size()){
                while(i <= j && map.size() == set.size()){
                    count += n-1-j+1;
                    int ei = arr[i];
                    map.put(ei, map.getOrDefault(ei, 0)-1);
                    if(map.get(ei) == 0)    map.remove(ei);
                    i++;
                }
                j++;   
            }
           // j = Math.max(i,j);
        }
        return count;
        
    }
	
	
}

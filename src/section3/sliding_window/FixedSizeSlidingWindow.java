package section3.sliding_window;

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
	public boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length())		return false;
		
		int fs1[] = new int[26];
		int fs2[] = new int[26];

		for (char c : s1.toCharArray()) {
			fs1[c - 'a']++;
		}
		int k = s1.length();
		for (int i = 0; i < k; i++) {
			char c = s2.charAt(i);
			fs2[c - 'a']++;
		}
		// first window
		if (Arrays.equals(fs1, fs2))		return true;
		
		int i = 0, j = k;
		while (j < s2.length()) {

			fs2[s2.charAt(j) - 'a']++;
			fs2[s2.charAt(i) - 'a']--;
			i++;
			j++;
			if (Arrays.equals(fs1, fs2))
				return true;

		}
		return false;
	}

	// https://leetcode.com/problems/find-all-anagrams-in-a-string/
	// 438. Find All Anagrams in a String
	public List<Integer> findAnagrams(String str, String p) {

		if (str.length() < p.length())
			return new ArrayList<>();

		int fp[] = new int[26];
		int fs[] = new int[26];
		for (char c : p.toCharArray()) {
			fp[c - 'a']++;
		}
		// before window hit or first window
		int k = p.length();
		for (int i = 0; i < k; i++) {
			char c = str.charAt(i);
			fs[c - 'a']++;
		}
		List<Integer> res = new ArrayList<>();
		int s = 0, e = k;
		if (Arrays.equals(fp, fs))
			res.add(s);
		while (e < str.length()) {
			fs[str.charAt(e) - 'a']++;
			fs[str.charAt(s) - 'a']--;
			s++;
			e++;
			if (Arrays.equals(fp, fs))
				res.add(s);
		}
		return res;
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
		int i = 0, j = 0, ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			char ch = s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (j - i + 1 < 3)
				j++;
			else if (j - i + 1 == 3) {
				if (map.size() == 3)
					ans++;
				char t = s.charAt(i);
				map.put(t, map.get(t) - 1);
				if (map.get(t) == 0)
					map.remove(t);
				i++;
				j++;

			}
		}
		return ans;

	}
	//239. Sliding Window Maximum
	//Max of all subarray of size k
	public int[] maxSlidingWindow(int[] arr, int k) {
        
        int n = arr.length;
        int res[] = new int[n-k+1];

        Deque<Integer> q = new ArrayDeque<>();

        int i=0,j=0;
        for(j=0;j<k;j++){
            while(q.size()>0 && q.peekLast()< arr[j])  q.pollLast();
            q.addLast(arr[j]);
        }
     
        while(j<n){
            res[i] = q.peekFirst();     
            if(q.size()>0 && q.peekFirst()==arr[i]) q.pollFirst();
            while(q.size()>0 && q.peekLast()<arr[j])   q.pollLast();
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
	
	
}

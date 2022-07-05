package section3.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(largestSubarrayOfSumOfK(new int[] {4,1,1,1,2,3,5},2));
		// System.out.println(longestSubStringWithUniqueCharacter("aabacbebebe"));

	}

	// Fixed window size
	private static int largestSubarrayOfSumOfK(int arr[], int k) {
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
		if (s2.length() < s1.length())
			return false;
		int fs1[] = new int[26];
		int fs2[] = new int[26];

		for (char c : s1.toCharArray()) {
			fs1[c - 'a']++;
		}
		for (int i = 0; i < s1.length(); i++) {
			char c = s2.charAt(i);
			fs2[c - 'a']++;
		}
		if (Arrays.equals(fs1, fs2))
			return true;
		int i = 0, j = s1.length();
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
		for (int i = 0; i < p.length(); i++) {
			char c = str.charAt(i);
			fs[c - 'a']++;
		}
		List<Integer> res = new ArrayList<>();
		int s = 0, e = p.length();
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

	private static int countOccuranceOfAnagram(String str, String p) {
		if (str.length() < p.length())
			return 0;

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
	public int subarraysDivByK(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int count = 0;
		int j = 0;

		while (j < arr.length) {
			sum += arr[j];
			int key = sum % k;
			if (key < 0)
				key += k;
			if (map.containsKey(key)) {
				count += map.get(key);
			}
			map.put(key, map.getOrDefault(key, 0) + 1);
			j++;

		}
		return count;

	}

	// Variabe Window Size
	private static int largestSubarrayOfSum(int arr[], int k) {
		int i = 0, j = 0;
		long sum = 0;
		int res = 0;
		while (j < arr.length) {
			sum = sum + arr[j];
			if (sum < k)
				j++;
			else if (sum == k) {
				res = Math.max(j - i + 1, res);
				j++;
			} else if (sum > k) {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
				}
				j++;
			}

		}
		return res;
	}

	private static int longestSubStringWithKUniqueCharacter(String s, int k) {
		int i = 0, j = 0;
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			// calculation
			map.putIfAbsent(s.charAt(j), 0);
			map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
			// untill condtion reach
			if (map.size() < k)
				j++;
			// condition match compute candidate ans
			else if (map.size() == k) {
				res = Math.max(j - i + 1, res);
				j++;
			}

			else if (map.size() > k) {
				while (map.size() > k) {
					map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
					if (map.get(s.charAt(i)) == 0)
						map.remove(s.charAt(i));
					i++;
				}
				j++;
			}

		}
		return res;
	}

	private static int longestSubStringWithUniqueCharacter(String s) {
		int i = 0, j = 0;
		int res = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (j < s.length()) {
			// calculation
			map.putIfAbsent(s.charAt(j), 0);
			map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
			// untill condtion reach
			// if(map.size()<(j-i+1))
			// j++;
			// condition match compute cndidate ans
			if (map.size() == (j - i + 1)) {
				res = Math.max(j - i + 1, res);
				j++;
			}

			else if (map.size() < (j - i + 1)) {
				while (map.size() < (j - i + 1)) {
					map.remove(s.charAt(i));
					i++;
				}
				j++;
			}
		}
		return res;
	}

	/*
	 * You are given an integer array C of size A. Now you need to find a subarray
	 * (contiguous elements) so that the sum of contiguous elements is maximum. But
	 * the sum must not exceed B.
	 */
	public int maxSubarray(int n, int k, int[] arr) {
		int i = 0, j = 0, sum = 0, res = 0;
		while (j < n) {
			sum = sum + arr[j];
			if (sum < k) {
				j++;
			} else if (sum == k) {
				return sum;
			} else if (sum > k) {
				while (sum > k) {
					sum = sum - arr[i];
					i++;
				}
				j++;
			}
			res = Math.max(res, sum);
		}
		return res;
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

	// 2269. Find the K-Beauty of a Number
	// System.out.println(divisorSubstrings(430043, 2));
	private static int divisorSubstrings(int n, int k) {

		String s = Integer.toString(n);
		int i = 0, j = 0, ans = 0;
		while (j < s.length()) {
			if (j - i + 1 < k)
				j++;
			else if (j - i + 1 == k) {
				String temp = s.substring(i, j + 1);
				int t = Integer.parseInt(temp);
				if (t != 0 && n % t == 0)
					ans++;
				i++;
				j++;
			}

		}

		return ans;
	}

	public static int characterReplacement(String s, int op) {
		int f[] = new int[26];
		int ans = 0;

		for (int k = 0; k < 26; k++) {

			char c = (char) ('A' + k);
			// Sliding Window

			int i = 0, j = 0;
			while (j < s.length()) {
				f[k] = Math.max(ans, j - i + 1);
				if (s.charAt(j) == c)
					j++;
				else if (s.charAt(j) != c) {
					op--;
					if (op == 0) {
						// f[k] = Math.max(ans, j-i+1);
						while (s.charAt(i) == c) {
							i++;
							op++;
						}
					}
					j++;
				}
			}
		}
		// To get the max length of all the element
		int max = 0;
		for (int i = 0; i < 26; i++) {
			max = Math.max(max, f[i]);
		}
		return max;
	}
}

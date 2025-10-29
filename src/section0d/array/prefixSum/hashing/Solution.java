package section0d.array.prefixSum.hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

	}

	/*
	 * currSum = sum till j prevSum = sum till i subArray sum is k = currSum -
	 * prevSum k = currSum - prevSum prevSum = currSum -k
	 */
	// 560. Subarray Sum Equals K
	public int subarraySum(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
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

	// 1590. Make Sum Divisible by P
	public int minSubarray(int[] nums, int p) {
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}
		int rem = (int) (sum % p);
		if (rem == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<>(); // currSumMod, idx
		map.put(0, -1);
		long currSum = 0;
		int ans = nums.length;

		for (int i = 0; i < nums.length; ++i) {
			currSum += nums[i];
			int currentMod = (int) (currSum % p);
			int key = (currentMod - rem + p) % p;

			if (map.containsKey(key)) {
				ans = Math.min(ans, i - map.get(key));
			}

			map.put(currentMod, i);
		}

		return ans == nums.length ? -1 : ans;
	}

	// 523. Continuous Subarray Sum
	public boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>(); // modulo, idx
		map.put(0, -1);

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int sumMod = sum % k;
			if (map.containsKey(sumMod)) {
				int len = i - map.get(sumMod);
				if (len >= 2)
					return true;
			} else {
				map.put(sumMod, i);
			}
			// System.out.println(map);
		}
		return false;

	}

	// 2845. Count of Interesting Subarrays
	public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
		int arr[] = new int[nums.size()];
		for (int i = 0; i < nums.size(); i++) {
			arr[i] = (nums.get(i) % mod == k) ? 1 : 0;
			System.out.println(arr[i]);
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		long count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			int sumMod = sum % mod;
			int key = (sumMod - k + mod) % mod;
			count += map.getOrDefault(key, 0);
			map.put(sumMod, map.getOrDefault(sumMod, 0) + 1);

		}
		return count;

	}

	// 1248. Count Number of Nice Subarrays
	public int numberOfSubarrays(int[] arr, int k) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				arr[i] = 0;
			else
				arr[i] = 1;
		}
		int c = countSubArrayWithSumK(arr, k);
		return c;
	}

	private static int countSubArrayWithSumK(int arr[], int k) {
		HashMap<Integer, Integer> map = new HashMap<>(); // sum freq
		map.put(0, 1);

		int sum = 0, count = 0;
		for (int e : arr) {
			sum += e;
			int removeSum = sum - k;
			if (map.containsKey(removeSum)) {
				count += map.get(removeSum);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	// 2588. Count the Number of Beautiful Subarrays
	// https://www.youtube.com/watch?v=8jx35mkivJ8
	public long beautifulSubarrays(int[] nums) {
		int pfXor[] = new int[nums.length];
		pfXor[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			pfXor[i] = pfXor[i - 1] ^ nums[i];
		}
		HashMap<Integer, Integer> map = new HashMap<>(); // pfXor, frequency
		long count = 0;
		map.put(0, 1);
		for (int i = 0; i < pfXor.length; i++) {
			if (map.containsKey(pfXor[i])) {
				count += map.get(pfXor[i]);
			}
			map.put(pfXor[i], map.getOrDefault(pfXor[i], 0) + 1);
		}
		return count;

	}

	// String
	// https://www.youtube.com/watch?v=1DdmbJj4xLE
	// 1915. Number of Wonderful Substrings
	public long wonderfulSubstrings(String word) {
		int currXor = 0;
		long count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (char ch : word.toCharArray()) {
			int charIdx = ch - 'a';
			currXor ^= 1 << charIdx;
			count += map.getOrDefault(currXor, 0);
			for (int i = 0; i < 10; i++) {
				count += map.getOrDefault(currXor ^ (1 << i), 0);
			}
			map.put(currXor, map.getOrDefault(currXor, 0) + 1);
		}
		return count;
	}

}

package section2a.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 1512. Number of Good Pairs
	private static int numIdenticalPairs(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int e : arr)
			map.put(e, map.getOrDefault(e, 0) + 1);

		int c = 0;
		for (Map.Entry e : map.entrySet()) {
			int v = (int) e.getValue();
			if (v > 1) {
				c = c + v * (v - 1) / 2;
			}
		}
		return c;
	}

	// 2006. Count Number of Pairs With Absolute Difference K
	private static int countKDifference(int[] nums, int k) {

		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		for (int val : nums) {
			freq.put(val, freq.getOrDefault(val, 0) + 1);
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int value = nums[i] + k;
			if (freq.containsKey(value))
				count += freq.get(value);
		}
		return count;

	}

	// 1748. Sum of Unique Elements
	private static int sumOfUnique(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int e : nums) {
			map.put(e, map.getOrDefault(e, 0) + 1);
		}
		int ans = 0;
		for (Map.Entry e : map.entrySet()) {
			int k = (int) e.getKey();
			int v = (int) e.getValue();
			if (v == 1) {
				ans += k;
			}

		}
		return ans;

	}

	// 1207. Unique Number of Occurrences
	private static boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		HashSet<Integer> set = new HashSet(map.values());
		return (map.size() == set.size());

	}

	// 1394. Find Lucky Integer in an Array
	private static int findLucky(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int e : arr) {
			map.put(e, map.getOrDefault(e, 0) + 1);
		}
		int max = -1;
		for (Map.Entry e : map.entrySet()) {
			int k = (int) e.getKey();
			int v = (int) e.getValue();
			if (k == v) {
				max = Math.max(max, k);
			}
		}
		return max;
	}

	// 771. Jewels and Stones
	private static int numJewelsInStones(String jewels, String stones) {
		HashSet<Character> set = new HashSet<>();
		for (char c : jewels.toCharArray()) {
			set.add(c);
		}
		int count = 0;
		for (char c : stones.toCharArray()) {
			if (set.contains(c))
				count++;
		}
		return count;
	}

	// 2103. Rings and Rods
	private static int countPoints(String rings) {
		HashMap<Character, HashSet<Character>> map = new HashMap<>();

		int i = 0, j = 1;
		while (i < rings.length() && j < rings.length()) {
			char k = rings.charAt(j);
			char v = rings.charAt(i);
			if (map.containsKey(k)) {
				HashSet set = map.get(k);
				set.add(v);
				map.put(k, set);
			} else {
				HashSet<Character> set = new HashSet<Character>();
				set.add(v);
				map.put(k, set);
			}
			i = i + 2;
			j = j + 2;

		}
		int count = 0;
		for (HashSet s : map.values()) {
			if (s.size() == 3)
				count++;
		}
		return count;
	}

	// 1941. Check if All Characters Have Equal Number of Occurrences
	private static boolean areOccurrencesEqual(String s) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int count = 0;
		int v = map.get(s.charAt(0));
		for (int freq : map.values()) {
			if (freq != v)
				return false;
		}
		return true;
	}

	// 1832. Check if the Sentence Is Pangram
	private static boolean checkIfPangram(String sentence) {
		int freq[] = new int[26];

		for (char ch : sentence.toCharArray()) {
			freq[ch - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (freq[i] == 0)
				return false;
		}
		return true;

	}

	// 1935. Maximum Number of Words You Can Type
	public int canBeTypedWords(String text, String brokenLetters) {
		HashSet<Character> set = new HashSet<>();

		for (char ch : brokenLetters.toCharArray()) {
			set.add(ch);
		}

		String words[] = text.split(" ");
		int count = 0;
		for (String s : words) {
			for (char ch : s.toCharArray()) {
				if (set.contains(ch)) {
					count++;
					break;
				}
			}
		}
		return words.length - count;
	}

	// 1160. Find Words That Can Be Formed by Characters
	public int countCharacters(String[] words, String chars) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : chars.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int count = 0;
		for (String s : words) {
			HashMap<Character, Integer> map1 = new HashMap<>();
			for (char ch : s.toCharArray()) {
				map1.put(ch, map1.getOrDefault(ch, 0) + 1);
			}
			boolean test = true;
			for (Map.Entry e : map1.entrySet()) {
				char k = (char) e.getKey();
				int v = (int) e.getValue();
				if (!map.containsKey(k)) {
					test = false;
					break;
				}

				else if (map.get(k) < v) {
					test = false;
					break;
				}
			}
			if (test == true)
				count += s.length();
		}
		return count;

	}

	// 36. Valid Sudoku
	public boolean isValidSudoku(char[][] suduko) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = suduko[i][j];
				if (c >= '1' && c <= '9') {
					if (!set.add("row" + i + c) || !set.add("col" + j + c)
							|| !set.add("box" + (i / 3) * 3 + j / 3 + c)) {
						return false;
					}
				}
			}
		}
		return true;

	}

	// 560. Subarray Sum Equals K
	static int countSubArrayWithSumK(int arr[], int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		int count = 0;
		int sum = 0;
		int j = 0;
		while (j < n) {
			sum += arr[j];
			int removeSum = sum - k;
			if (map.containsKey(removeSum))
				count += map.get(removeSum);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			j++;
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
		int c = countSubArrayWithSumK(arr, arr.length, k);
		return c;
	}

	private static void subArrayWithSumK(int arr[], int sum) {
		// TODO Auto-generated method stub

		/*
		 * 10,15,-5,15,-10,5 cs=currentSum s=start e=end
		 */

		// Largest subarry ,smallest subarray is also same
		int cs = 0, s = 0, e = -1;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			cs += arr[i];
			if (cs == sum) {
				s = 0;
				e = i;
				break;
			}
			if (map.containsKey(cs - sum)) {
				s = map.get(cs - sum) + 1;
				e = i;
				break;
			}
			map.put(cs, i);
		}
		if (e == -1)
			System.out.println("Not Found");
		else
			System.out.println("Found");

	}

}

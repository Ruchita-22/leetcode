package section2a.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	// 409. Longest Palindrome
	public int longestPalindrome(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int count = 0;
		boolean flag = false;
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			int v = e.getValue();
			if (v % 2 == 0)
				count = count + v;
			else {
				count = count + v - 1;
				flag = true;
			}

		}
		return flag == true ? count + 1 : count;
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

////////////////Frequency Array ////////////////////////////////

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

	// 383. Ransom Note
	// https://leetcode.com/problems/ransom-note/
	public boolean canConstruct(String ransomNote, String magazine) {

		int freq[] = new int[26];

		for (int i = 0; i < ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
			freq[ch - 'a']++;
		}
		for (int i = 0; i < magazine.length(); i++) {
			char ch = magazine.charAt(i);
			if (freq[ch - 'a'] > 0) {
				freq[ch - 'a']--;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0)
				return false;
		}
		return true;
	}

	// 1002. Find Common Characters
	public List<String> commonChars(String[] words) {

		int min_freq[] = new int[26];
		Arrays.fill(min_freq, Integer.MAX_VALUE);

		for (String string : words) {

			int freq[] = new int[26];

			for (char c : string.toCharArray()) {
				freq[c - 'a']++;
			}
			for (int i = 0; i < 26; i++) {
				min_freq[i] = Math.min(min_freq[i], freq[i]);
			}
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			while (min_freq[i] > 0) {
				list.add("" + (char) (i + 'a'));
				min_freq[i]--;
			}
		}
		return list;

	}

	// 2068. Check Whether Two Strings are Almost Equivalent
	public boolean checkAlmostEquivalent(String word1, String word2) {
		int freq1[] = new int[26];
		int freq2[] = new int[26];

		for (char c : word1.toCharArray()) {
			freq1[c - 'a']++;
		}
		for (char c : word2.toCharArray()) {
			freq2[c - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (Math.abs(freq1[i] - freq2[i]) > 3)
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

	// 2325. Decode the Message
	public String decodeMessage(String key, String message) {

		HashMap<Character, Character> map = new HashMap<>();
		int c = 0;
		for (int i = 0; i < key.length(); i++) {
			if (!map.containsKey(key.charAt(i)) && key.charAt(i) != ' ') {
				map.put(key.charAt(i), (char) ('a' + c));
				c++;
			}

		}
		// System.out.println(map);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) != ' ')
				sb.append(map.get(message.charAt(i)));
			else
				sb.append(' ');

		}
		return new String(sb);

	}

	// 1436. Destination City
	public String destCity(List<List<String>> paths) {
		HashMap<String, String> map = new HashMap<>();

		for (List<String> l : paths) {
			map.putIfAbsent(l.get(0), l.get(1));
		}
		// System.out.println(map);

		String key = paths.get(0).get(0);
		while (map.containsKey(key)) {
			key = map.get(key);
		}

		return key;
	}

	// 217. Contains Duplicate
	// https://leetcode.com/problems/contains-duplicate/
	public boolean containsDuplicate(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				return true;
			} else {
				map.put(arr[i], 1);
			}
		}
		return false;
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

///////////////////////////////////////////////////////////////
	public int dictionary(String[] words, String str) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			map.put(str.charAt(i), i);
		}
		for (int i = 0; i < words.length - 1; i++) {
			int l = words[i].length() < words[i + 1].length() ? words[i].length() : words[i + 1].length();
			int flag = 0;
			for (int j = 0; j < l; j++) {
				// correct order
				if (map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j))) {
					flag = 1;
					break;
				}
				// equal
				else if (map.get(words[i].charAt(j)) == map.get(words[i + 1].charAt(j))) {
					continue;
				}
				// if greater
				else {
					return 0;
				}

			}
			// no none
			if (flag == 0 && words[i].length() > words[i + 1].length())
				return 0;
		}
		return 1;
	}

	// 953. Verifying an Alien Dictionary
	public boolean isAlienSorted(String[] words, String order) {

		HashMap<Character, Integer> map = new HashMap<>();
		int index = 0;
		for (char c : order.toCharArray()) {
			map.putIfAbsent(c, index);
			index++;
		}
		for (int i = 0; i < words.length - 1; i++) {
			int l = words[i].length() < words[i + 1].length() ? words[i].length() : words[i + 1].length();
			boolean flag = false;
			for (int j = 0; j < l; j++) {
				if (map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j))) {
					flag = true;
					break;
				} else if (map.get(words[i].charAt(j)) == map.get(words[i + 1].charAt(j))) {
					continue;
				} else {
					return false;
				}
			}
			if (flag == false && words[i].length() > words[i + 1].length())
				return false;
		}
		return true;
	}

	// 387. First Unique Character in a String
	// https://leetcode.com/problems/first-unique-character-in-a-string/
	public int firstUniqChar(String str) {
		if (str.length() == 0)
			return -1;
		Map<Character, Integer> freq = new LinkedHashMap();
		Map<Character, Integer> index = new LinkedHashMap();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			freq.put(c, freq.getOrDefault(c, 0) + 1);
			if (!index.containsKey(c)) {
				index.put(c, i);
			}
		}

		Set<Character> set = new LinkedHashSet<Character>(freq.keySet());

		for (Character ch : set) {
			if (freq.get(ch) == 1) {
				return index.get(ch);
			}
		}
		return -1;
	}

	// 1496. Path Crossing
	// https://leetcode.com/problems/path-crossing/
	public static boolean isPathCrossing(String path) {
		if (path == null || path.length() == 0)
			return false;
		int x = 0;
		int y = 0;
		HashSet<String> set = new HashSet<>();
		set.add(0 + "#" + 0);
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'N')
				y++;
			if (path.charAt(i) == 'S')
				y--;
			if (path.charAt(i) == 'E')
				x++;
			if (path.charAt(i) == 'W')
				x--;
			String key = x + "#" + y;
			if (set.contains(key)) {
				return true;
			} else {
				set.add(key);
			}

		}
		return false;

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

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		String p = generate(pattern);
		List<String> l = new ArrayList<>();

		for (String s : words) {
			String t = generate(s);
			if (t.equals(p))
				l.add(s);
		}
		return l;

	}

	private static String generate(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1))
				count++;
			else {
				sb.append(count);
				count = 1;
			}
		}
		sb.append(count);
		// System.out.println(sb);
		return new String(sb);

	}
	// 2085. Count Common Words With One Occurrence

	public static int countWords(String[] w1, String[] w2) {
		Map<String, Integer> m1 = new LinkedHashMap();
		Map<String, Integer> m2 = new LinkedHashMap();
		for (String s : w1) {
			m1.put(s, m1.getOrDefault(s, 0) + 1);
		}
		for (String s : w2) {
			m2.put(s, m2.getOrDefault(s, 0) + 1);
		}
		int c = 0;
		for (String s : m1.keySet()) {
			if (m2.containsKey(s)) {
				if (m1.get(s) == m2.get(s) && m1.get(s) == 1 && m2.get(s) == 1)
					c++;
			}
		}

		return c;

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
	//1. Two Sum
	//https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //element , index
        int res[] = new int[2];
        for(int i=0;i<arr.length;i++){
            int a = arr[i];
            int b = target-a;
            if(map.containsKey(b)){
                res[0] = (int) map.get(b);
                res[1] = i;
                return res;
            }
            else{
                map.put(a,i);
            }
        }
        return new int[0];
        
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

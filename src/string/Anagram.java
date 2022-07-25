package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 242. Valid Anagram
	private static boolean isAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (Character c : s2.toCharArray()) {
			if (!map.containsKey(c))
				return false;
			else {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					map.remove(c);
			}
		}
		return map.size() == 0 ? true : false;

	}
    //242. Valid Anagram
    public boolean isAnagram2(String s, String t) {
        if(sort(s).equals(sort(t)))
            return true;
        else
            return false;
    }
    public String sort(String s) {
		char s1[]=s.toCharArray();
		Arrays.sort(s1);
		s = String.valueOf(s1);
		return s;
	}
    //////////////////////////////////////////
	
	

	private static boolean isAnagram1(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if (Arrays.equals(ch1, ch2))
			return true;
		else
			return false;

	}

	// 2273. Find Resultant Array After Removing Anagrams
	private static List<String> removeAnagrams(String[] words) {
		List<String> l = new ArrayList<>();
		l.add(words[0]);
		int i = 0;
		for (int j = 1; j < words.length; j++) {
			if (isAnagram(words[i], words[j])) {
				if (!l.contains(words[i])) {
					l.add(words[i]);
				}
			} else {
				i = j;
				l.add(words[i]);
			}
		}
		return l;
	}

	private static List<String> removeAnagrams1(String[] words) {
		// Both will work
		// List<String> l = new LinkedList<>(Arrays.asList(words));
		List<String> l = new ArrayList<>(Arrays.asList(words));
		int j = 1;
		while (j < l.size()) {
			if (isAnagram(l.get(j - 1), l.get(j))) {
				l.remove(j);
			} else
				j++;
		}
		return l;
	}

	public static List<Integer> findAnagrams(String str, String p) {

		HashMap<Character, Integer> map = new HashMap<>();
		for (Character c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);

		List<Integer> res = new ArrayList<>();

		int n = p.length();
		int i = 0, j = n - 1, count = 0;

		while (j < str.length()) {
			String s = str.substring(i, j + 1);
			System.out.println(s);
			if (isAnagram(s, p)) {
				res.add(i);
				count++;
			}
			i++;
			j++;

		}
		System.out.println(count);
		return res;

	}
	// https://leetcode.com/problems/find-all-anagrams-in-a-string/
	// 438. Find All Anagrams in a String
	// 567. Permutation in String
	// https://leetcode.com/problems/permutation-in-string/
	public static List<Integer> findAnagrams1(String str, String p) {

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
		// slide window and check
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
	

	// 1446. Consecutive Characters
	private static int maxPower(String s) {

		int i = 0, j = 0;
		int ans = 0;
		while (j < s.length()) {
			if (s.charAt(i) == s.charAt(j))
				j++;
			else {
				ans = Math.max(ans, j - i);
				i = j;
				j++;

			}
		}
		ans = Math.max(ans, j - i);
		return ans;
	}

}

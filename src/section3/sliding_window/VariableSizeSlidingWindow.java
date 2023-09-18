package section3.sliding_window;

import java.util.HashMap;
import java.util.HashSet;

public class VariableSizeSlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	///////////////////////////////////////////////////////////////////////////
	// Variabe Window Size
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

	public int longestSubStringWithUniqueCharacter(String str) {

        HashSet<Character> set = new HashSet<>();
        int len = 0;
        int i=0,j=0;
        while(j<str.length()){
            char cj = str.charAt(j);
            if(!set.contains(cj)){
                set.add(cj);
                len = Math.max(len,set.size());
                j++;
            }
            else{
                while(set.contains(cj)){
                    set.remove(str.charAt(i));
                    i++;
                }
            }
        }
        return len;
    }
	
	// this is same for toy pick if k=2
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k>s.length())	return 0;
        
        // write your code here
        HashMap<Character,Integer> map = new HashMap<>();

        int i=0,j=0,len=0;
        while(j<s.length()){
            char cj = s.charAt(j);
            map.put(cj,map.getOrDefault(cj,0)+1);
            
            if(map.size()<k){
                j++;
            }
            if(map.size()==k){
                len = Math.max(len,j-i+1);
                j++;
            }
            else if(map.size()>k){
                while(map.size()>k){
                    char ci = s.charAt(i);
                    map.put(ci,map.get(ci)-1);
                    if(map.get(ci)==0){
                        map.remove(ci);
                    }
                    i++;
                }
                j++;
            }
        }
        return len;
    }
	
	//Minimum Window Substring | Variable Size Sliding Window
	public String minWindow(String A, String B) {
        if( (A.length() == 0) || (A.length() < B.length()))    return "";

        //create a frequenecy map of B
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : B.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int i=0,j=0;
        String res = "";
        int useful=0,len=Integer.MAX_VALUE;
        int begin = 0;
        
        while(j<A.length()){
            char cj = A.charAt(j);

            if(map.containsKey(cj)){
                map.put(cj,map.get(cj)-1);
                if(map.get(cj)>=0)
                    useful++;  
            }    
             
            while(useful==B.length()){
                //check for better ans
                if(len>j-i+1){
                    len = j-i+1;
                    begin = i;
                }
                if(map.containsKey(A.charAt(i))){
                    char ci = A.charAt(i);
                    map.put(ci, map.get(ci)+1);
                    if(map.get(ci)>0){
                        useful--;
                    }
                }
                i++;
            }  
            j++;       
        }
        if(len>A.length())  return "";
        return A.substring(begin,begin+len);
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
	//424. Longest Repeating Character Replacement
	//https://leetcode.com/problems/longest-repeating-character-replacement/
	//pending
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
	
	//2024. Maximize the Confusion of an Exam
	public int maxConsecutiveAnswers(String str, int k) {
        return Math.max(solve(str,k,'T'),solve(str,k,'F'));
    }
    private static int solve(String str, int k, char c){
        int ans = 0;
        int i=0,j=0;
      
        while(j<str.length()){
            if(str.charAt(j)==c)
                k--;
            while(k<0){
                if(str.charAt(i)==c)
                    k++;
                i++;
            }
            ans = Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }

}

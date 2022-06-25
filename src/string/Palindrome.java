package string;

import java.util.*;
import java.util.Map.Entry;


public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	//409. Longest Palindrome
	public static int longestPalindrome1(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);            
        }
        int count=0;
        boolean flag =false;
        for(Map.Entry<Character, Integer> e : map.entrySet()) {
        	int v =e.getValue();
        	if(v%2==0)
        		count = count+v;
        	else {
                count = count+v-1;
                flag = true;
            }
        		
        }
        return flag==true ? count+1 : count;
	}
	//Expand from the center--Manacher’s Algorithm
	/*
	 Manacher’s algorithm optimizes the “Expand Around The Centre” 
	 solution by using some insights into how palindromes work.

	Let C be the center of the longest-length palindrome we have encountered
	till now. And let L and R be the left and right boundaries of this 
	palindrome, i.e., the left-most character index and the right-most 
	character index, respectively.
	 */
	//length of the longest substring
	//409. Longest Palindrome
	private static int lengthOfLongestPalindromicSubString(String s) {
		int ans=0;
        for(int i=0;i<s.length();i++){
            int len1 = expand(s,i,i+1);
            int len2 = expand(s,i,i);
            int len = Math.max(len1,len2);
            ans = Math.max(ans, len);
        }
        return ans;
        
    }
	private static int expand(String s, int i, int j) {
		// TODO Auto-generated method stub
		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
			i--;
			j++;
		}
		return (j-i+1)-2;
	}
	
	
	//print the longest panlindromic substring
	//5. Longest Palindromic Substring
	private static String longestPalindrome(String s) {
		int start=0,end=0;
        for(int i=0;i<s.length();i++){
            int len1 = expand(s,i,i+1);
            int len2 = expand(s,i,i);
            int len = Math.max(len1,len2);
            if((end-start) < len) {
            	start  = i-((len-1)/2);
            	end = i+(len/2);
            }   
        }
        return s.substring(start,end+1);
        
    }
	//647. Palindromic Substrings
	private static int countPalindromicSubString(String s) {
		int count=0;
        for(int i=0;i<s.length();i++){
            count += expand1(s,i,i);
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1))
            	count += expand1(s,i,i+1);
        }    
        return count;
        
    }
	private static int expand1(String s, int i, int j) {
		// TODO Auto-generated method stub
		int count=0;
		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)) {
			i--;
			j++;
			count++;
		}
		return count;
	}
	
	
	
	

}

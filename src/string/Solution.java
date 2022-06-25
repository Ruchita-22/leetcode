package string;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solve(new int[] {1,4,3,5,2},3));
		
	}

	private static int length(String s) {
		if(s==null)
			return 0;
		int length=0,i=0;
		for (char ch: s.toCharArray()) {
			length++;
		}
		return length;
	}
	private static void reversePrint(String s) {
		// TODO Auto-generated method stub
		for (int i = s.length()-1; i >=0; i--) {
			System.out.print(s.charAt(i));
		}

	}
	//344. Reverse String
	private static String reverse(String s) {
		s.trim();
		char ch[] = s.toCharArray();
		int start = 0;
		int end = ch.length-1;
		while(start<=end) {
			char c = ch[start];
			ch[start]= ch[end];
			ch[end] =  c;
			start++; 
			end--;
		}
		return new String(ch);
	}
	//557. Reverse Words in a String III
	private static String reverseEachWords(String s) {
		// TODO Auto-generated method stub
		s=s.trim();
		String str[] = s.split(" ");
		String res = "";
		for (int i = 0; i < str.length; i++) {
			str[i]=reverse(str[i]);
		    res = res+str[i]+" ";
		}
		return res;
	}
	//revise
	private static String reverseStr(String s, int k) {
		s.strip();
		char ch[] = s.toCharArray();
		
		char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
	
	private static void reverseWords(String s) {
		// TODO Auto-generated method stub
		s= s.strip();
		String str[] =  s.split(" ");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < str.length; i++) {
			stack.push(str[i]);
		}
		while(!stack.isEmpty()) {
			if(stack.peek()=="")
				stack.pop();
			else {
				System.out.print(stack.pop());
				System.out.print(" ");
			}
		}

	}
	//Parenthesis Checker
	private static boolean parenthesisChecker(String s) {
		// TODO Auto-generated method stub
		char str[] =  s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length; i++) {
			if(str[i]=='('||str[i]=='{'||str[i]=='[') {
				stack.push(str[i]);
			}
			else if(
					(str[i]==')'&& stack.peek()=='(')||
					(str[i]=='}'&& stack.peek()=='{')||
					(str[i]==']'&& stack.peek()=='[')
					) {
				stack.pop();
			}
			else
				return false;
		}
		return stack.isEmpty()? true: false;
	}
	//Word with maximum frequency
	private static String wordWithMaxFrequency(String s) {
		String str[] = s.split(" ");
		Map<String, Integer> map = new LinkedHashMap<String,Integer>();
		for (int i = 0; i < str.length; i++) {
			if(map.containsKey(str[i]))
				map.put(str[i], map.get(str[i])+1);
			else
				map.put(str[i], 1);
		}
	    Map.Entry<String, Integer> e =	Collections.max(map.entrySet(), Map.Entry.comparingByValue());
		return e.getKey()+" "+e.getValue();
	}
	
	private static boolean checkPalindrome(String s) {
		//2 pointer problem
		if(s==null)
			return true;
		int start = 0;
		int end = s.length()-1;
		while (start<=end) {
			if(s.charAt(start)!=s.charAt(end))
				return false;
			else {
				start++; 
				end--;
			}
		}
		return true;
	}
	private static int solve1(String s) {
		//Input "00011011"
        int i = 0,j=0;
        String r = "";
        int count = 0;
        for(char c : s.toCharArray()) {
        	if(c=='0')
        		i++;
        	else 
        		j++;
            r=r+c;
            if(i==j){
                count++;
                r="";
            }
        }
        return count;
    }
	
	private static String solve2(String s) {
        String r="";
        for(char c: s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                r = r+c;
            }
        }
        return r;
    }
	private static int solve(int[] arr, int b) {
        int c=0;
        boolean s=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==b)
                s=true;
            if(arr[i]>b){
                arr[i]=-1;
                c++;
            }
        }
        if(s==true)
            return c;
        else
            return -1; 
    }
	

}

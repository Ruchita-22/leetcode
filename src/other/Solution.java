package other;

import java.util.*;


public class Solution {
	public String intToRoman(int inputNumber) {
		//12. Integer to Roman
        String unit[] = {"","I", "II", "III", "IV", "V", "VI", "VII","VIII","IX"};
		String tens[] = {"","X", "XX", "XXX", "XL", "L","LX","LXX","LXXX", "XC"};
		String hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC","DCC","DCCC", "CM"};
		String thousand[] = {"", "M", "MM","MMM"};
		
		return thousand[inputNumber/1000] + hundred[(inputNumber%1000)/100] + tens[(inputNumber%100)/10] + unit[(inputNumber%10)];
    }
	//13. Roman to Integer
	public int romanToInt(String inputString) {
        Map<Character, Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int result = 0;
		for (int i = 0; i < inputString.length(); i++) {
			if((i>0)&&(map.get(inputString.charAt(i)) > map.get(inputString.charAt(i-1)))) {
				result = result + map.get(inputString.charAt(i)) - 2* map.get(inputString.charAt(i-1));
			}
			else {
				result =result + map.get(inputString.charAt(i));	
			}
		}
		return result;
    }
//	//200. Number of Islands
//	public int numIslands(char[][] grid) {
//		int row = grid.length; 
//		
//		int count = 0;
//		
//		if(row==0)
//			return 0;
//       int col = grid[0].length;
//       if(col==0)
//           return 0;
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				if(grid[i][j]=='1') {
//					count++;
//					sink(grid,i,j);
//				}
//			}	
//		}
//		return count;
//	        
//	  }
//	private void sink(char[][] grid, int i, int j) {
//		// TODO Auto-generated method stub
//		if (i>=0 && j>=0 && i< grid.length && j< grid[0].length && grid[i][j]=='1' ) {
//			grid[i][j]='2';
//			sink(grid, i+1, j);
//			sink(grid, i, j+1);
//			sink(grid, i-1, j);
//			sink(grid, i, j-1);
//		}
//	}
	//121. Best Time to Buy and Sell Stock
	public int maxProfit(int[] a) {
        int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]-min);
		}
        return max;
        
    }
	//122. Best Time to Buy and Sell Stock II
	public int maxProfit1(int[] a) {
        int i=0;
        int p = 0;
        while(i < a.length-1){
            if(a[i] < a[i+1]){
                p = p+a[i+1]-a[i];
                i++;
            }
            else {
                i++;
            }
        }
        return p;
    }
	//268. Missing Number
	 public int missingNumber(int[] nums) {
	        int a = 0;
	        int b = 0;
	        for(int i=0; i < nums.length; i++){
	            a = a ^ nums[i];
	        }
	        for(int i=0; i<=nums.length; i++){
	            b = b ^ i;
	        }
	        return a^b;
	            
	    }
	 //202. Happy Number
	 Set<Integer> set = new HashSet<>();
	    public boolean isHappy(int n) {
	        while(n > 1){
	           
	            if (set.contains(n)){
	                return false;
	            }
	            else {
	                set.add(n);
	            }
	            int temp = n;
	            int sum=0;
	            while(temp >0){
	                int t = temp%10;
	                temp = temp/10;
	                sum += t*t;
	            }
	            n = sum;
	        }
	        if(n==1)    return true;
	        else    return false;
	    }
	    public List<List<String>> groups(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> map = new HashMap<String, List>();
	        for (int i = 0; i < strs.length; i++) {
				String temp = strs[i];
	            char c[] = temp.toCharArray();
			    Arrays.sort(c);
			    String k = String.valueOf(c);
				if(!map.containsKey(k)){
	                map.put(k, new ArrayList());
	            }    
	            map.get(k).add(temp);
			}
	        return new ArrayList(map.values());
	        
	    }
	    //242. Valid Anagram
	    public boolean isAnagram(String s, String t) {
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

}

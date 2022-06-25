package hashmap;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void subArrayWithSumK(int arr[],int sum) {
		// TODO Auto-generated method stub
		
		/*
		 10,15,-5,15,-10,5
		 cs=currentSum
		 s=start
		 e=end
		 * */
		
		//Largest subarry ,smallest subarray is also same 
		int cs=0,s=0,e=-1;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < arr.length; i++) {
			cs += arr[i];
			if(cs==sum) {
				s=0; 
				e=i; 
				break;
			}
			if(map.containsKey(cs-sum) ) {
				s=map.get(cs-sum)+1;
				e=i;
				break;
			}
			map.put(cs, i);
		}
		if(e==-1)
			System.out.println("Not Found");
		else
			System.out.println("Found");

	}
	

}

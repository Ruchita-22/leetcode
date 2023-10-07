package section6.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frequencySort(new int[] {1,1,2,2,2,3});
	}
	//1636. Sort Array by Increasing Frequency
	public static int[] frequencySort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
            
        }
        List<Entry<Integer, Integer>> l =new ArrayList<>(map.entrySet());
        Collections.sort(l, (o1,o2)->
	        o1.getValue()!=o2.getValue() ? 
	        o1.getValue()-o2.getValue() : 
	        o2.getKey()-o1.getKey());
        System.out.println(l);
        int i=0;
        for(Entry<Integer, Integer> e : l){
            int f=e.getValue();
            while(f>0){
                arr[i]=e.getKey();
                i++;
                f--;
            }
        }
        return arr;
    }
	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+" ");
		}
	}

}

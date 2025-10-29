package section10.sweep_line_algorithm;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
	/*
	 * Line Sweep Algo 
		https://leetcode.com/problem-list/mzw3cyy6/
		https://leetcode.com/problem-list/o1qf3c31/
		https://leetcode.com/problem-list/line-sweep/
		https://leetcode.com/discuss/study-guide/2166045/line-sweep-algorithms
	 * */
	
	//Sweep line algo used to find intersection point
	//1854. Maximum Population Year
	public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < logs.length; i++){
            map.put(logs[i][0], map.getOrDefault(logs[i][0], 0) + 1);
            map.put(logs[i][1], map.getOrDefault(logs[i][1], 0) - 1);
            
        }
        //System.out.println(map);
        int currPopulation = 0, maxAns = 0, maxYear = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            currPopulation += e.getValue();
            if(currPopulation > maxAns) {
                maxAns = currPopulation;
                maxYear = e.getKey();
            }
        }
        return maxYear;
    }
	//729. My Calendar I
	class MyCalendar {
	    Map<Integer, Integer> map;
	    public MyCalendar() {
	        map = new TreeMap();
	        
	    }
	    
	    public boolean book(int start, int end) {
	        
	        map.put(start, map.getOrDefault(start,0) + 1);
	        map.put(end, map.getOrDefault(end,0) - 1);
	                
	        int sum = 0;
	        for(Map.Entry<Integer, Integer> e : map.entrySet()){
	            sum += e.getValue();
	            if(sum > 1) {
	                 map.put(start, map.get(start) - 1);
	                 map.put(end, map.get(end) + 1);
	                return false;
	            }
	        }
	        return true;
	        
	        
	    }
	}
	//731. My Calendar II
	class MyCalendarTwo {
	    Map<Integer, Integer> map;
	    public MyCalendarTwo() {
	         map = new TreeMap();
	    }
	    
	    public boolean book(int start, int end) {
	         map.put(start, map.getOrDefault(start,0) + 1);
	        map.put(end, map.getOrDefault(end,0) - 1);
	                
	        int sum = 0;
	        for(Map.Entry<Integer, Integer> e : map.entrySet()){
	            sum += e.getValue();
	            if(sum > 2) {
	                 map.put(start, map.get(start) - 1);
	                 map.put(end, map.get(end) + 1);
	                return false;
	            }
	        }
	        return true;
	    }
	}
	//732. My Calendar III
	class MyCalendarThree {
	    Map<Integer, Integer> map;
	    public MyCalendarThree() {
	         map = new TreeMap();
	    }
	    
	    public int book(int startTime, int endTime) {
	        map.put(startTime, map.getOrDefault(startTime,0) + 1);
	        map.put(endTime, map.getOrDefault(endTime,0) - 1);
	                
	        int sum = 0, max = 0;
	        for(Map.Entry<Integer, Integer> e : map.entrySet()){
	            sum += e.getValue();
	            if(max < sum) max = sum;
	        }
	        return max;
	        
	    }
	}
	//2406. Divide Intervals Into Minimum Number of Groups
	public int minGroups(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0],0) + 1);
            map.put(intervals[i][1]+1, map.getOrDefault(intervals[i][1]+1,0) - 1);
        }
        
        int sum = 0, max = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            sum += e.getValue();
            if(max < sum) max = sum;
        }
        return max;
    }
	//2251. Number of Flowers in Full Bloom
	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < flowers.length; i++){
            map.put(flowers[i][0], map.getOrDefault(flowers[i][0],0) + 1);
            map.put(flowers[i][1]+1, map.getOrDefault(flowers[i][1]+1,0) - 1);
        }
        
        //System.out.println(map);
        int sum = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            sum += e.getValue();
            map.put(e.getKey(),sum);
        }
        //System.out.println(map);
        int ans[] = new int[people.length];
        for(int i = 0; i < people.length; i++){
           ans[i] = map.floorEntry(people[i]) == null ? 0 : map.floorEntry(people[i]).getValue();
        }
        
       
        return ans;
        
    }
	//1109. Corporate Flight Bookings
	public int[] corpFlightBookings(int[][] bookings, int n) {
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < bookings.length; i++) {
			map.put(bookings[i][0], map.getOrDefault(bookings[i][0], 0) + bookings[i][2]);
			map.put(bookings[i][1] + 1, map.getOrDefault(bookings[i][1] + 1, 0) - bookings[i][2]);
		}

		// System.out.println(map);
		int sum = 0;
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			sum += e.getValue();
			map.put(e.getKey(), sum);
		}
		// System.out.println(map);
		int ans[] = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = map.floorEntry(i + 1) == null ? 0 : map.floorEntry(i + 1).getValue();
		}

		return ans;

	}
	//2779. Maximum Beauty of an Array After Applying Operation
	public int maximumBeauty(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < nums.length; i++){
            // interval start from smaller value
            map.put(nums[i] - k, map.getOrDefault(nums[i] - k,0) + 1);
            map.put(nums[i] + k + 1, map.getOrDefault(nums[i] + k + 1,0) - 1);
            
        }
        
        //System.out.println(map);
        int sum = 0, max = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            sum += e.getValue();
            if(max < sum) max = sum;
        }
        return max;
    }

}

package section0d.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//https://www.geeksforgeeks.org/program-to-find-weighted-median-of-a-given-array/
public class WeightedMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//462. Minimum Moves to Equal Array Elements II
	
	public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int idx = n % 2 == 0 ? n/2 : n/2 + 1;
        int center = nums[idx-1];
        int cost = 0;
        
        for(int num : nums){
            cost += Math.abs(num - center);
        }
        return cost;
        
    }
	//2448. Minimum Cost to Make Array Equal
	//https://www.youtube.com/watch?v=clHTLCrl7eM
	class Pair{
	    int x,y;
	    public Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	public long minCost(int[] nums, int[] cost) {
        // total elements in nums array
        int n = nums.length;    
        
        // create a list and stor a pair <element, cost> and also count total elements if cost is freq
        ArrayList<Pair> list = new ArrayList<>();
        long total_elements = 0;
        for(int i = 0; i < n; i++){
            list.add( new Pair(nums[i], cost[i]) );
            total_elements += cost[i];
        }
        
        // sort the list acc. to elment in inc order
        
        Collections.sort(list, (o1,o2) -> o1.x != o2.x ? o1.x - o2.x : o1.y-o2.y);
        
        
        // mid elemet index
        total_elements = total_elements %2 == 0 ?  total_elements/2 : total_elements/2 + 1;
        
        // find mid element which will be center
        long mid = 0;
        int i=0;
        while(i < n && mid < total_elements){
            mid +=  list.get(i).y;
            i++;
        }
        int center = list.get(i-1).x;
        
        // cal cost
        long total_cost = 0;
        for(Pair p : list){
            total_cost += ( Math.abs(p.x - center) * 1L * p.y);
        }
        return total_cost;
        
    }
}

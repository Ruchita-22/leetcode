package section8.greedy;

import java.util.Arrays;

public class Knapsack {
	class Item {
	    int value, weight;
	    Item(int x, int y){
	        this.value = x;
	        this.weight = y;
	    }
	}
	class Item1 {
	    int value, weight;
	    double ratio;
	    Item1(int x, int y){
	        this.value = x;
	        this.weight = y;
	        this.ratio = x*1F/y;
	    }
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 double fractionalKnapsack(int W, Item arr[], int n) 
	    {
	        Item1 items[] = new Item1[arr.length];
	        int i=0;
	        for(Item p : arr){
	            items[i] = new Item1(p.value,p.weight);
	            i++;
	        }
//	        Arrays.sort(items,
//	        (o1,o2)-> o1.ratio!=o2.ratio ? o2.ratio-o1.ratio : o2.value-o1.value 
//	        );
	        double cost=0;
	        int j=0;
	        for(Item1  p : items){
	            
	            if(W> p.weight){
	                cost = cost+p.value;
	                W=W-p.value;
	                j++;
	            }
	            else{
	                break;
	            }
	            
	        }
	        cost += items[j].ratio * items[j].value;
	        return cost;
	    }
}

package section2.heap;

import java.util.PriorityQueue;

public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	//Q1. Running Median
	
	public int[] runningMedian(int[] arr) {
        PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)-> o2-o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        int res[] = new int[arr.length];
        int i=0;
        
        for(int e : arr){
            if(max.size()>0 && max.peek()>e)   max.add(e);
            else min.add(e);

            if(min.size()-max.size()>1) max.add(min.poll());
            else if(max.size()-min.size()>1) min.add(max.poll());
            else {};

            res[i] = min.size()>max.size() ?  min.peek(): max.peek();
            i++;
        }
        return res;  
    }
	
	//Q3. Special Median
	public int specialMedian(int[] arr) {
        if(arr.length==1)   return 0;
        long medianLeftToRight[] =  medianLeftToRight(arr);
        long medianRightToLeft[] =  medianRightToLeft(arr);

        for(int i=1;i<arr.length;i++){
            if(medianLeftToRight[i-1]== 2*1L* arr[i]) {  
                return 1;
            }
        }
        for(int i=1;i<arr.length;i++){
            if(medianRightToLeft[i-1] == 2*1L* arr[arr.length-i-1]){
                  return 1;
            }      
        }
        return 0;
    }
    private static long[] medianLeftToRight(int[] arr) {
		PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2)-> o2-o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        long res[] = new long[arr.length];
        int i=0;
        
        for(int e : arr){
            if(max.size()>0 && max.peek()>e)   max.add(e);
            else min.add(e);

            if(min.size()-max.size()>1) max.add(min.poll());
            else if(max.size()-min.size()>1) min.add(max.poll());
            else {};
            
            if(min.size()==max.size())	res[i] = min.peek()*1L+max.peek();
            else res[i] = min.size()>max.size() ? 2*1L * min.peek() : 2 *1L* max.peek();
            
            //res[i] = min.size()>max.size() ? 2*1L * min.peek(): ((min.size()==max.size()) ? min.peek()*1L+max.peek() :  2 *1L* max.peek());
            i++;
        }
        return res;  
    }
    private static long[] medianRightToLeft(int[] arr) {
		int res[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i] = arr[arr.length-1-i];
        }
        return  medianLeftToRight(res);
    }
}

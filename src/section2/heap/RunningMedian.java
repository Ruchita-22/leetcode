package section2.heap;

import java.util.PriorityQueue;

public class RunningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	PriorityQueue<Integer> min, max;
    public double[] medianSlidingWindow(int[] nums, int k) {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        double[] res = new double[nums.length-k+1];
        int idx = 0;
        for(int  j = 0; j < k; j++) {
            addNumber(nums[j]);
        }
        res[idx] = getMedian();
        idx++;

        int i = 0, j = k;
        while(j < nums.length) {
            removeNumber(nums[i]);
            addNumber(nums[j]);
            res[idx++] = getMedian();
            i++; j++;
        }
        return res;
    }
    private void addNumber(int x) {
        if(max.size() > 0  && (int) max.peek() > x) max.add(x);
        else min.add(x);
        balanceHeap();
    }
    private void balanceHeap() {
        if(min.size() - max.size() > 1) max.add(min.poll());
        else if(max.size() - min.size() > 1) min.add(max.poll());
        else {}
    }
    private double getMedian() {
        if(min.size() > max.size()) return  (double) min.peek();
        else if(min.size() < max.size()) return (double) max.peek();
        else return ((double) min.peek() + (double) max.peek())/2.0;
    }
    private void removeNumber(int x) {
        if(min.contains(x)) min.remove(x);
        else max.remove(x);
        balanceHeap();
    }
    private void removeNumber1(int x) {
        if(!max.remove(x)) min.remove(x);
    }
	//Q1. Running Median
	
	public int[] runningMedian(int[] arr) {
		PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> right = new PriorityQueue<>();

        int res[] = new int[arr.length];
        int i=0;
        
        for(int e : arr){
			if (left.size() > 0 && left.peek() > e)   left.add(e);
            else right.add(e);

			if (right.size() - left.size() > 1) left.add(right.poll());
			else if (left.size() - right.size() > 1) right.add(left.poll());
            else {};

			res[i] = right.size() > left.size() ?  right.peek(): left.peek();
            i++;
        }
        return res;  
    }
	
	//Q3. Special Median
	public int specialMedian(int[] arr) {
		if (arr.length == 1)   return 0;
        long medianLeftToRight[] =  medianLeftToRight(arr);
        long medianRightToLeft[] =  medianRightToLeft(arr);

		for (int i = 1; i < arr.length; i++) {
			if (medianLeftToRight[i - 1] == 2 * 1L * arr[i]) {
				return 1;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if (medianRightToLeft[i - 1] == 2 * 1L * arr[arr.length - i - 1]) {
				return 1;
			}
		}
        return 0;
    }
    private static long[] medianLeftToRight(int[] arr) {
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> min = new PriorityQueue<>();

		long res[] = new long[arr.length];
		int i = 0;

		for (int e : arr) {
			if (max.size() > 0 && max.peek() > e)	max.add(e);
			else	min.add(e);

			if (min.size() - max.size() > 1)	max.add(min.poll());
			else if (max.size() - min.size() > 1)	min.add(max.poll());
			else {
			}
			

			if (min.size() == max.size())	
				res[i] = min.peek() * 1L + max.peek();
			else
				res[i] = min.size() > max.size() ? 2 * 1L * min.peek() : 2 * 1L * max.peek();

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

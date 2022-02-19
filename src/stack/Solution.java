package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {100,80,60,70,60,75,60};
		System.out.println(stockSpanProblem(arr));

	}
	private static List nextLargestElement(int arr[]) {
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = arr.length-1; i >=0; i--) {
			if(stack.isEmpty()) 
				list.add(-1);
			else if (!stack.isEmpty()&& stack.peek()>arr[i]) 
				list.add(stack.peek());
			else if(!stack.isEmpty()&& stack.peek()<=arr[i]) {
				while (!stack.isEmpty() && stack.peek()<=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty())
					list.add(-1);
				else {
					list.add(stack.peek());
				}	
			}
			stack.push(arr[i]);
		}
		Collections.reverse(list);
		return list;
	}
	private static List nearestGreatestToLeft(int arr[]) {
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) 
				list.add(-1);
			else if (!stack.isEmpty()&& stack.peek()>arr[i]) 
				list.add(stack.peek());
			else if(!stack.isEmpty()&& stack.peek()<=arr[i]) {
				while (!stack.isEmpty() && stack.peek()<=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty())
					list.add(-1);
				else {
					list.add(stack.peek());
				}	
			}
			stack.push(arr[i]);
		}
		//Collections.reverse(list);
		return list;
	}
	private static List nearestSmallestToLeft(int arr[]) {
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) 
				list.add(-1);
			else if (!stack.isEmpty()&& stack.peek()<arr[i]) 
				list.add(stack.peek());
			else if(!stack.isEmpty()&& stack.peek()>=arr[i]) {
				while (!stack.isEmpty() && stack.peek()>=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty())
					list.add(-1);
				else {
					list.add(stack.peek());
				}	
			}
			stack.push(arr[i]);
		}
		//Collections.reverse(list);
		return list;
	}
	private static List nearestSmallestToRight(int arr[]) {
		
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = arr.length-1; i >=0; i--) {
			if(stack.isEmpty()) 
				list.add(-1);
			else if (!stack.isEmpty()&& stack.peek()<arr[i]) 
				list.add(stack.peek());
			else if(!stack.isEmpty()&& stack.peek()>=arr[i]) {
				while (!stack.isEmpty() && stack.peek()>=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty())
					list.add(-1);
				else {
					list.add(stack.peek());
				}	
			}
			stack.push(arr[i]);
		}
		Collections.reverse(list);
		return list;
	}
	private static List stockSpanProblem(int arr[]) {
		// TODO Auto-generated method stub
		//same as nearest greatest problem
		Stack<Pair> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(stack.isEmpty())
				list.add(-1);
			else if(!stack.isEmpty() && stack.peek().element>arr[i])
				list.add(stack.peek().index);
			else if(!stack.isEmpty() && stack.peek().element<=arr[i]) {
				while (!stack.isEmpty() && stack.peek().element<=arr[i]) {
					stack.pop();
				}
				if(stack.empty())
					list.add(-1);
				else
					list.add(stack.peek().index);
			}
			stack.push(new Pair(arr[i],i));
		}
		
		for (int i = 0; i < arr.length; i++) {
			list.add(i-list.get(i));
		}
				
		return list;
	}

}

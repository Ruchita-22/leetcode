package stack;

import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static Stack<Integer> sortStack(Stack<Integer> input) {
    	if(input.size()<2)	return input;
    	
		Stack<Integer> sorted = new Stack<>();
		if(input.size()>0)	sorted.push(input.pop());
		
		while(input.size()>0) {
			int x = input.pop();
			while(sorted.size()>0 && sorted.peek()<x) {
				input.push(sorted.pop());
			}
			sorted.push(x);
		}
		while(sorted.size()>0)	input.push(sorted.pop());
		return input;
		
	}

}

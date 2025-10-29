package stack;

import java.util.Stack;

public class StackImp4Fn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 5, 2, 7, 3, 9, 2 };
		ngr(arr);

	}

	/////////////////// Helper///////////////////////////////
	private static int[] nsl(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < arr.length; i++) {
			while (stack.size() > 0 && stack.peek() > arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? -1 : stack.peek();
			stack.push(arr[i]);
		}
		return res;
	}

	private static int[] nsr(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (stack.size() > 0 && stack.peek() > arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? -1 : stack.peek();
			stack.push(arr[i]);
		}
		return res;
	}

	private static int[] ngl(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < arr.length; i++) {
			while (stack.size() > 0 && stack.peek() < arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? -1 : stack.peek();
			stack.push(arr[i]);
		}
		return res;
	}

	private static int[] ngr(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (stack.size() > 0 && stack.peek() < arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? -1 : stack.peek();
			stack.push(arr[i]);
		}
		return res;
	}
	// it store index

	private static int[] nsl_index(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < arr.length; i++) {

			while (stack.size() > 0 && arr[stack.peek()] > arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? -1 : stack.peek();
			stack.push(i);
		}
		return res;
	}

	private static int[] nsr_index(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = arr.length - 1; i >= 0; i--) {
			while (stack.size() > 0 && arr[stack.peek()] > arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? n : stack.peek();
			stack.push(i);
		}
		return res;
	}

	private static int[] ngl_index(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = 0; i < arr.length; i++) {

			while (stack.size() > 0 && arr[stack.peek()] < arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? -1 : stack.peek();
			stack.push(i);
		}
		return res;
	}

	private static int[] ngr_index(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for (int i = arr.length - 1; i >= 0; i--) {

			while (stack.size() > 0 && arr[stack.peek()] < arr[i])
				stack.pop();
			res[i] = stack.size() == 0 ? n : stack.peek();

			stack.push(i);
		}
		return res;
	}

	private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

}

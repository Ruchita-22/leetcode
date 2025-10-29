package stack;

import java.util.Stack;

public class MaxAreaRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public int largestRectangleArea(int[] arr) {
	        if(arr.length==1) return arr[0];
			int sl[] = nsl_index(arr);
			int sr[] = nsr_index(arr);
			long ans = 0;
			for (int i = 0; i < arr.length; i++) {
				long width = (sr[i] - sl[i] - 1);
				ans = Math.max(ans, mul(arr[i], width));
			}
			int mod = (int) (1e9 + 7);
			ans = ans % mod;
			ans = ans < 0 ? ans + mod : ans;
			return (int) ans;
	        
	    }
	    /////////////////Helper Function////////////////////////
	    private static int[] nsl_index(int arr[]) {
			int n = arr.length;
			int res[] = new int[n];
			Stack<Integer> stack = new Stack();
			for (int i = 0; i < arr.length; i++) {
				while (stack.size() > 0 && arr[stack.peek()] >= arr[i])
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
				while (stack.size() > 0 && arr[stack.peek()] >= arr[i])
					stack.pop();
				res[i] = stack.size() == 0 ? n : stack.peek();

				stack.push(i);
			}
			return res;
		}

	    public static long mul(long a, long b) {
	        int mod = (int) (1e9+7);
			return (((a % mod) * (b % mod) + mod) % mod);
		}

}

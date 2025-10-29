package stack;

import java.util.Stack;

public class MaxAndMin {
	public static void main(String[] args) {
		int arr[] = new int[] { 4, 7, 3, 8};
		print(arr);
		System.out.println(solve(arr));
		
	}
	private static int solve(int[] arr) {
        int nsl[] = nsl_index(arr);
        int nsr[] = nsr_index(arr);
        int ngl[] = ngl_index(arr);
        int ngr[] = ngr_index(arr);
        
        long ans = 0;

        for(int i=0;i<arr.length;i++){
            long min = mul( arr[i], mul(i-nsl[i],nsr[i]-i));
            long max = mul(arr[i],mul(i-ngl[i],ngr[i]-i));
            ans = add(ans,sub(max,min));
        }
        int mod = (int)(1e9+7);
        ans = ans%mod;
        ans = ans<0 ? ans+mod : ans;
        return (int)ans;
    }
	
    ///////////////////Helper///////////////////////////////
    //it store index

	private static int[] nsl_index(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for(int i=0;i<arr.length;i++) {
			
            while(stack.size()>0 && arr[stack.peek()]> arr[i])	stack.pop();
			res[i] = stack.size()==0 ? -1 : stack.peek();
			stack.push(i);
		}
		return res;
	}
	private static int[] nsr_index(int arr[]) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stack = new Stack();
		for(int i=arr.length-1;i>=0;i--) {
			while(stack.size()>0 && arr[stack.peek()]>arr[i])	stack.pop();
			res[i] = stack.size()==0 ? n : stack.peek();
			stack.push(i);
		}
		return res;
	}
    private static int[] ngl_index(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack();
        for(int i=0;i<arr.length;i++) {

            while(stack.size()>0 && arr[stack.peek()] < arr[i])    stack.pop();
            res[i] = stack.size()==0 ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }
    private static int[] ngr_index(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack();
        for(int i = arr.length-1; i>= 0;i--) {
            
            while(stack.size()>0 && arr[stack.peek()] < arr[i])    stack.pop();
            res[i] = stack.size()==0 ? n : stack.peek();
            
            stack.push(i);
        }
        return res;
    }

    public static long add(long a, long b) {
        int mod = (int) (1e9+7);
		return (((a % mod) + (b % mod) + mod) % mod);
	}
    public static long sub(long a, long b) {
        int mod = (int) (1e9+7);
		return (((a % mod) - (b % mod) + mod) % mod);
	}

    public static long mul(long a, long b) {
        int mod = (int) (1e9+7);
		return (((a % mod) * (b % mod) + mod) % mod);
	}
    
    private static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
	}

}
/*
 * for right side if stack is empty so res[i]=n
 * 
 * */

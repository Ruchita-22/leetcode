package stack;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int balancedParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch=='{'||ch=='('||ch=='[')   stack.push(ch);
            else{
                if(stack.size()>0 && (
                (stack.peek()=='{' && ch=='}')||
                (stack.peek()=='(' && ch==')')||
                (stack.peek()=='[' && ch==']'))
                )
                    stack.pop();
                else    return 0;    
            }
        }
        return stack.size()>0 ? 0 : 1;
    }
}

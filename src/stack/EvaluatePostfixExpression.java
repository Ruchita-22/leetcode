package stack;

import java.util.Stack;

public class EvaluatePostfixExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int evaluateExpression(String[] A) {
        Stack<Integer> stack = new Stack();
        for(String s : A){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                if(s.equals("+")){
                    a = a+b;
                }
                else if(s.equals("-")){
                    a = a-b;
                }
                else if(s.equals("*")){
                    a = a*b;
                }
                else if(s.equals("/")){
                    a = a/b;
                }
                stack.push(a);
            }
            else{
                int a = Integer.parseInt(s);
                stack.push(a);
            }
        }
        return stack.pop();

    }

}

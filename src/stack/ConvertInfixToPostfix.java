package stack;

import java.util.HashMap;
import java.util.Stack;

public class ConvertInfixToPostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String infixToPostfix(String str) {
        //Map for priority
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('^',3);
        map.put('/',2);
        map.put('*',2);
        map.put('+',1);
        map.put('-',1);

        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        for(char c : str.toCharArray()){

            if(c>='a' && c<='z')   res=res.append(c);
            else if(stack.size()==0 || c=='(' || stack.peek()=='(') stack.push(c);
            else if(c==')'){
                while(stack.size()>0 && stack.peek()!='(')
                    res = res.append(stack.pop());
                stack.pop();    
            }
            else if(stack.size()>0 && stack.peek()!='(' && (map.get(stack.peek())>= map.get(c)) ){
                while( stack.size()>0 && stack.peek()!='(' && ( map.get(stack.peek())>= map.get(c)) ){
                    res = res.append(stack.pop());
                }
                    
                stack.push(c);    
            }
            else stack.push(c);
            //System.out.println(c+" "+stack+" "+res);
        }
        while(stack.size()>0)   res=res.append(stack.pop());
        return res.toString();
    }

}

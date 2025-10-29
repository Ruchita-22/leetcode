package section15.design;

import java.util.Stack;

public class BrowserHistory {
	Stack<String> stack1 = new Stack();
    Stack<String> stack2 = new Stack();
    public BrowserHistory(String homepage) {
        stack1.push(homepage);
    }
    
    public void visit(String url) {
        stack2.clear();
        stack1.push(url);
    }
    
    public String back(int steps) {
        while(steps > 0 && stack1.size() > 1) {
            stack2.push(stack1.pop());
             steps--;           
        }
        return stack1.peek();
    }
    
    public String forward(int steps) {
        while(steps > 0 && stack2.size() > 0) {
            stack1.push(stack2.pop());
             steps--;           
        }
        return stack1.peek();
    }
}

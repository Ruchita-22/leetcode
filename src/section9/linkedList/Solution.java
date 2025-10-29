package section9.linkedList;

import java.util.ArrayList;
import java.util.Stack;

import section9.linkedList.ListNode;

  

public class Solution {

	//Reverse Concept 
	
	//206. Reverse Linked List by recursion
	private static ListNode reverseList1(ListNode head) {
        if(head==null)	return null;
        return reverse(head);
    }
    
	
    private static ListNode reverse(ListNode head) {
    	if(head==null||head.next==null)	return head;
    	ListNode rh = reverse(head.next);
    	head.next.next=head;
    	head.next = null;
    	return rh;
    }
    


	
	//2. Add Two Numbers
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        int n = 0;      
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1!=null || l2!=null){
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;
            n = l1_val + l2_val + carry;
            p.next = new ListNode(n%10);
            carry = n/10;
            p = p.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        if(carry!=0){
            p.next = new ListNode(carry);
            p = p.next;
        }
        return head.next;
    }
	//445. Add Two Numbers II
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null)    return null;
        if(l1 == null && l2 != null)    return l2;
        if(l1 != null && l2 == null)    return l1;
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> output = new Stack<>();
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null){
            stack1.push(p1.val);
            p1 = p1.next;
        }
        while(p2 != null){
            stack2.push(p2.val);
            p2 = p2.next;
        }
        int carry = 0;
        int n = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int f = !stack1.isEmpty() ? stack1.pop() : 0;
            int s = !stack2.isEmpty() ? stack2.pop() : 0;
            n = f + s + carry;            
            output.push(n%10);
            carry = n/10;
        }
        if(carry!=0)
            output.push(carry);
        ListNode head = new ListNode(0);
        ListNode newNode = head;
        while(!output.isEmpty()) {
            newNode.next = new ListNode(output.pop());
            newNode = newNode.next;
        }
        return head.next;
    }


    //1019. Next Greater Node In Linked List
    public int[] nextLargerNodes(ListNode head) {
        if(head==null)  return new int[]{};
        if(head.next == null)   return new int[]{0};
        ListNode p = head;
        ArrayList<Integer> input = new ArrayList<>();
        while(p!=null){
            ListNode temp = p.next;
            int val = p.val;
            int c=0;
            while(temp!=null){
                if(temp.val> val){
                    input.add(temp.val);
                    c=1; break;
                }
                temp = temp.next;
            }
            if(c==0){
                input.add(0);
            }
            p=p.next;
        }
        //convert list into primitive type array
        int output[] = input.stream().mapToInt(Integer::intValue).toArray();
        
        //approach using stack
        // while(p!=null){
        //     input.add(p.val);
        //     p = p.next;              
        // }
        // Stack<Integer> stack = new Stack<>();
        // int output[] = new int[input.size()];
        // //output[input.size()-1] = 0;
        // //int right_max = input.get(input.size()-1);
        // for (int i = 0; i < input.size(); i++) {
        //     while(!stack.isEmpty()&& input.get(i) > input.get(stack.peek())){
        //         output[stack.pop()] = input.get(i);
        //     }
        //     stack.push(i);
        // } 
        //to replace with next greatest element
        // for (int i = input.size()-2; i >=0; i--) {
        //     if(right_max > input.get(i))
        //         output[i] = right_max;
        //     else{
        //         right_max = input.get(i);
        //         output[i] = 0;
        //     }
        // }
        return output;
        
    }
    //328. Odd Even Linked List
    //Given a singly linked list, group all odd nodes together followed by the even nodes. 
    //Please note here we are talking about the node number and not the value in the nodes.
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next==null) return head;
        ListNode tail = head;
        ListNode odd = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        ListNode even_head = tail;
         while (odd!=tail ){

            ListNode even = odd.next;
             if(even!=tail){
                odd.next = even.next;
                odd = odd.next;
                even.next = null;
                even_head.next = even;
                even_head = even_head.next;   
            }
            else{
                odd.next = even.next;
                odd = odd.next;
                even.next = null;
                even_head.next = even;
                even_head = even_head.next;
                return head;
             }
                
        }
        return head;
    }
    
    
}

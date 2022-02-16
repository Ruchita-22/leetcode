package linkedList_question;

import java.util.ArrayList;
import java.util.Stack;

  

public class Solution {
	
	//237. Delete Node in a Linked List
	public void deleteNode(ListNode node) {
	       node.val = node.next.val;
	       node.next = node.next.next;
	        
	}
	//19. Remove Nth Node From End of List
	public ListNode removeNthFromEnd(ListNode head, int n) {
	       // if(n==0) return head;
	       //  ListNode p =head;
	       //  if(head.next == null && n==1) return null;
	       //  if(n==1){
	       //      while(p.next.next!=null){
	       //          p = p.next;
	       //      }
	       //      p.next = null;
	       //      return head;
	       //  }
	       //  p =head;
	       //  int l=0;
	       //  while(p!=null){
	       //      l++;
	       //      p = p.next;
	       //  }
	       //  p = head;
	       //  int t = l-n;
	       //  if(t==0) return head.next;
	       //  while (t!=1){
	       //      p = p.next;
	       //      t--; 
	       //  }
	       //  p.next = p.next.next;
	       //  return head;
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;
	        ListNode fast = dummy;
	        ListNode slow = dummy;    
	        for(int i = 1; i<=n+1; i++){
	            fast = fast.next;
	        }
	        while(fast!=null){
	            fast = fast.next;
	            slow = slow.next;
	        }
	        slow.next = slow.next.next;
	        return dummy.next;
	        
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
	//206. Reverse Linked List
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
    //92. Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if(head==null || head.next==null)   return head;
        ListNode curr_node = head;
        ListNode prev = null;
        int i=1;
        while(i<m){
            prev = curr_node;
            curr_node = curr_node.next;
            i++;
        }
        ListNode connection = prev;
        ListNode tail = curr_node;
        
        while(i<=n){
            ListNode next_node=curr_node.next;
            curr_node.next = prev;
            prev = curr_node;
            curr_node = next_node;
            i++;
        }
        if(connection !=null)   
            connection.next = prev;
        else
            head = prev;
        tail.next = curr_node;
        return head;
    }
    //25. Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
		// check if linked list is empty or reverse every element
		if(head==null || k == 1)   return head;
		ListNode x = new ListNode(0);
		x.next = head;
		ListNode curr_node = head;
		ListNode prev = x;
		while(curr_node!=null) {
			ListNode temp = hasNode(curr_node,k);
			if(temp!=null) {
				ListNode next_start = temp.next;
				temp.next = null;
				ListNode temp_head = reverse(curr_node,prev);
				if(x.next == head) {
					x.next = temp_head;
				}
				else {
					prev.next = temp_head;
				}
				prev = curr_node;
				curr_node.next = next_start;
				curr_node = next_start;
			}
			else {
				curr_node = curr_node.next;
			}
		}
		return x.next;
		
	}
	public static ListNode reverse(ListNode curr_node, ListNode prev) {
		while(curr_node!=null) {
			ListNode next_node = curr_node.next;
			curr_node.next = prev;
			prev = curr_node;
			curr_node = next_node;
		}
		return prev;		
	}
	public static ListNode hasNode(ListNode curr_node , int k) {
		//checking if sufficient node exist to reverse
		ListNode temp = curr_node;
		while(k>1 && temp!=null) {
			k--;
			temp = temp.next;
		}
		return temp;
	}

    //141. Linked List Cycle
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow && fast!=null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast==slow){
            return true;
        }
        else 
            return false; 
    }
    
    //21. Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode m = head;
        if(a==null)
            return b;
        else if(b==null)
            return a;
        
        if(a.val==b.val || a.val < b.val){
            m.next = new ListNode();
            m = m.next;
            m.val = a.val;
            a = a.next;
        }
        else if(a.val > b.val){
            m.next = new ListNode();
            m = m.next;
            m.val = b.val;
            b = b.next;
        }
        while (a!=null && b!=null){
                m.next = new ListNode();
                m = m.next;
                if(a.val > b.val){
                    m.val = b.val;
                    b = b.next;  
                }
                else if(a.val==b.val || a.val<b.val){
                    m.val = a.val;
                    a = a.next;
                }          
        }
        if(a==null && b!=null || a!=null && b==null){
            while(b!=null){
                 m.next = new ListNode();
                 m = m.next;
                 m.val = b.val;
                 b = b.next;
            }
             while(a!=null){
                m.next = new ListNode();
                m = m.next;
                m.val = a.val;
                a = a.next;
            }
        }

        head = head.next;
        return head;
    }
    //160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        int la = 0;
        int lb = 0;
        
        while(a != null){
            a = a.next;
            la++;
        }
        while(b != null){
            b = b.next;
            lb++;
        }
        a=headA;
        b=headB;
        
        if(la>lb){
            int d =la-lb;
            while(d!=0){
                a=a.next;
                d--;
            }
        }
        else {
            int d =lb-la;
            while(d!=0){
                b=b.next;
                d--;
            }
        }
        while(a!=b && a!=null && b!=null){
            a=a.next;
            b = b.next;
        }
        if(a==b)
            return a;
        else 
            return null;
    }
    //876. Middle of the Linked List
    public ListNode middleNode(ListNode head) {
        ListNode a_pointer = head;
        ListNode b_pointer = head;
        while(b_pointer!=null && b_pointer.next != null){
            a_pointer = a_pointer.next;
            b_pointer = b_pointer.next.next;
        }
        return a_pointer;
    }
    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null){
            if(fast.val == slow.val){
                slow.next = fast.next;
                fast.next = null;
                fast = slow.next;
            }
            else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return head;
    }
    //82. Remove Duplicates from Sorted List II
    //Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null || head.next==null) return head;
        if(head.val != head.next.val) {
            head.next = deleteDuplicates1(head.next);
            return head;
        } 
        ListNode p = head;
        while(p!=null && p.val == head.val){
            p = p.next;
        }
        return deleteDuplicates1(p);  
    }
    //148. Sort List
    public ListNode sortList(ListNode head) {
        //head=null;
        if(head == null || head.next == null)   return head;
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
           
        }
        temp.next = null;
        
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(slow);
        return merge(leftList,rightList);  
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode sorted = new ListNode(0);
        ListNode p =sorted; 
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null && l2==null){
            p.next = l1;
            l1 = l1.next;
        }
        if(l1==null && l2!=null){
            p.next = l2;
            l2 = l2.next;
        }
        return sorted.next;
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

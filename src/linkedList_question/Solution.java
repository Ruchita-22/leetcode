package linkedList_question;

public class Solution {
	
	//237. Delete Node in a Linked List
	public void deleteNode(ListNode node) {
	       node.val = node.next.val;
	       node.next = node.next.next;
	        
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
        ListNode p = head;
        ListNode prev = null;
        int i=1;
        while(i<m){
            prev =p;
            p = p.next;
            i++;
        }
        ListNode connection = prev;
        ListNode tail = p;
        while(i<=n){
            ListNode nextNode=p.next;
            p.next = prev;
            prev = p;
            p = nextNode;
            i++;
        }
        if(connection !=null)   
            connection.next = prev;
        else
            head = prev;
        tail.next = p;
        return head;
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
    //83. Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
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
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null || head.next==null) return head;
        if(head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } 
        ListNode p = head;
        while(p!=null && p.val == head.val){
            p = p.next;
        }
        return deleteDuplicates(p);
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
    
}

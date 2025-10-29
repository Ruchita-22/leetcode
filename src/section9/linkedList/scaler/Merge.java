package section9.linkedList.scaler;

public class Merge {
	//21. Merge Two Sorted Lists
	public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null)   return head2;
        if(head2 == null)   return head1;
        
        ListNode head = new ListNode(0);
        ListNode l1 = head1, l2 = head2, curr = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
            curr.next = null;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
        
        return head.next; 
    }
	
	//23. Merge k Sorted Lists
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null; 
        if(lists.length == 1)   return lists[0];
        
        ListNode head = lists[0];
        for(int i = 1; i < lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
	
	//1669. Merge In Between Linked Lists
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list2 == null)   return list1;
        
        ListNode curr = list1;
        ListNode start = null, end = null;
        int idx = 1;
        
        while(curr != null) {
            if(idx == a) start = curr;
            if(idx == b+1) {
                end = curr;
                break;
            }     
            idx++;   
            curr = curr.next;
        }
        
        start.next = list2;
        curr = list2;
        
        while(curr.next != null) {
            curr = curr.next;
        }
        
        curr.next = end.next;
        return list1;
        
    }
	
	//86. Partition List
	public ListNode partition(ListNode head, int x) {
        if(head == null)    return null;
        
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode curr = head, l1 = head1, l2 = head2;
        
        while(curr != null) {
            if(curr.val < x) {
                l1.next = curr;
                curr = curr.next;
                l1 = l1.next;
                l1.next = null;
            } else {
                l2.next = curr;
                curr = curr.next;
                l2 = l2.next;
                l2.next = null;
            }
        }
        l1.next = head2.next;
        return head1.next;
        
    }
	//61. Rotate List
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)   return head;
        
        int len = 0;
        ListNode curr = head, tail = head;
        
        while(curr !=  null) {
            len++;
            tail = curr;
            curr = curr.next;
        }
        
        if(len <= k) k = k % len;
        if(k == 0)  return head;
        
        int startIndex = len-k+1;
        int idx = 1;
        curr = head;
        
        while(curr != null && idx < startIndex - 1){
            curr = curr.next;
            idx++;
        }
        
        ListNode head2 = curr.next;
        curr.next = null;
        tail.next = head;
        return head2;
    }

}

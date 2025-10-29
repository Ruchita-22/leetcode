package section9.linkedList.scaler;

import java.util.List;

public class Advance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode p = head;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(5);
		p = p.next;
		p.next = new ListNode(8);
		p = p.next;
		print(head);
		print(insertInSortedLL(head, 0));
		

	}
	private static ListNode insertInSortedLL(ListNode head, int x) {
		ListNode temp = new ListNode(x);
		
		// 0 node
		if (head == null) 	return head = temp;
		
		// 1 node
		if (head.next == null) { 
			if (head.val < x)
				head.next = temp;
			else {
				temp.next = head;
				head = temp;
			}
			return head;
		}
		
		ListNode curr = head, prev = null;
		while (curr != null && curr.val < x) {
			prev = curr;
			curr = curr.next;
		}

		temp.next = curr;
		if (prev != null)
			prev.next = temp;
		else {
			head = temp;
		}
		return head;
		
	}
	private static void print(ListNode head) {
		ListNode p = head;
		while(p !=  null) {
			System.out.print(p.val+"-->");
			p=p.next;
		}
		System.out.println();
	}

}

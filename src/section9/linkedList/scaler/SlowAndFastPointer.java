package section9.linkedList.scaler;

import section9.linkedList.scaler.ListNode;

public class SlowAndFastPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Slow and fast pointer
	// slow s
	// fast f

	// 876. Middle of the Linked List
	private static ListNode middleNode(ListNode head) {

		if (head == null || head.next == null)
			return head;
		ListNode s = head, f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		
		return s;
		

	}

	// 2095. Delete the Middle Node of a Linked List
	private static ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode s = head, f = head, p = head;
		while (f != null && f.next != null) {
			p = s;
			s = s.next;
			f = f.next.next;
		}
		p.next = s.next;
		s.next = null;
		return head;

	}

	// 141. Linked List Cycle
	private static boolean hasCycle(ListNode head) {

		if (head == null || head.next != null)
			return false;

		ListNode s = head, f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if (s == f)
				return true;
		}

		return false;
	}

	// 142. Linked List Cycle II
	private static ListNode detectCycleStart(ListNode head) {

		if (head == null || head.next == null)
			return null;

		ListNode s = head, f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if (s == f) break;
		}
		if(f == null || f.next == null) return null;
		s = head;
		while(s != f) {
			s = s.next;
			f = f.next;
		}

		return s;
	}

	// Find Middle Node
	public int middleNode1(ListNode head) {

		ListNode s = head, f = head;

		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s.val;
	}

	// Delete Middle Node
	public ListNode deleteMiddleNode(ListNode head) {

		if (head == null)
			return null; // 0 node
		if (head.next == null)
			return null; // 1 node
		if (head.next.next == null) { // 2 node
			head.next = null;
			return head;
		}
		// 3 or more node
		ListNode f = head, s = head;

		while (f != null && f.next != null) { // check one degree less
			s = s.next;
			f = f.next.next;
		}
		s.val = s.next.val;
		s.next = s.next.next;
		return head;
	}

	// Detect starting of the cycle
	public ListNode detectStartingOfCycle(ListNode head) {
		if (head == null)
			return null;

		ListNode s = head, f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
			if (s == f)
				break;
		}

		if (f == null || f.next == null)
			return null;

		s = head;
		while (s != f) {
			s = s.next;
			f = f.next;
		}
		return s;
	}

	//////////////////// Helper Function////////////
	private static void print(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + "-->");
			p = p.next;
		}
		System.out.println();
	}
}

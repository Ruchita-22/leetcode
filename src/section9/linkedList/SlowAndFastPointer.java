package section9.linkedList;

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
		while (f != null && f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
		}
		if (f.next == null)
			return s;
		else
			return s.next;

	}

	// 2095. Delete the Middle Node of a Linked List
	private static ListNode deleteMiddle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode s = head, f = head, p = head;
		while (f != null && f.next != null && f.next.next != null) {
			p = s;
			s = s.next;
			f = f.next.next;
		}
		if (f.next == null) {
		} else {
			p = s;
			s = s.next;
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
		while (f != null && f.next != null && f.next.next != null) {
			s = s.next;
			f = f.next.next;
			if (s == f) {
				s = head;
				while (s != f) {
					s = s.next;
					f = f.next;
				}
				return s;
			}
		}

		return null;
	}

	private static boolean isPalindrome(ListNode head) {
		ListNode s = head, f = head;
		while (f.next != null && f.next.next == null) {
			s = s.next;
			f = f.next.next;
		}
		s.next = reverseList(s.next);
		ListNode start = head, mid = s.next;
		while (mid != null) {
			if (start.val != mid.val)
				return false;
			start = start.next;
			mid = mid.next;
		}
		s.next = reverseList(s.next);

		return true;
	}
	private static ListNode reverseList(ListNode head) {
        if(head==null)	return null;
        ListNode p=null,c=head,n=head.next;
        while(c!=null) {
        	c.next=p;
        	p=c;
        	c=n;
        	if(n!=null)
        		n=n.next;
        }
        return p;
    }

	

}

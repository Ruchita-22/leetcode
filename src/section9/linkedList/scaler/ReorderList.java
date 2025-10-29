package section9.linkedList.scaler;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode reorderList(ListNode head) {
        //for node 0 and node 1
		if (head == null || head.next == null)	return head;

		// finding the middle element
		ListNode s = head, f = head;
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		// divide in 2 list
		ListNode head2 = s.next;
		s.next = null;
		// reverse list 2
		head2 = reverse(head2);

        //now merge two list in zig zag
        head = mergeZigZag(head,head2);
        return head;
    }
    
	private static ListNode reverse(ListNode head) {
		if (head == null)	return null;

		ListNode prev = null, curr = head, np = head;

		while (curr != null) {
            np = curr.next;
            curr.next=prev;
            prev=curr;
            curr=np;
        }
        return prev;

    }
    private static ListNode mergeZigZag(ListNode head1, ListNode head2){
        ListNode l1 = head1;
        ListNode l2 = head2;
		while (l1 != null && l2 != null) {
			ListNode np1 = l1.next;
			ListNode np2 = l2.next;
			l1.next = l2;
			l2.next = np1;
			l1 = np1;
			l2 = np2;
        }
        return head1;
    }

}

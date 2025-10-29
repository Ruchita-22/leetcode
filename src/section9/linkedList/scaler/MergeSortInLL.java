package section9.linkedList.scaler;

public class MergeSortInLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//////////////////////////////Merge Sort////////////////////////
	public ListNode sortList(ListNode head) {
        head = mergeSort(head);
        return head;
    }
    private static ListNode mergeSort(ListNode head){
		if (head == null || head.next == null)   return head;

        ListNode m = findMiddle(head);

        ListNode l1 = head;
        ListNode l2 = m.next;

		m.next = null;
		l1 = mergeSort(l1);
		l2 = mergeSort(l2);
		return mergeTwoLists(l1, l2);
    }
    private static ListNode findMiddle(ListNode head){
		ListNode s = head, f = head, prev = null;
		while (f != null && f.next != null) {
			prev = s;
			s = s.next;
			f = f.next.next;
		}
		return prev;
    }
    private static ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode p1 = A, p2 = B;
		
		ListNode head = new ListNode(0), curr = head;
		
		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				curr.next = p1;
				p1 = p1.next;
			} else {
				curr.next = p2;
				p2 = p2.next;
			}
			curr = curr.next;
		}
		if (p1 != null) {
			curr.next = p1;
		}
		if (p2 != null) {
			curr.next = p2;
		}
		return head.next;

    }

}

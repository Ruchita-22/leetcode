package section9.linkedList.scaler;

public class PalindromeInLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int lPalin(ListNode head) {
        // node 0 and 1
		if (head == null || head.next == null)   return 1;

        int len = findLength(head);
        
        ListNode p = head;
		int k = 1;
		while (p != null && k < len / 2) {
			p = p.next;
			k++;
		}
		if (len % 2 == 0) {
			p.next = reverse(p.next);
			p = p.next;
		} else {
			p.next.next = reverse(p.next.next);
			p = p.next.next;
		}

		ListNode p1 = head, p2 = p;
		while (p2 != null) {
			if (p1.val != p2.val)		return 0;
			p1 = p1.next;
			p2 = p2.next;
		}
		return 1;
    }
    
    
    public int solve(ListNode head) {
		if (head == null)	return 0;
		if (head.next == null)	return 1;

		int count = 1;
		ListNode prev = null, np = null, curr = head;

		while (curr != null) {
			np = curr.next;
			curr.next = prev;
			count = Math.max(count, 2 * expand(prev, np) + 1);
			count = Math.max(count, 2 * expand(curr, np));
			prev = curr;
			curr = np;
		}
		return count;

    }
    private static int expand(ListNode a, ListNode b){
		int count = 0;
		while (a != null && b != null) {
			if (a.val == b.val)		count++;
			else 	break;
			a = a.next;
			b = b.next;
        }
        return count;
    }
    //////////////////Helper function/////////////////////
    
    private static int findLength(ListNode head){
		ListNode p = head;
		int k = 0;
		while (p != null) {
			k++;
			p = p.next;
		}
		return k;
    }
    private static ListNode reverse(ListNode head){
		ListNode prev = null, curr = head, np = head;
		while (curr != null) {
			np = curr.next;
			curr.next = prev;
			prev = curr;
			curr = np;
		}
		return prev;
    }

}

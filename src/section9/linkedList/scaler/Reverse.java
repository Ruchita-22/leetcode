package section9.linkedList.scaler;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseList(ListNode head) {
		// node 0 and 1
		if (head == null || head.next == null)		return head;

		ListNode prev = null, curr = head, np = head;
		// node 2 and 3
		while (curr != null) {
			np = curr.next;
			curr.next = prev;
			prev = curr;
			curr = np;
		}
		return prev;
	}
	public ListNode reverseBetween(ListNode head, int B, int C) {
		if (B == C)		return head; // 0 node
		
		int pos = 1;
		ListNode prev = null, curr = head;
		while (curr != null && pos < B) {
			prev = curr;
			curr = curr.next;
			pos++;
		}
		ListNode connection = prev, tail = curr;

		ListNode np = curr;
		while (curr != null && pos <= C) {
			np = curr.next;
			curr.next = prev;
			prev = curr;
			curr = np;
			pos++;
		}

		if (connection != null) 	connection.next = prev;
		else 	head = prev;
		
		tail.next = curr;
		return head;

	}
	// reverse in group of k
	public ListNode reverseKGroup(ListNode head, int B) {
        if(head == null || head.next == null || B < 2 || !hasSufficientNode(head, B))
            return head;
        
        int k = B;
        ListNode prev = null, curr = head, np = head;
        
        while(curr != null && k > 0) {
            np = curr.next;
            curr.next = prev;
            prev = curr;
            curr = np;
            k--;
            
        }
        head.next = reverseKGroup(curr, B);
        return prev;
    }
    
    public boolean hasSufficientNode(ListNode head, int B) {
        ListNode curr = head;
        int len = 0;
        while(curr != null && len < B){
            len++;
            curr = curr.next;
        }
        return len == B;
    }

}

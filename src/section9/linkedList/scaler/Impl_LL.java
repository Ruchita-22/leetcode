package section9.linkedList.scaler;

public class Impl_LL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    private static int size=0;
    static ListNode head=null;

    public static void insert_node(int pos, int val) {
        ListNode temp = new ListNode(val);
        
		if (pos >= 1 && pos <= size + 1) {

			if (pos == 1 && size == 0)   head = temp;  		// insert in empty LL
			else if (pos == 1) {							// insert in the beginning of LL
				temp.next = head;
				head = temp;
			} else {
				ListNode p = head;
				int k = 1;
				while (p != null && k < pos - 1) {
					p = p.next;
					k++;
				}
				temp.next = p.next;
				p.next = temp;
            }
            size++;
        }
    }

    public static void delete_node(int pos) {
        
		if (pos >= 1 && pos <= size) {
			if (pos == 1)	head = head.next;
			else {
				int k = 1;
				ListNode p = head;
				while (k < pos - 1) {
					p = p.next;
					k++;
				}
				p.next = (k == size - 1) ? null : p.next.next;
			}
			size--;
        }
    }

    public static void print_ll() {
        ListNode p = head;
		while (p.next != null) {
			System.out.print(p.val + " ");
			p = p.next;
        }
        System.out.print(p.val);
    }
    //////////////////////////
    
    static int len = 0;

	public ListNode solve(int[][] arr) {

		ListNode head = null;
		len = 0;

		for (int i = 0; i < arr.length; i++) {
			int op = arr[i][0];
			int data = arr[i][1];
			if (op == 0) { // insert at head
				head = insert(head, 0, data);
				len++;
			} else if (op == 1) { // insert at last
				head = insert(head, len, data);
				len++;
			} else if (op == 2) { // insert at pos
				head = insert(head, arr[i][2], data);
				len++;
			} else if (op == 3) { // delete from pos
				head = delete(head, arr[i][1]);
			}
		}
		return head;
	}

	private static ListNode insert(ListNode head, int pos, int data) {

		ListNode node = new ListNode(data);
		int index = 0;
		ListNode p = head;
		if (pos == 0) { // insert at head
			if (head == null) { // insert into empty LL
				head = node;
			} else { // insert into non empty LL and at first pos
				node.next = head;
				head = node;
			}
		} else { // insert at pos
			while (index < (pos - 1) && p != null) {
				p = p.next;
				index++;
			}
			node.next = p.next;
			p.next = node;

		}
		return head;

	}

	private static ListNode delete(ListNode head, int pos) {

		int index = 0;
		ListNode p = head;
		if (pos + 1 > len) // no delete
			return head;
		if (pos == 0) {
			if (len == 1) // delete last node
				head = null;
			else
				head = head.next; // delete first node
		} else {
			while (index < (pos - 1)) { // delete from pos
				p = p.next;
				index++;
			}
			p.next = p.next.next;
		}
		len--;
		return head;
	}
}

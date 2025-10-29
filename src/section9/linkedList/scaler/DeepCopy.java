package section9.linkedList.scaler;

import java.util.HashMap;

public class DeepCopy {
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
	public Node copyRandomList(Node head) {
	       
        Node curr = head;
        HashMap<Node, Node> map = new HashMap();
        // old node, new node mapping 
        // make link with new node
        while(curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
       
        Node newHead = map.get(head);
        curr = head;
        
        while(curr != null) {
            Node  oldNode = curr;
            Node  newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return newHead;
        
    }

}

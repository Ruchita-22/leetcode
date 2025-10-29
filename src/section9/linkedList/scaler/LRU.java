package section9.linkedList.scaler;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	Node head = new Node(0, 0);
	Node tail = new Node(0, 0);
	Map<Integer, Node> map = new HashMap<>();
	int capacity;

	public LRU(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
       
    }

	

	public int get(int key) {
		if(!map.containsKey(key))	return -1;   // miss
		
		Node node = map.get(key);
		remove(node);
		insertToTail(node);
		return node.value;
		
	}

	public void set(int key, int value) {
		// hit
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			insertToTail(new Node(key, value));
		} else { // miss
			if (map.size() == capacity) {	// cache is full or not 
				map.remove(head.next);
				remove(head.next);
			}
			Node node = new Node(key, value);
			insertToTail(node);
			map.put(key, node);
		}
    }
	//////////Helper Function///////////
	
		public void insertToTail(Node node) {			// add node to tail
			map.put(node.key, node);				// put in map
	
			node.next = tail;						// add node to tail
			node.prev = tail.prev;
			tail.prev = node;
			node.prev.next = node;
	
		}
	
		public void remove(Node node) {			// remove from head
			map.remove(node.key);
	
			node.prev.next = node.next;
			node.next.prev = node.prev;
	
		}
}

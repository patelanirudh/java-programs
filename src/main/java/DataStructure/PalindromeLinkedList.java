package DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeLinkedList {
	Node head = null;
	
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}// inner class
	
	public void setHead(Node head) {
		this.head = head;
	}
	
	// insert at beginning
	public void insertNode(int data) {
		Node node = new Node(data);
		if (null == head) {
			head = node;
			return;
		}
		// else
		node.next = head;
		head = node;
	}
	
	public void displayList() {
		Node cur = head;
		while (cur != null) {
			System.out.printf(cur.data + " ");
			cur = cur.next;
		}
	}
	
	public void recursiveDisplay(Node node) {
		if (node == null)
			return;
		
		recursiveDisplay(node.next);
		System.out.printf(node.data + " ");
	}
	
	// Overloaded Method
	public void recursiveDisplay() {
		this.recursiveDisplay(head);
	}
	
	public void iterativeReverse() {
		Node p1 = head;
		Node prev = null, ahead = null;
		while(p1 != null) {
			ahead = p1.next;
			p1.next = prev;
			prev = p1;
			p1 = ahead;
		}
		this.head = prev;
	}
	
	
	public Node reverseLinkedList(Node node, Node prev) {
		if (null == node)
			return null;
		
		reverseLinkedList(node.next, node);
		if (node.next == null) {
			// set last node as the head on this object so we can traverse it 
			this.head = node;
		}
		node.next = prev;
		return prev;
	}
	
	/*
	 * Not Efficient as it takes extra space O(N) plus
	 * matches by traversing all nodes. Ideally it should
	 * stop in the middle
	 */
	public boolean isPalindromeStack() {
		Deque<Node> dq = new ArrayDeque<>();
		Node cur = this.head;
		// pushed onto stack
		while (cur != null) {
			dq.push(cur);
			cur = cur.next;
		}
		
		// Map cur data and stack data(LIFO) reverse 
		cur = this.head;
		while(cur != null && !dq.isEmpty()) {
			int no = dq.peek().data;
			System.out.println("cur.data " + cur.data + ", dq.peek() " + no);
			if (cur.data != no)
				return false;
			
			// move to next node
			cur = cur.next;
			// remove elements from stack
			dq.pop(); 
		}
		// all checked it is a palindrome		
		return true;
	}
	
	public boolean isPalindromeSlowFast() {
		
		Node slow = this.head;
		Node fast = this.head;
		// 
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Reverse. We start with slow.next
		Node prev = null, ahead = null;
		Node p1 = slow.next;
		while (p1 != null) {
			ahead = p1.next;
			p1.next = prev;
			prev = p1;
			p1 = ahead;
		}
		// Set the new head of the reversed linked list
		Node newHead = prev;
		// Set cur to old head
		Node cur = this.head;
		// Map cur data and newHead reversed list data.
		// We do not check till middle node for odd nodes linked list (as it will be a test with itself)
		// For even nodes linked list all nodes data are checked
		while(newHead != null) {
			System.out.println("cur.data " + cur.data + ", newHead.data " + newHead.data);
			if (cur.data != newHead.data)
				return false;
			
			// both move to next nodes
			cur = cur.next;
			newHead = newHead.next; 
		}
		// all checked it is a palindrome		
		return true;
	}
	
	public void reverseLinkedList() {
		// send prev as null
		// this will return prev as new head of new Linked List
		// Deep Copy
		reverseLinkedList(this.head, null);
	}
	
	public Node createReverseLinkedList(Node node, Node prev) {
		if (null == node)
			return null;
		
		reverseLinkedList(node.next, node);
		Node newNode = new Node(node.data);
		if (node.next == null) {
			// set last node as the head on this object so we can traverse it 
			this.head = newNode;
		}
		newNode.next = prev;
		System.out.println(node.data + " ");
		return prev;
	}
	
	
	public static void main(String[] args) {
		PalindromeLinkedList linkedList = new PalindromeLinkedList();
		
		linkedList.insertNode(30);
		linkedList.insertNode(60);
		linkedList.insertNode(40);
		linkedList.insertNode(10);
		linkedList.insertNode(30);
		
		linkedList.displayList();
		
		// System.out.println("\nLinked List isPalindrome : " + linkedList.isPalindromeStack());
		System.out.println("\nLinked List isPalindrome : " + linkedList.isPalindromeSlowFast());
		
		// After palindrome check linked list will be corrupted as we set NULL while reversing
		// so comment Palindrome testing with testing other methods
		
//		System.out.println("\n");
//		linkedList.recursiveDisplay();
		
		System.out.println("\nIterative Reverse");
		linkedList.iterativeReverse();
		linkedList.displayList();
		
		System.out.println("\nRecursive Reverse");
		linkedList.reverseLinkedList();
		linkedList.displayList();
		
//		PalindromeLinkedList newReversedList = new PalindromeLinkedList();
//		newReversedList.createReverseLinkedList(linkedList.head, null);
//		System.out.println("\nCreated New Reversed LinkedList\n");
//		newReversedList.displayList();
		
		
//		reversedList.createNewReverseLinkedList(linkedList);
//		
//		System.out.println("\nOriginal\n");
//		linkedList.displayList();
//		System.out.println("\nReversed\n");
//		reversedList.displayList();
		
		
	}
}

package DataStructure;

public class BinarySearchTree {
	
	Node root = null;
	static int nodeHeight = -1;
	
	class Node {
		int key;
		Node left, right;
	}
	
	private Node createNode(int key) {
		Node newNode = new Node();
		newNode.key = key;
		newNode.left = newNode.right = null;
		return newNode;
	}
	
	public Node insertNode(Node node, int key) {
		if (node == null) {
			return createNode(key);
		}
		
		if (key < node.key)
			node.left = insertNode(node.left, key);
		else if (key > node.key)
			node.right = insertNode(node.right, key);
		
		return node;
	}
	
	// Gives elements in increasing order
	public void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.key + " ");
			inorder(node.right);
		}
	}
	
	public Node search(Node node, int key) {
		// Key match + Base Null Case
		if (node == null || node.key == key)
			return node;
		
		// node reference is changed from current node to node found
		if (key < node.key)
			node = search(node.left, key);
		else if (key > node.key)
			node = search(node.right, key);
		
		return node;
	}
	
	// We consider height of rooted tree as 0, thus returning -1 (-1 + 1 = 0)
	public int findHeightOfTreeAndNode(Node node, int key) {
		if (node == null)
			return -1;
		
		int lefth = findHeightOfTreeAndNode(node.left, key);
		int righth = findHeightOfTreeAndNode(node.right, key);
		int ans = Math.max(lefth, righth) + 1;
		
		// this is only for node
		if (node.key == key)
			nodeHeight = ans;
		
		// this is for whole tree
		return ans;
	}
	
	public int findDepthOfNode(Node node, int key) {
		if (node == null)
			return -1;
		
		int dist = -1;
		// first node key match condition
		if ((node.key == key) || 
			(dist = findDepthOfNode(node.left, key)) >= 0 ||
			(dist = findDepthOfNode(node.right, key)) >= 0) {
			return dist + 1;
		}
		return dist;
	}
	
	public void printLevelOrder(Node node) {
		// first get height of tree i.e node == root;
		int height = findHeightOfTreeAndNode(node, -1);
		for (int i = 0; i <= height; ++i) {
			// i == level
			// node == root
			printNodesAtGivenLevel(node, i);
		}
	}
	
	private void printNodesAtGivenLevel(Node node, int level_no) {
		if (node == null)
			return;
		
		if (level_no == 0) { 
			System.out.printf("%d ", node.key);
		}
		else {
			printNodesAtGivenLevel(node.left, level_no - 1);
			printNodesAtGivenLevel(node.right, level_no - 1);
		}
	}
	

	public static void main(String[] args) {
/*						   50				level = 0
 * 					 30			  70		level = 1
 *			     20	    40 	   60    80		level = 2
 * 			  10   25	     55  65			level = 3
 */
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insertNode(null, 50); 
		bst.insertNode(bst.root, 30);
		bst.insertNode(bst.root, 70);
		bst.insertNode(bst.root, 20);
		bst.insertNode(bst.root, 40);
		bst.insertNode(bst.root, 60);
		bst.insertNode(bst.root, 80);
		bst.insertNode(bst.root, 10);
		bst.insertNode(bst.root, 25);
		bst.insertNode(bst.root, 55);
		bst.insertNode(bst.root, 65);
		
		System.out.println("BST Inorder Traversal");
		bst.inorder(bst.root);
		
		int key = 60;
		System.out.println("Search " + key + " in BST");
		if (bst.search(bst.root, key) != null) {
			System.out.println("Node Found !!!");
		} else {
			System.out.println("Node Not Found...");
		}
		
		key = 30;
		System.out.println("Find Tree Height and Node Height for key " + key + " in BST");
		int treeHeight = bst.findHeightOfTreeAndNode(bst.root, key);
		System.out.println("Whole Tree Height = " + treeHeight + ", Node Height = " + BinarySearchTree.nodeHeight);
		
		key = 40;
		int depth = bst.findDepthOfNode(bst.root, key);
		System.out.println("Depth of Node for key " + key + " in BST is " + depth);
		
		System.out.println("Print All Level Order Nodes");
		bst.printLevelOrder(bst.root);
	}

}

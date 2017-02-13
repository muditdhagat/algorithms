package binarytree;

class Node {	 

	String item;
	Node left, right;

	Node(String item) {
		this.item = item;
		left = right = null;
	}
}


public class BinaryTree {
	
	Node root;

	public BinaryTree() {
		root = null;
	}
	
	static int index = 0;
	


void traversePreOrder(Node node) {
	
	if(node == null) return;
	
	System.out.println(node.item);
	
	traversePreOrder(node.left);
	
	traversePreOrder(node.right);
	
}

void traverseInOrder(Node node) {
	
	if(node == null) return;
	
	traverseInOrder(node.left);

	System.out.println(node.item);
	
	traverseInOrder(node.right);
	
}

void traversePostOrder(Node node) {
	
	if(node == null) return;
	
	traversePostOrder(node.left);
	
	traversePostOrder(node.right);
	
	System.out.println(node.item);
}

Node buildTreePre(String[] in, String[] pre, int inStartIndex, int inEndIndex) {
	
	if(inStartIndex > inEndIndex) {
		return null;
	}
	
	// Get the Left most or first item from the pre ( N L R ) which would give us the root node in in order
	Node node = new Node(pre[index++]);
	// Search for this in in the in Inorder and find the index 
	int index = search(in, inStartIndex, inEndIndex, node.item);
	
	node.left = buildTreePre(in, pre, inStartIndex, index - 1);
	
	node.right = buildTreePre(in, pre, index + 1, inEndIndex);
	
	return node;
}

Node buildTreePost(String[] in, String[] post, int inStartIndex, int inEndIndex) {
	
	if(inStartIndex > inEndIndex) {
		return null;
	}
	
	Node node = new Node(post[index--]);
	// Search for this in in the in Inorder and find the index 
	int index = search(in, inStartIndex, inEndIndex, node.item);
	
	node.right = buildTreePost(in, post, index + 1, inEndIndex);
	
	node.left = buildTreePre(in, post, inStartIndex, index - 1);
	
	return node;
}

Node lastNode(Node root) {
	
	if(root == null) return null;
	
	if(root.left == null) {
		return root.left;
	}
	
	else if(root.right == null) {
		return root.right;
	}
	
	else return lastNode(root.left);
}


	private int search(String[] in, int inStartIndex, int inEndIndex, String item) {
	
		for(int i = inStartIndex; i<=inEndIndex; i++) {
			if(in[i] == item) return i;
		}
		
	return 0;
}

	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		bt.root = new Node("A");
		bt.root.left = new Node("B");
		bt.root.right = new Node("C");
		bt.root.left.left = new Node("D");
		bt.root.left.right = new Node("E");
		bt.root.right.left = new Node("F");
		bt.root.right.right = new Node("G");
		
//		bt.traverseInOrder(bt.root);
		
		bt.index = 0;
		String[] in = new String[] {"B", "B", "C", "A", "A", "D", "B"};
		String[] pre = new String[] {"A", "B", "B", "C", "D", "A", "B"};
		
		Node rootNode = bt.buildTreePre(in, pre, 0, in.length - 1);
		
		bt.traverseInOrder(rootNode);
		
		

	}

}

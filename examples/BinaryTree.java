import java.util.Queue;
import java.util.LinkedList; 

public class BinaryTree<T> {

	// reference tree: https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/pix/tree1.bmp

	// TODO: add funciton as argument, so can do whatever and traverse tree?

	public static void main(String[] args) {

		// left subtree
		Node<Integer> two = new Node<Integer>(2, null, null);
		Node<Integer> twelve = new Node<Integer>(12, two, null);
		Node<Integer> one = new Node<Integer>(1, null, null);
		Node<Integer> seven = new Node<Integer>(7, one, twelve);
		Node<Integer> nine = new Node<Integer>(9, null, null);
		Node<Integer> five = new Node<Integer>(5, nine, seven);

		// right subtree
		Node<Integer> three = new Node<Integer>(3, null, null);
		Node<Integer> eleven = new Node<Integer>(11, three, null);
		Node<Integer> four = new Node<Integer>(4, null, eleven);

		// root
		Node<Integer> eight = new Node<Integer>(8, five, four);

		BinaryTree<Integer> tree = new BinaryTree<Integer>(eight);

		tree.printPreOrder(); // should print 8, 5, 9, 7, 1, 12, 2, 4, 11, 3
		tree.printInOrder(); // should print 9, 5, 1, 7, 2, 12, 8, 4, 3, 11
		tree.printPostOrder(); // should print 9, 1, 2, 12, 7, 5, 3, 11, 4, 8
		tree.printBreadthFirst(); // should print 8, 5, 4, 9, 7, 11, 1, 12, 3, 2
		System.out.println("tree.isBalanced(): " + tree.isBalanced());

		// empty tree
		BinaryTree<Integer> emptyTree = new BinaryTree<Integer>(null);
		System.out.println("emptyTree.isBalanced(): " + emptyTree.isBalanced());

		// perfect tree
		BinaryTree<Integer> perfectTree = new BinaryTree<Integer>(
			new Node<Integer>(2, one, three)
			);
		System.out.println("perfectTree.isBalanced(): " + perfectTree.isBalanced());
	}

	Node root;
	public BinaryTree(Node root) {
		this.root = root;
	}

	public void printBreadthFirst() {
		breadthFirstTraverse((node) -> System.out.print(node.data + ", "));
		System.out.println();
	}

	// TODO: review
	public void breadthFirstTraverse(NodeFunc nodeFunc) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (queue.peek() != null) {

			Node node = queue.remove();

			if (node == null) {
				continue;
			}
			
			nodeFunc.operate(node);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}


	public void printPreOrder() {
		printPreOrder(root);
		System.out.println();
	}

	// preorder: parent -> left children -> right children
	public void printPreOrder(Node node) {
		
		if (node == null) {
			return;
		}

		// process current node
		System.out.print(node.data + ", ");
		// process left child
		printPreOrder(node.left);
		// process right child
		printPreOrder(node.right);
	}

	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}

	// inorder: left children -> parent -> right children
	public void printInOrder(Node node) {

		if (node == null) {
			return;
		}

		// process left child
		printInOrder(node.left);
		// process current node
		System.out.print(node.data + ", ");
		// process right child
		printInOrder(node.right);
	}

	public void printPostOrder() {
		printPostOrder(root);
		System.out.println();
	}

	// postorder: left children -> right children -> parent
	public void printPostOrder(Node node) {

		if (node == null) {
			return;
		}

		// process left child
		printPostOrder(node.left);
		// process right child
		printPostOrder(node.right);
		// process current node
		System.out.print(node.data + ", ");
	}

	public boolean isBalanced() {
		return isBalanced(this.root);
	}

	public boolean isBalanced(Node node) {

		if (node == null) {
			return true;
		}

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return false;
		}

		return isBalanced(node.left) && isBalanced(node.right);
	}

	public int getHeight(Node node) {
		return getHeight(node, 0);
	}

	public int getHeight(Node node, int height) {

		if (node == null) {
			return height;
		}

		height++;
		int leftHeight = getHeight(node.left, height);
		int rightHeight = getHeight(node.right, height);

		return Math.max(leftHeight, rightHeight);
	}
}

interface NodeFunc {
	void operate(Node node);
	// NOTE: this should probably be an optional
	// Object operateAndReturn(Node node);
}

class Node<T> {
	T data;
	Node left, right;

	public Node(T data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
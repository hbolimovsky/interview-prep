import java.util.LinkedList;

// answers: https://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
// TODO: fix Comparable so more inclusive
public class BinarySearchTree <T extends Comparable<T>> {

	public static void main(String[] args) {
		// System.out.println("Hello world!");

		// Node two = new Node(2, null, null);

		// BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(two);
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		// bst.insert(2);
		// bst.insert(1);
		// bst.insert(3);
		// bst.insert(0);
		// bst.insert(4);

		bst.buildNonBST(7, 1, 2);
		bst.printInOrder();
		// System.out.println(bst.contains(3));
		// System.out.println(bst.findMin());
		// LinkedList<Integer> bstToLL = bst.bstToLL();
		// for (Integer i : bstToLL) {
		// 	System.out.print(i + ", ");
		// }
		System.out.println(bst.isBSTHackey());
	}

	private class Node {
		T data;
		Node left, right;

		public Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(Node root) {
		this.root = root;
	}

	public void buildNonBST(T _seven, T _one, T _two) {
		Node seven = new Node(_seven, null, null);
		Node one = new Node(_one, null, seven);
		this.root  = new Node(_two, one, null);
	}

	// source: https://algs4.cs.princeton.edu/32bst/BST.java.html
	// TOOD: i dont think this works...
	public boolean isBST() {
		return isBST(root, null, null);
	}

	private boolean isBST(Node node, T min, T max) {

		if (node == null) {
			return true;
		}

		if (min != null && node.data.compareTo(min) < 0) {
			return false;
		}

		if (max != null && node.data.compareTo(max) > 0) {
			return false;
		}

		return isBST(node.left, min, node.data) && isBST(node.right, max, node.data);
	}

	public boolean isBSTHackey() {
		if (root == null) {
			throw new IndexOutOfBoundsException();
		}

		// LinkedList<T> nodes = new LinkedList<T>();
		// nodes.addFirst(Integer.MIN_VALUE);
		// return isBST(nodes, root);
		return isBSTHackey(new LinkedList<T>(), root);
	}

	public boolean isBSTHackey(LinkedList<T> nodes, Node current) {
		// // left node
		// if (current.left == null && current.right == null) {
		// 	T last = nodes.peekLast();
		// 	// assume no duplicates
		// 	if (last.data.compareTo(current.data) > 0) {
		// 		return false;
		// 	}
		// 	nodes.addLast(current);
		// 	return true;
		// }
		// if (current.left != null && current.right == null) {

		// }

		if (current == null) {
			return true;
		}

		if (!bstCheck(nodes, current)) {
			return false;
		}

		// return isBSTHackey(nodes, current.left) && bstCheck(nodes, current) && isBSTHackey(nodes, current.right);
		return isBSTHackey(nodes, current.left) && isBSTHackey(nodes, current.right);
	}

	private boolean bstCheck(LinkedList<T> nodes, Node current) {
		T last = nodes.peekLast();
		if (nodes.size() > 0) {
			// assume no duplicates
			if (last.compareTo(current.data) > 0) {
				return false;
			}
		}
		nodes.addLast(current.data);
		return true;
	}

	// public LinkedList<T> bstToLL() {
	// 	LinkedList<T> nodes = new LinkedList<T>();
	// 	bstToLL(nodes, root);
	// 	return nodes;
	// }

	// public void bstToLL(LinkedList<T> nodes, Node node) {

	// 	if (node == null) {
	// 		return;
	// 	}

	// 	bstToLL(nodes, node.left);
	// 	nodes.addLast(node.data);
	// 	bstToLL(nodes, node.right);
	// }

	// public boolean isBinarySearchTree() {
	// 	LinkedList<Node> nodes = new LinkedList<Node>();
	// 	nodes.addFirst(Integer.MIN_VALUE);

	// 	return isBinarySearchTree(nodes, root);
	// }

	// public void isBinarySearchTree(LinkedList<Node> nodes, Node node) {

	// 	if (node == null) {
	// 		return true;
	// 	}
		
	// 	// process
	// 	return isBinarySearchTree(nodes, node.left) && nodes.getLast().data.compareTo(node.data) < 0 && isBinarySearchTree(nodes, node.right);

	// 	nodes.addLast(node)

	// 	// right recurse

	// }



	// public boolean isBinarySearchTree(Node root) {
		
	// 	if (node == null) {
	// 		return true;
	// 	}

	// 	if (!binarySearchCheck(node)) {
	// 		return false;
	// 	}

	// 	return isBinarySearchTree(node.left) && isBinarySearchTree(node.right);
	// }

	// public boolean binarySearchCheck(Node node) {

	// 	if (node.left != null) {
	// 		// if left > parent
	// 		if (node.left.data.compareTo(node.data) > 0) {
	// 			return false;
	// 		}
	// 	}

	// 	if (node.right != null) {
	// 		// if right < parent
	// 		if (node.right.data.compareTo(node.data) < 0) {
	// 			return false
	// 		}
	// 	}

	// 	return true;
	// }

	public void insert(T data) {
		this.root = insert(root, data);
	}

	private Node insert(Node node, T data) {

		if (node == null) {
			return new Node(data, null, null);
		}

		int compare = data.compareTo(node.data);
		if (compare < 0) {
			node.left = insert(node.left, data);
		} else if (compare > 0) {
			node.right = insert(node.right, data);
		} else {
			; // duplicate-, do nothing
		}

		return node;
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

	public boolean contains(T data) {
		return contains(root, data);
	}

	public boolean contains(Node node, T data) {
		
		if (node == null) {
			return false;
		}

		int compare = data.compareTo(node.data);
		if (compare < 0) {
			return contains(node.left, data);
		} else if (compare > 0) {
			return contains(node.right, data);
		} else {
			return true;
		}
	}

	public void delete(T data) {
		// TODO
	}

	// public T fin

	// public T findMin() {

	// 	if (root == null) {
	// 		throw new IndexOutOfBoundsException();
	// 	}

	// 	Node node = root;
	// 	while (node != null) {

	// 		if (node.left == null) {
	// 			return node.data;
	// 		}

	// 		node = node.left;
	// 	}

	// 	return null;
	// }

	public T findMin() {
		if (root == null) {
			throw new IndexOutOfBoundsException();
		}
		return findMin(root);
	}

	public T findMin(Node node) {

		if (node.left == null) {
			return node.data;
		}

		return findMin(node.left);
	}

	public Node findMax() {
		// TODO
		return null;
	}

}
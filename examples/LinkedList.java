// reference: https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/code/LinkedList.java
// TODO: refactor 'AnyType' to 'T'
public class LinkedList<AnyType> {

	public static void main(String[] args) {
		LinkedList<Integer> ints = new LinkedList<Integer>();
		System.out.println(ints);
		// int position = ints.getPosition(8);
		// System.out.println("position: " + position);
		ints.addFirst(7);
		System.out.println(ints);
		// position = ints.getPosition(8);
		// System.out.println("position: " + position);
		ints.addLast(8);
		System.out.println(ints);
		// position = ints.getPosition(8);
		// System.out.println("position: " + position);
		// int intAtZero = ints.get(1);
		// System.out.println("intAtZero: " + intAtZero);
		ints.insertAfter(7, 9);
		System.out.println(ints);
	}

	private static class Node<AnyType> {

		private AnyType data;
		private Node<AnyType> next;

		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<AnyType> head;

	public LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(AnyType item) {
		head = new Node<AnyType>(item, null);
	}

	public AnyType getFirst() {

		if (head == null) {
			return null;
		}

		return head.data;
	}

	public AnyType removeFirst() {

		if (head == null) {
			return null;
		}

		AnyType temp = getFirst();
		head = head.next;
		return temp;
	}

	// TODO: implement with reference to tail
	public void addLast(AnyType item) {

		if (isEmpty()) {
			addFirst(item);
			return;
		}

		Node<AnyType> current = head;
		while (current.next != null) {
			current = current.next;
		}
		
		current.next = new Node<AnyType>(item, null);
	}

	public AnyType getLast() {

		if (isEmpty()) {
			return null;
		}

		Node<AnyType> current = head;
		while (current.next != null) {
			current = current.next;
		}

		return current.data;
	}

	public void clear() {
		head = null;
	}

	// public boolean contains(AnyType x) {

	// 	if (isEmpty) {
	// 		return false;
	// 	}

	// 	AnyType current = head;
	// 	do {
	// 		// TOOD: should this be '.equals'
	// 		if (current.data.equals(x)) {
	// 			return true;
	// 		}

	// 	} while (current.next != null) {
	// 		current = current.next;
	// 	}

	// 	return false;
	// }

 //   public int getPosition(AnyType item) {

 //   	if (isEmpty()) {
 //   		return -1;
 //   	}

	// int counter = 0;
 //  	Node<AnyType> current = head;
	// while (true) {
	// 	if (current.data.equals(item)) {
	// 		return counter;
	// 	}

	// 	if (current.next == null) {
	// 		break;
	// 	}

	// 	counter++;
	// 	current = current.next;
	// }

 //   	return -1;
 //   }

   public int getPosition(AnyType item) {

   	if (isEmpty()) {
   		return -1;
   	}

   	Node<AnyType> node = head;
   	int position = 0;

   	return getPositionInner(node, position, item);
   }

   private int getPositionInner(Node<AnyType> node, int position, AnyType item) {

   	if (item.equals(node.data)) {
   		return position;
   	}

   	if (node.next == null) {
   		return -1;
   	}

   	return getPositionInner(node.next, ++position, item);

   }

   public Node<AnyType> getNode(AnyType item) {

   	if (isEmpty()) {
   		throw new IndexOutOfBoundsException();
   	}

   	Node<AnyType> node = head;

   	return getNodeInner(node, item);
   }

	private Node<AnyType> getNodeInner(Node<AnyType> node, AnyType item) {

		if (item.equals(node.data)) {
			return node;
		}

		if (node.next == null) {
			throw new IndexOutOfBoundsException();
		}

		return getNodeInner(node.next, item);
	}

  	public boolean contains(AnyType item) {

  		if (isEmpty()) {
  			return false;
  		}

  		return getPosition(item) > -1;
   	}

   	public AnyType get(int pos) {

   		if (isEmpty()) {
   			throw new IndexOutOfBoundsException();
   		}

   		Node<AnyType> current = head;
   		for (int i = 0; i < pos; i++) {
   			if (current.next == null) {
   				throw new IndexOutOfBoundsException();
   			}
   			current = current.next;
   		}

   		return current.data;
   	}

   public String toString() {

      StringBuffer result = new StringBuffer();
      // for(Object x : this)
      // 	result.append(x + " ");
      Node node = head;
      while (node != null) {
      	result.append(node.data).append("->");
      	node = node.next;
      }

      result.append("null");


      return result.toString();
   }

   public void insertAfter(AnyType key, AnyType toInsert) {

   	if (isEmpty()) {
   		throw new IndexOutOfBoundsException();
   	}

   	Node node = getNode(key);
   	node.next = new Node(toInsert, node.next);
   }

}
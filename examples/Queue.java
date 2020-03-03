public class Queue<AnyType> {

	public static void main(String[] args) {
		Queue<Integer> ints = new Queue<Integer>();
		ints.printQueue();
		ints.enqueue(4);
		ints.enqueue(5);
		ints.enqueue(6);
		ints.printQueue();
		ints.dequeue();
		ints.printQueue();
		ints.dequeue();
		ints.printQueue();
		ints.dequeue();
		ints.printQueue();
		ints.enqueue(4);
		ints.enqueue(5);
		ints.enqueue(6);
		ints.printQueue();
	}

	private class Node {
		AnyType data;
		Node next;

		Node(AnyType data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public Queue() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size() == 0;
	}

	public void enqueue(AnyType item) {

		Node newNode = new Node(item, null);

		if (empty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}

		tail = newNode;
		size++;
	}

	public AnyType dequeue() {

		if (empty()) {
			throw new IndexOutOfBoundsException();
		}

		AnyType item = head.data;
		head = head.next;
		size--;

		return item;
	}

	public void printQueue() {
		Node node = head;
		// System.out.println("head->");
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println("null");
		// System.out.println("<-tail");
	}
}
import java.util.ArrayList;

public class Stack<AnyType> {

	public static void main(String[] args) {
		Stack<Integer> ints = new Stack<Integer>();
		ints.push(4);
		ints.push(5);
		ints.push(6);
		ints.printStack();
	}

	private int topOfStack;
	private ArrayList<AnyType> stack;

	public Stack() {
		this.topOfStack = -1;
		this.stack = new ArrayList<AnyType>();
	}

	private void assertNotEmpty() {

		if (topOfStack < 0) {
			throw new IndexOutOfBoundsException();
		}
	}

	public void push(AnyType item) {

		topOfStack++;
		stack.add(item);
	}

	public AnyType pop() {

		assertNotEmpty();
		AnyType item = stack.get(topOfStack);
		topOfStack--;
		return item;
	}

	public AnyType peak() {

		assertNotEmpty();
		return stack.get(topOfStack);
	}

	private void printStack() {
		System.out.println("-");
		for (int i = topOfStack; i >= 0; i--) {
			System.out.println(stack.get(i));
		}
		System.out.println("-");
	}
}
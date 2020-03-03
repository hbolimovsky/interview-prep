import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;

// TODO: handle empty/null graph
// TODO: make generic
// NOTE: a common mistake you keep making is trying to reference
// all vertices from the key set, without adding all vertices
// i.e. because is a directed graph (so for 1->3 only adding 1)

public class Graph {

	enum Direction {
		DIRECTED, UNDIRECTED
	}

	Direction direction;
	// NOTE: since underlying datastructure is a LL,
	// have to worry about duplicate edges appearing twice
	// i.e. graph.addEdge(1, 2); graph.addEdge(1, 2);
	HashMap<Integer, LinkedList<Integer>> edges;

	public static void main(String[] args) {
		Graph graph = new Graph(Direction.UNDIRECTED);

		// graph.addEdge(0, 1);
		// graph.addEdge(1, 2);
		// graph.addEdge(2, 3);
		// graph.addEdge(3, 0);

		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(1, 0);

		// graph.printEdges();
		graph.depthFirstTraverse();
	}

	public Graph(Direction direction) {
		edges = new HashMap<Integer, LinkedList<Integer>>();
		this.direction = direction;
	}

	public void addEdge(int from, int to) {

		if (!edges.containsKey(from)) {
			edges.put(from, new LinkedList<Integer>());
		}

		if (!edges.containsKey(to)) {
			edges.put(to, new LinkedList<Integer>());
		}

		// add vertex_to -> vertex_form
		LinkedList<Integer> linkedList = edges.get(from);
		linkedList.addLast(to);

		// if undirected, also add vertex_from -> vertex_to
		if (direction == Direction.UNDIRECTED) {
			linkedList = edges.get(to);
			linkedList.addLast(from);
		}
	}

	private HashMap<Integer, Boolean> buildVisited() {
		HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		// initialize all vertices to false
		for (Integer vertexFrom: edges.keySet()) {
			visited.put(vertexFrom, false);
			for(Integer vertexTo: edges.get(vertexFrom)) {
				visited.put(vertexTo, false);
			}
		}
		return visited;
	}

	public void depthFirstTraverse() {
		// arbitrarily get first element
		Integer first = (Integer) edges.keySet().toArray()[0];
		// track whether vertex was visited
		HashMap<Integer, Boolean> visited = buildVisited();
		depthFirstTraverse(first, visited);
	}

	public void depthFirstTraverse(Integer current, HashMap<Integer, Boolean> visited) {
		// mark as visited
		visited.put(current, true);
		System.out.println("current: " + current);
		// System.out.println("eddges: " + edges);

		// for all neighbors
		for (Integer neighbor: edges.get(current)) {
			// if not visited
			if (!visited.get(neighbor)) {
				depthFirstTraverse(neighbor, visited);
			}
		}
	}

	// TODO: change so takes in node argument
	public void breadthFirstTraverse() {
		// track whether vertex was visited
		HashMap<Integer, Boolean> visited = buildVisited();
		// store neighbors
		Queue<Integer> queue = new LinkedList<Integer>();

		// arbitrarily add first element
		Integer current = (Integer) edges.keySet().toArray()[0];
		queue.add(current);

		while (queue.peek() != null) {

			current = queue.remove();
			System.out.println("current: " + current);
			visited.put(current, true);

			for (Integer neighbor: edges.get(current)) {
				if (!visited.get(neighbor)) {
					queue.add(neighbor);
				}
			}
		}
	}

	public void printEdges() {
		for (Integer key: edges.keySet()) {
			System.out.print(key + "->");
			for (Integer edge: edges.get(key)) {
				System.out.println(edge);
			}
		}
	}

}
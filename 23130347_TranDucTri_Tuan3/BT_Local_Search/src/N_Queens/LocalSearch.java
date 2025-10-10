package N_Queens;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class LocalSearch {
	public int checkHHorizontal(Node node) {
		int conflicts = 0;
		for (int i = 0; i < node.n; i++) {
			for (int j = i + 1; j < node.n; j++) {
				if (node.state.get(i).equals(node.state.get(j))) {
					conflicts++;
				}
			}
		}
		return conflicts;
	}

	public int checkDiagonal(Node node) {
		int conflicts = 0;
		for (int i = 0; i < node.n; i++) {
			for (int j = i + 1; j < node.n; j++) {
				int rowDiff = Math.abs(node.state.get(i) - node.state.get(j));
				int colDiff = Math.abs(i - j);
				if (rowDiff == colDiff) {
					conflicts++;
				}
			}
		}
		return conflicts;
	}

	public int heuristic(Node node) {
		return checkHHorizontal(node) + checkDiagonal(node);
	}

	public int tryMovingOneQueen(Node node, int x, int y) {
		List<Integer> newState = new ArrayList<Integer>(node.state);
		newState.set(y, x);
		Node newNode = new Node(node.n, newState);
		return heuristic(newNode);
	}

	public SortedMap<Integer, Node> generateNeighbours(Node node) {
		SortedMap<Integer, Node> neighbours = new TreeMap<>();

		for (int col = 0; col < node.n; col++) {
			for (int row = 0; row < node.n; row++) {
				if (row != node.state.get(col)) {
					List<Integer> newState = new ArrayList<>(node.state);
					newState.set(col, row);
					Node neighbour = new Node(node.n, newState);
					int h = heuristic(neighbour);
					if (!neighbours.containsKey(h)) {
						neighbours.put(h, neighbour);
					}
				}
			}
		}
		return neighbours;
	}

	public void run() {
		Node initial = new Node(8); // hoặc 4,5,6,7
		if (heuristic(initial) == 0) // goal
		{
			System.out.println(initial.state);
			return;
		}
		System.out.println("Initial state is: " + initial.state);
		Node node = initial;
		SortedMap<Integer, Node> neighbours = generateNeighbours(node);
		Integer bestHeuristic = neighbours.firstKey();
		while (bestHeuristic < heuristic(node)) {
			node = neighbours.get(bestHeuristic);
			neighbours = generateNeighbours(node);
			bestHeuristic = neighbours.firstKey();
		}
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else
			System.out.println("Cannot find goal state! Best state is: " + node.state);
	}
}

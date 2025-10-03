package BT_N_Hau;

import java.util.ArrayList;
import java.util.List;

public class Node {
	int n;
	List<Integer> state;
	List<Node> neighbours;
	
	boolean visited = false;
	Node parent;

	public Node(int n) {
		super();
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();
	}

	public Node(int n, List<Integer> state) {
		super();
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();
	}

	public void addNeighbours(Node neighbourNode) {
		this.neighbours.add(neighbourNode);
	}

	public boolean isValid(List<Integer> state) {
		int col = state.size() - 1;
		int row = state.get(col);

		for (int i = 0; i < col; i++) {
			int otherRow = state.get(i);
			if (row == otherRow) {
				return false;
			}
			if (Math.abs(row - otherRow) == Math.abs(col - 1)) {
				return false;
			}
		}
		return true;

	}

	public List<Integer> place(int x) {
		List<Integer> newState = new ArrayList<>(this.state);
		newState.add(x);

		if (isValid(newState)) {
			return newState;
		}
		return null;
	}

	public List<Node> getNeighbours() {
		if (this.state.size() == n)
			return null;
		for (int row = 0; row < n; row++) {
			List<Integer> newState = place(row);
			if (newState != null) {
				Node child = new Node(n, newState);
				this.addNeighbours(child);
			}
		}
		return this.neighbours;
	}

}

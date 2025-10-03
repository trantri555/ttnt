package BT_N_Hau;

import java.util.Stack;

public class DfsWithStack {
	public Node dfsWithStack(Node initial, int n) {
		Stack<Node> stack = new Stack<>();
		initial.visited = true;
		stack.push(initial);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.state.size() == n) {
				System.out.println("DFS solution:" + node.state);
				return node;
			}
			for (Node neighbour : node.getNeighbours()) {
				if (!neighbour.visited) {
					neighbour.visited = true;
					neighbour.parent = node;
					stack.push(neighbour);
				}
			}
		}
		System.out.println("Can't found DFS solution!");
		return null;
	}
}

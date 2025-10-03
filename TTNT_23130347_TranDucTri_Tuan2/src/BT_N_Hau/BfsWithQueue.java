package BT_N_Hau;

import java.util.LinkedList;
import java.util.Queue;

public class BfsWithQueue {
	public Node bfsWithQueue(Node initial, int n) {
		Queue<Node> queue = new LinkedList<>();
		initial.visited = true;
		queue.add(initial);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.state.size() == n) {
				System.out.println("BFS solution:" + node.state);
				return node;
			}
			for (Node neighbour : node.getNeighbours()) {
				if (!neighbour.visited) {
					neighbour.visited = true;
					neighbour.parent = node;
					queue.add(neighbour);
				}
			}
		}
		System.out.println("Can't found Bfs solution!");
		return null;
	}
}

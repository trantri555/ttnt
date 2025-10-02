package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BfsWithQueue {
public void bfsWithQueue(Node initial, int goal) {
	Queue<Node> queue = new LinkedList<>();
	initial.visited = true;
	queue.add(initial);
	while(!queue.isEmpty()) {
		Node node = queue.poll();
		if(node.state == goal) {
			String s = "";
			while(node != null) {
				s = node.state + " " + s;
				node = node.parent;
			}
			System.out.println("Bfs route: " + s);
			return;
		}
		for (Node neighbour : node.getNeighbour()) {
			if(!neighbour.visited) {
				neighbour.visited = true;
				neighbour.parent = node;
				queue.add(neighbour);
			}
		}
	}
	System.out.println("Can't found Bfs route!");
}
public static void main(String[] args) {
	Node node40 =new Node(40);
	Node node10 =new Node(10);
	Node node20 =new Node(20);
	Node node30 =new Node(30);
	Node node60 =new Node(60);
	Node node50 =new Node(50);
	Node node70 =new Node(70);

	node40.addNeighbours(node10);
	node40.addNeighbours(node20);
	node10.addNeighbours(node30);
	node20.addNeighbours(node10);
	node20.addNeighbours(node30);
	node20.addNeighbours(node60);
	node20.addNeighbours(node50);
	node30.addNeighbours(node60);
	node60.addNeighbours(node70);
	node50.addNeighbours(node70);
	BfsWithQueue bfsExample = new BfsWithQueue();
	System.out.println("The BFS traversal of the graph using queue ");
	bfsExample.bfsWithQueue(node40, 70);
}
}

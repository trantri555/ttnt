package DFS;

import java.util.Stack;

import BFS.Node;

public class DfsWithStack {
public void dfsWithStack(DNode initial, int goal) {
	Stack<DNode> stack =  new Stack<>();
	initial.visited = true;
	stack.push(initial);
	while(!stack.isEmpty()) {
		DNode node = stack.pop();
		if(node.state == goal) {
			String path = "";
			while(node != null) {
				path = node.state + " " + path;
				node = node.parent;
			}
			System.out.println("DFS route: " + path);
			return;
		}
		for (DNode neighbour : node.getNeighbour()) {
			if(!neighbour.visited) {
				neighbour.visited = true;
				neighbour.parent = node;
				stack.push(neighbour);
			}
		}
	}
	System.out.println("Can't found DFS route!");
}
public static void main(String[] args) {
	DNode node40 =new DNode(40);
	DNode node10 =new DNode(10);
	DNode node20 =new DNode(20);
	DNode node30 =new DNode(30);
	DNode node60 =new DNode(60);
	DNode node50 =new DNode(50);
	DNode node70 =new DNode(70);

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
	DfsWithStack dfsExample = new DfsWithStack();
	System.out.println("The BFS traversal of the graph using queue ");
	dfsExample.dfsWithStack(node40, 70);
}
}
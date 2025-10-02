package DFS;

import java.util.ArrayList;
import java.util.List;

public class DNode {
	int state;
	boolean visited;
	List<DNode> neighbours;
	DNode parent;
	public DNode(int state) {
		super();
		this.state = state;
		this.neighbours = new ArrayList<>();
		this.parent = null;
	}
	public void addNeighbours(DNode neighbourNode) {
		this.neighbours.add(neighbourNode);
	}
	public List<DNode> getNeighbour(){
		return neighbours;
	}
}

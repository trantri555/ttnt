package BT_N_Hau;

public class Queens {
	private int n;
	private Node goal;
	public Queens (int n)
	{
		this.n=n;
	}
	public void dfs()
	{
		DfsWithStack dfs=new DfsWithStack();
		this.goal=dfs.dfsWithStack(new Node(n), n);
	}
	public void bfs()
	{
		BfsWithQueue bfs=new BfsWithQueue();
		this.goal=bfs.bfsWithQueue(new Node(n), n);
	}
}

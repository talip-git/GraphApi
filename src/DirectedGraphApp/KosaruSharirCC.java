package DirectedGraphApp;

public class KosaruSharirCC {
    public boolean [] marked;
    public int [] id;
    public int count;
    public KosaruSharirCC(Digraph digraph,int vertex){
        this.marked = new boolean[digraph.V()];
        this.id = new int[digraph.V()];
        this.count = 0;
        digraph.reverse();
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph);
        for (int w:depthFirstOrder.reversePost()){
            if(!marked[w]){
                dfs(digraph,w);
                count++;
            }
        }
    }
    public void dfs(Digraph digraph,int vertex){
        marked[vertex] = true;
        id[vertex] = count;

        for (int w:digraph.adj(vertex)){
            if(!marked[w]){
                dfs(digraph,w);
            }
        }
    }
    public boolean stronglyConnected(int vertex,int w){
        return id[vertex] == id[w];
    }

}

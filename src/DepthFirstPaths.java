import java.util.Stack;

public class DepthFirstPaths {
    private final boolean [] marked;
    private final int [] edgeTo;
    private Graph graph;
    private int start;
    public DepthFirstPaths(Graph graph, int start){
        this.graph = graph;
        this.start = start;
        edgeTo = new int[graph.getVertexCount()];
        marked = new boolean[graph.getVertexCount()];
    }
    private void depthFirstSearch(int vertex){
        marked[vertex] = true;
        for (int w:graph.adj(vertex)){
            if(!marked[w]){
                depthFirstSearch(w);
                edgeTo[w] = vertex;
            }
        }
    }
    public boolean hasPathTo(int vertex){
        return marked[vertex];
    }
    public Iterable<Integer> pathTo(int vertex){
        if(!hasPathTo(vertex)){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int i = vertex;i != start;i = edgeTo[i]){
            path.push(i);
        }
        path.push(start);
        return path;
    }
}

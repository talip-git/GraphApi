import java.util.LinkedList;

public class Graph {
    private int V;
    LinkedList<Integer>[] adj;

    public Graph(int V) {
        V = V;
        adj = new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        int degree = 0;
        for (int i : adj(v)) {
            degree++;
        }
        return degree;
    }

    public int maxDegree(){
        int max = 0;
        for(int v = 0; v<V; v++) {
            if(degree(v)>max){
                max = degree(v);
            }
        }
        return max;
    }

    public int numberOfSelfLoops()
    {
        int count = 0;
        for (int v = 0; v <V; v++)
            for (int w : adj(v))
                if (v == w) count++;
        return count/2;
    }

    public int getVertexCount(){
        return V;
    }
}

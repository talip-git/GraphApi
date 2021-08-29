package DirectedGraphApp;

import java.util.LinkedList;

public class Digraph {
    int V;
    LinkedList<Integer> [] adj;

    public Digraph(int V){
        this.V = V;
        adj = new LinkedList[this.V];
        for (int w = 0;w<this.V;w++){
            adj[w] = new LinkedList<>();
        }
    }
    public void addEdge(int v,int w){
        adj[v].add(w);
    }
    public void reverse(){
        LinkedList<Integer> [] reverseList = new LinkedList[this.V];
        int j = 0;
        for (int i = adj.length-1;i>=0;i--){
            reverseList[j] = adj[i];
            j++;
        }
        adj = reverseList;
    }
    public int V(){
        return this.V;
    }
    public Iterable<Integer> adj(int vertex){
        return this.adj[vertex];
    }


}

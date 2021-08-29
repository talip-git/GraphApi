package DirectedGraphApp;

import java.util.Stack;

public class DepthFirstOrder {
    public boolean [] marked;
    Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph){
        marked = new boolean[digraph.V()];
        for (int v = 0;v<digraph.V();v++){
            if(!marked[v]){
                dfs(digraph,v);
            }
        }
    }
    public void dfs(Digraph digraph,int vertex){
        marked[vertex] = true;
        for (int w:digraph.adj(vertex)){
            if (!marked[w]){
                dfs(digraph,w);
            }
        }
        reversePost.push(vertex);
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}

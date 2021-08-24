public class ConnectedComponents {
    private boolean [] marked;
    private int [] id;
    private int count;

    public ConnectedComponents(Graph g) {
        id =  new int[g.getVertexCount()];
        marked =  new boolean[g.getVertexCount()];
        count=0;
        for (int vertex = 0;vertex<g.getVertexCount();vertex++){
            if(!marked[vertex]){
                depthFirstSearch(g,vertex);
                count++;
            }
        }
    }
    public int getCount(){
        return this.count;
    }
    public int id(int vertex){
        return id[vertex];
    }
    private void depthFirstSearch(Graph g,int vertex){
        this.id[vertex] = count;
        this.marked[vertex] = true;

        for (int w:g.adj(vertex)){
            if(!marked[w]){
                depthFirstSearch(g,w);
            }
        }
    }
}

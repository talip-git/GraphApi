import java.util.PriorityQueue;

public class BreadthFirstPath {
    private boolean [] marked;
    private int [] edgeTo;

    public BreadthFirstPath(Graph g,int start){
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int [g.getVertexCount()];
    }

    private void breadthFirstPath(Graph g,int start){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        marked[start]=true;

        while (!queue.isEmpty()){

            int vertex = queue.poll();

            for (int w:g.adj(vertex)){
                if(!marked[w]){

                    queue.add(w);
                    marked[w]=true;
                    edgeTo[w]=vertex;
                }
            }
        }
    }
}

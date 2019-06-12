import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;



public class Ex22_VertexWeights {
    public class WeightedVertex{
        private int id;
        private double weight;

        WeightedVertex(int id, double weight){
            this.id = id;
            this.weight = weight;
        }
    }
    public class VertexWeightedDigraph {
        private final int V; // number of vertices
        private int E; // number of edges
        private Bag<Integer>[] adj; // adjacency vertexes
        private WeightedVertex[] vertexes;
        public VertexWeightedDigraph(int V){
            this.V = V;
            this.E = 0;
            adj = (Bag<Integer>[])new Bag[V];
            vertexes = new WeightedVertex[V];

            for (int v = 0; v < V; v++){
                adj[v] = new Bag<>();
            }
        }
        public int V() { return V; }
        public int E() { return E; }
        public void setVertex(WeightedVertex wv){
            if (wv == null)
                throw new IllegalArgumentException("Weighted vertex cannot be null");
            if (wv.id < 0 || wv.id >= V)
                throw new IllegalArgumentException("Invalid vertex id");

            vertexes[wv.id] = wv;
        }
        public WeightedVertex[] GetAllVertixes(){
            return vertexes;
        }
        public void addEdge(int from, int to){
            adj[from].add(to);
            E++;
        }
        public Iterable<Integer> edges(){
            Bag<Integer> bag = new Bag<>();

            for(int v = 0; v < V; v++){
                for(int neighbor : adj[v])
                    bag.add(neighbor);
            }
            return bag;
        }
        @Override
        public String toString(){
            StringBuilder stringbuilder = new StringBuilder();
            for (int v = 0; v < V; v++){
                stringbuilder.append(v).append(": ");

                for (int neighbor : adj[v]){
                    stringbuilder.append(neighbor).append(" ");
                }
                stringbuilder.append("\n");
            }
            return stringbuilder.toString();
        }

    }
    public class DijkstraVertexWeightedDigraph{
        private DijkstraSP sp;
        private int V;

        DijkstraVertexWeightedDigraph(VertexWeightedDigraph vG, int source){
            if (vG == null)
                throw new IllegalArgumentException("G cannot be null");
            this.V = vG.V();
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(V + vG.E());

            for(WeightedVertex wv : vG.GetAllVertixes()){
                G.addEdge(new DirectedEdge(wv.id, wv.id + V, wv.weight));
            }
            for (int v = 0; v < V; v++){
                for (int neighbor : vG.adj[v]){
                    G.addEdge(new DirectedEdge(v + V, neighbor, 0));
                }
            }
            sp = new DijkstraSP(G, source);
        }
        public double distTo(int v){
            int target = v + V;
            return sp.distTo(target);
        }
        public boolean hasPathTo(int v){
            int target = v + V;
            return sp.hasPathTo(target);
        }
        public Iterable<DirectedEdge> pathTo(int v){
            int target = v + V;
            return sp.pathTo(target);
        }
    }
    public static void main(String[] args){
        Ex22_VertexWeights ex22 = new Ex22_VertexWeights();

        VertexWeightedDigraph vG = ex22.new VertexWeightedDigraph(7);

        vG.setVertex(ex22.new WeightedVertex(0,5));
        vG.setVertex(ex22.new WeightedVertex(1,10));
        vG.setVertex(ex22.new WeightedVertex(2,2));
        vG.setVertex(ex22.new WeightedVertex(3,3));
        vG.setVertex(ex22.new WeightedVertex(4,3));
        vG.setVertex(ex22.new WeightedVertex(5,12));
        vG.setVertex(ex22.new WeightedVertex(6,4));

        vG.addEdge(0,1);
        vG.addEdge(1,2);
        vG.addEdge(2,1);
        vG.addEdge(1,3);
        vG.addEdge(2,6);
        vG.addEdge(2,4);
        vG.addEdge(4,5);

        int s = 0;
        DijkstraVertexWeightedDigraph GSP = ex22.new DijkstraVertexWeightedDigraph(vG, s);

        for (int t = 0; t < vG.V(); t++)
        {
            StdOut.print(s + " to " + t);
            StdOut.printf(" (%4.2f): ", GSP.distTo(t));
            if (GSP.hasPathTo(t))
                for (DirectedEdge e : GSP.pathTo(t))
                    StdOut.print(e + " ");
            StdOut.println();
        }

    }
}

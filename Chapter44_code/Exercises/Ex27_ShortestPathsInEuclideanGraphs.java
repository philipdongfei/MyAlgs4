import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;
import java.util.DrawUtilities;
import java.util.DrawUtilities.Coordinate;

import java.awt.*;

public class Ex27_ShortestPathsInEuclideanGraphs {
    public class EuclideanEdgeWeightedDigraph implements EdgeWeightedDigraphInterface {
        public class Vertex {
            protected int id;
            private String name;
            protected Coordinate coordinates;

            Vertex(int id, double xCoordinate, double yCoordinate){
                this(id, String.valueOf(id), xCoordinate, yCoordinate);
            }
            Vertex(int id, String name, double xCoordinate, double yCoordinate) {
                this.id = id;
                this.name = name;
                coordinates = new DrawUtilities().new Coordinate(xCoordinate, yCoordinate);
            }
            public void updateName(String name){
                this.name = name;
            }
        }
        private final int vertices;
        private int edges;
        private Vertex[] allVertices;
        private Bag<DirectedEdge>[] adj;

        public EuclideanEdgeWeightedDigraph(int vertices){
            this.vertices = vertices;
            edges = 0;
            allVertices = new Vertex[vertices];
            adj = (Bag<DirectedEdge>[])new Bag[vertices];
            for (int v = 0; v < vertices; v++)
                adj[v] = new Bag<>();
        }
        public EuclideanEdgeWeightedDigraph(In in){
            this(in.readInt());
            for (int i = 0; i < vertices; i++){
                int id = in.readInt();
                double x = in.readDouble();
                double y = in.readDouble();
                addVertex(new Vertex(id, x, y));

            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
            for (int e = 0; e < E; e++){
                int v = in.readInt();
                int w = in.readInt();
                double distance = getDistanceBetweenVertices(v, w);
                addEdge(new DirectedEdge(v, w, distance));
            }
        }
        public int vertices(){
            return vertices;
        }
        public int edgesCount(){
            return edges;
        }
        public int outdegree(int vertex){
            return adj[vertex].size();
        }
        public Vertex getVertex(int vertexId){
            return allVertices[vertexId];
        }
        public void addVertex(Vertex vertex){
            allVertices[vertex.id] = vertex;
        }

        public void addEdge(DirectedEdge e){
            int vertexId1 = e.from();
            int vertexId2 = e.to();
            if (allVertices[vertexId1] == null || 
                    allVertices[vertexId2] == null){
                throw new IllegalArgumentException("Vertex id not found");
                    }
            ajd[vertexId1].add(e);
            edges++;
        }
        public void show(double xScaleLow, double xScaleHigh, double yScaleLow, double yScaleHigh,
                double radiusOfCircleAroundVertex, double padding, double arrowLength){
            StdDraw.setCanvasSize(500, 400);
            StdDraw.setXscale(xScaleLow, xScaleHigh);
            StdDraw.setYscale(yScaleLow, yScaleHigh);
            StdDraw.setPenRadius(0.002D);
            for (int vertexId = 0; vertexId < vertices; vertexId++){
                if (allVertices[vertexId] != null){
                    double xCoordinate = allVertices[vertexId].coordinates.getXCoordinate();
                    double yCoordinate = allVertices[vertexId].coordinates.getYCoordinate();
                    StdDraw.setPenColor(Color.WHITE);
                    StdDraw.filledCircle(xCoordinate, yCoordinate, radiusOfCircleAroundVertex);
                    StdDraw.setPenColor(Color.BLACK);
                    StdDraw.circle(xCoordinate, yCoordinate, radiusOfCircleAroundVertex);
                    StdDraw.setPenColor(Color.BLUE);
                    StdDraw.text(xCoordinate, yCoordinate, allVertices[vertexId].name);
                }
            }
            for (int vertexId = 0; vertexId < vertices; vertexId++){
                for (DirectedEdge e : adj(vertexId)){
                    int otherVertexId = e.to();
                    Vertex neighborVertex = allVertices[otherVertexId];
                    DrawUtilities.drawArrow(allVertices[vertexId].coordinates, neighborVertex.coordinates, padding, arrowLength);
                }
            }
        }
        public Iterable<DirectedEdge> adj(int v){
            return adj[v];
        }
        public Iterable<DirectedEdge> edges(){
            Bag<DirectedEdge> edges = new Bag<>();

            for (int v = 0; v < vertices; v++){
                for (DirectedEdge e : adj[v]){
                    edges.add(edge);
                }
            }
            return edges;
        }

        public EuclideanEdgeWeightedDigraph reverse(){
            EuclideanEdgeWeightedDigraph reverse = new
                EuclideanEdgeWeightedDigraph(vertices);
            for (int v = 0; v < vertices; v++){
                for (DirectedEdge e : adj(v)){
                    int neighbor = edge.to();
                    reverse.addEdge(new DirectedEdge(neighbor, v, e.weight()));
                }
            }
            return reverse;
        }

        @Override
        public String toString(){
            StringBuilder stringbuilder = new StringBuilder();
            for (int v = 0; v < vertices(); v++){
                stringbuilder.append(v).append(": ");

                for (DirectedEdge neighbor : adj(v)){
                    stringbuilder.append(neighbor).append(" ");
                }
                stringbuilder.append("\n");
            }
            return stringbuilder.toString();
        }
    }
    public class DijkstraSPEuclideanGraph{
        private DirectedEdge[] edgeTo; 
        private double[] distTo;  
        private IndexMinPQ<Double> pq;

        private int source;
        private boolean shortestDistanceComputed[];//used to avoid 
            // recomputing shortest distances to the same vertex.
        private double finalDistanceTo[]; // length of path to a vertex that has already been computed
        private EuclideanEdgeWeightedDigraph euclideanEdgeWeightedDigraph;


        public DijkstraSPEuclideanGraph(EuclideanEdgeWeightedDigraph euclideanEdgeWeightedDigraph, int source) 
        {
            pq = new IndexMinPQ<>(euclideanEdgeWeightedDigraph.vertices());
            shortestDistanceComputed = new boolean[euclideanEdgeWeightedDigraph.vertices()];
            finalDistanceTo = new double[euclideanEdgeWeightedDigraph.vertices()];
            this.euclideanEdgeWeightedDigraph = euclideanEdgeWeightedDigraph;
            this.source = source;
        }
        private void computeSourceSinkeShortestPath(int target){
            edgeTo = new DirectedEdge[euclideanEdgeWeightedDigraph.vertices()];
            distTo = new double[euclideanEdgeWeightedDigraph.vertices()];
            for (int v = 0; v < euclideanEdgeWeightedDigraph.vertices();
                    v++)
            {
                distTo[v] = Double.POSITIVE_INFINITY;
            }
            double distanceFromSourceToTarget = getDistanceBetweenVertices(source, target);

            distTo[source] = distanceFromSourceToTarget;
            pq.insert(source, distanceFromSourceToTarget);

            while(!pq.isEmpty()){
                int vertexToRelax = pq.delMin();

                if (vertexToRelax == target)
                    break;
                relax(euclideanEdgeWeightedDigraph, vertexToRelax, target);
            }
            finalDistanceTo[target] = distTo[target];
        }

        private void relax(EuclideanEdgeWeightedDigraph euclideanEdgeWeightedDigraph, int vertex, int target){
            double distanceFromVertexToTarget = getDistanceBetweenVertices(vertex, target);
            for (DirectedEdge edge : euclideanEdgeWeightedDigraph(vertex))
            {
                int neighbor = edge.to();

                double distanceFromNeighborToTarget = getDistanceBetweenVertices(neighbor, target);
                double distanceToTargetPassingThroughNeighbor = 
                    distTo[vertex] + edge.weight() + distanceFromNeighborToTarget - distanceFromVertexToTarget;

                if (distTo[neighbor] > distanceToTargetPassingThroughNeighbor)
                {
                    distTo[neighbor] = distanceToTargetPassingThroughNeighbor;
                    edgeTo[neighbor] = edge;

                    if (pq.contains(neighbor))
                        pq.change(neighbor, distTo[neighbor]);
                    else
                        pq.insert(neighbor, distTo[neighbor]);
                }
            }
        }
        private double getDistanceBetweenVertices(int v1, int v2)
        {
            EuclideanEdgeWeightedDigraph.Vertex point1 = euclideanEdgeWeightedDigraph.getVertex(v1);
            EuclideanEdgeWeightedDigraph.Vertex point2 = euclideanEdgeWeightedDigraph.getVertex(v2);

            return Math.sqrt(Math.pow(p1.coordinates.getXCoordinate() -  p2.coordinates.getXCoordinate(), 2) + Math.pow(p1.coordinates.getYCoordinate() - p2.coordinates.getYCoordinate(), 2));

        }
        public double distTo(int vertex){
            if (!shortestDistanceComputed[vertex]){
                computeSourceSinkeShortestPath(vertex);
                shortestDistanceComputed[vertex] = true;
            }
            return finalDistanceTo[vertex];
        }
        public boolean hasPathTo(int vertex){
            if (!shortestDistanceComputed[vertex]){
                computeSourceSinkeShortestPath(vertex);
                shortestDistanceComputed[vertex] = true;
            }
            return finalDistanceTo[vertex] < Double.POSITIVE_INFINITY;
        }

        public Iterable<DirectedEdge> pathTo(int vertex)
        {
            if (!shortestDistanceComputed[vertex]){
                computeSourceSinkeShortestPath(vertex);
                shortestDistanceComputed[vertex] = true;
            }
            if (!hasPathTo(vertex))
                return null;
            Stack<DirectedEdge> path = new Stack<>();
            for (DirectedEdge e = edgeTo[vertex]; e != null; e = edgeTo[e.from()])
            {
                path.push(e);
            }
            return path;
        }
    }
    private double getDistanceBetweenVertices(EuclideanEdgeWeightedDigraph.Vertex v1, EuclideanEdgeWeightedDigraph.Vertex v2)
    {
        return Math.sqrt(Math.pow(v1.coordinates.getXCoordinate() - v2.coordinates.getXCoordinate(), 2) + Math.pow(v1.coordinates.getYCoordinate() - v2.coordinates.getYCoordinate(), 2));
    }

    public static void main(String[] args){
        Ex27_ShortestPathsInEuclideanGraphs shortestPath = 
            new Ex27_ShortestPathsInEuclideanGraphs();
        EuclideanEdgeWeightedDigraph G = 
            shortestPath.new EuclideanEdgeWeightedDigraph(in);
        DijkstraSPEuclideanGraph sp = 
            shortestPath.new DijkstraSPEuclideanGraph(G, 0);

        G.show(0, 15, 0, 20, 0.5, 0.08, 0.5);

        for (int v = 0; v < G.vertices(); v++)
            StdOut.printf("Distance to vertex %d: %.2f\n", v, 
                    sp.distTo(v));

        for (int v = 0; v < G.vertices(); v++){
            StdOut.print("Path from vertex 0 to vertex " + v + ": ");

            if (sp.hasPathTo(v)){
                for (DirectedEdge e : sp.pathTo(v))
                    StdOut.print(e + " ");
            } else
                StdOut.print("There is no path to vertex " + v);
            StdOut.println();
        }

    }


}




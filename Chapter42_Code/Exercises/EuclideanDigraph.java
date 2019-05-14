import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdDraw;
import util.DrawUtilities;
import util.DrawUtilities.Coordinate;

import java.awt.*;



@SuppressWarnings("unchecked")
public class EuclideanDigraph {
    public static class Vertex {
        protected int id;
        private String name;
        protected Coordinate coordinates;

        Vertex(int id, double xCoordinate, double yCoordinate){
            this(id, String.valueOf(id), xCoordinate, yCoordinate);
        }
        Vertex(int id, String name, double xCoordinate, double yCoordinate)
        {
            this.id = id;
            this.name = name;
            coordinates = new DrawUtilities().new Coordinate(xCoordinate,
                    yCoordinate);
        }
        public void updateName(String name){
            this.name = name;
        }

    }

    private final int vertices;
    private int edges;
    private Vertex[] allVertices;
    private Bag<Integer>[] adjacent;

    private int[] indegrees;
    private int[] outdegrees;

    public EuclideanDigraph(int vertices){
        this.vertices = vertices;
        this.edges = 0;
        allVertices = new Vertex[vertices];
        adjacent = (Bag<Integer>[]) new Bag[vertices];

        indegrees = new int[vertices];
        outdegrees = new int[vertices];

        for (int v = 0; v < vertices; v++)
            adjacent[v] = new Bag<Integer>();
    }

    public int vertices(){
        return vertices;
    }
    public int edges(){
        return edges;
    }
    public void addVertex(Vertex v){
        allVertices[v.id] = v;
    }

    public void addEdge(int v1, int v2){
        if (allVertices[v1] == null ||
                allVertices[v2] == null)
            throw new IllegalArgumentException("Vertex id not found");
        adjacent[v1].add(v2);

        edges++;
        outdegrees[v1]++;
        indegrees[v2]++;
    }

    public void show(double xScaleLow, double xScaleHigh, double yScaleLow,
            double yScaleHigh, double radiusOfCircleAroundVertex, 
            double padding, double arrowLength) {
        StdDraw.setCanvasSize(500, 400);
        StdDraw.setXscale(xScaleLow, xScaleHigh);
        StdDraw.setYscale(yScaleLow, yScaleHigh);

        StdDraw.setPenRadius(0.002D);
        StdDraw.setPenColor(StdDraw.BLUE);

        for (int v = 0; v < vertices; v++){
            if (allVertices[v] != null) {
                double xCoordinate = allVertices[v].coordinates.getXCoordinate();
                double yCoordinate = allVertices[v].coordinates.getYCoordinate();

                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledCircle(xCoordinate, yCoordinate, radiusOfCircleAroundVertex);

                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.circle(xCoordinate, yCoordinate, radiusOfCircleAroundVertex);

                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.text(xCoordinate, yCoordinate, allVertices[v].name);
            }
        }
        StdDraw.setPenColor(StdDraw.BLACK);

        for (int v = 0; v < vertices; v++){
            for (Integer neighbor : adjacent(v)){
                Vertex neighborVertex = allVertices[neighbor];

                DrawUtilities.drawArrow(allVertices[v].coordinates, 
                        neighborVertex.coordinates,
                        padding, arrowLength);
            }
        }
    }
    public Iterable<Integer> adjacent(int v){
        return adjacent[v];
    }
    public int indegree(int v){
        return indegrees[v];
    }
    public int outdegree(int v){
        return outdegrees[v];
    }
    public EuclideanDigraph reverse(){
        EuclideanDigraph reverse = new EuclideanDigraph(vertices);

        for (int v = 0; v < vertices; v++)
        {
            for (Integer neighbor : adjacent[v]){
                reverse.addEdge(neighbor, v);
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        for (int v = 0; v < vertices(); v++){
            stringBuilder.append(v).append(": ");

            for (Integer neighbor : adjacent(v)){
                stringBuilder.append(neighbor).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public static  void main(String[] args){
        EuclideanDigraph G = new EuclideanDigraph(7);

        Vertex v0 = new Vertex(0, 6.1, 1.3);
        Vertex v1 = new Vertex(1, 7.2, 2.5);
        Vertex v2 = new Vertex(2, 8.4, 1.3);
        Vertex v3 = new Vertex(3, 8.4, 15.3);
        Vertex v4 = new Vertex(4, 6.1, 15.3);
        Vertex v5 = new Vertex(5, 7.2, 5.2);
        Vertex v6 = new Vertex(6, 7.2, 8.4);

        G.addVertex(v0);
        G.addVertex(v1);
        G.addVertex(v2);
        G.addVertex(v3);
        G.addVertex(v4);
        G.addVertex(v5);
        G.addVertex(v6);

        G.addEdge(0,1);
        G.addEdge(2,1);
        G.addEdge(0,2);
        G.addEdge(3,6);
        G.addEdge(4,6);
        G.addEdge(3,4);
        G.addEdge(1,5);
        G.addEdge(5,6);

        G.show(0, 15, 0, 20, 0.5,
                0.08, 0.4);
        StdOut.println(G);

    }

}

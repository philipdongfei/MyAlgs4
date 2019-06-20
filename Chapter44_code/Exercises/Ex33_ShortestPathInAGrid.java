import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Stack;


public class Ex33_ShortestPathInAGrid {
    public Iterable<DirectedEdge> shortestPathInGridAll4Directions(double[][] matrix){
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(matrix.length*matrix[0].length);

        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[0].length; column++){
                int currentCellIndex = getCellIndex(matrix, row, column);
                int[] neighborRows = {-1, 0, 0, 1};
                int[] neighborColumns = {0, -1, 1, 0};

                for (int i = 0; i < neighborRows.length; i++){
                    int neighborRow = row + neighborRows[i];
                    int neighborColumn = column + neighborColumns[i];
                    if (isValidCell(matrix, neighborRow, neighborColumn )){
                        int neighborCellIndex = getCellIndex(matrix, neighborRow, neighborColumn);
                        G.addEdge(new DirectedEdge(currentCellIndex, neighborCellIndex, matrix[neighborRow][neighborColumn]));
                    }

                }
            }
        }
        int targetCell = matrix.length * matrix.length - 1;
        DijkstraSP sp = new DijkstraSP(G, 0);
        return sp.pathTo(targetCell);
    }
    public Iterable<DirectedEdge> shortestPathInGridOnlyRightOrDown(double[][] matrix){
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(matrix.length * matrix[0].length);

        for (int row = 0; row < matrix.length; row++){
            for (int column = 0; column < matrix[0].length; column++){
                int currentCellIndex = getCellIndex(matrix, row, column);
                int[] neighborRows = {0, 1};
                int[] neighborColumns = {1, 0};

                for (int i = 0; i < neighborRows.length; i++){
                    int neighborRow = row + neighborRows[i];
                    int neighborColumn = column + neighborColumns[i];

                    if (isValidCell(matrix, neighborRow, neighborColumn)){
                        int neighborCellIndex = getCellIndex(matrix, neighborRow, neighborColumn);
                        G.addEdge(new DirectedEdge(currentCellIndex, neighborCellIndex, matrix[neighborRow][neighborColumn]));
                    }
                }
            }
        }
        int targetCell = matrix.length * matrix.length - 1;
        DijkstraSP sp = new DijkstraSP(G, 0);
        return sp.pathTo(targetCell);
    }

    private boolean isValidCell(double[][] matrix, int row, int column){
        return row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length;
    }
    private int getCellIndex(double[][] matrix, int row, int column){
        return matrix.length*row + column;
    }
    public static void main(String[] args){
        Ex33_ShortestPathInAGrid Ex33 = new 
            Ex33_ShortestPathInAGrid();
        StdOut.println("Moving either up, down, left or right: ");
        double[][] matrix1 = {
            {0, 1},
            {3, 1}
        };
        StdOut.print("Path: ");
        Iterable<DirectedEdge> shortestPath1 = Ex33.shortestPathInGridAll4Directions(matrix1);
        for (DirectedEdge e : shortestPath1){
            StdOut.print(e + " ");
        }
        StdOut.println();

        double[][] matrix2 = {
            {0,2,1},
            {1,3,2},
            {4,2,5}
        };

        StdOut.print("Path: ");
        Iterable<DirectedEdge> shortestPath2 = Ex33.shortestPathInGridAll4Directions(matrix2);
        for (DirectedEdge e : shortestPath2){
            StdOut.print(e  + " ");
        }

        double[][] matrix3 = {
            {0,4,10,10,10},
            {1,8,1,1,1},
            {1,8,1,10,1},
            {1,1,1,10,1},
            {10,10,10,10,2}
        };

        StdOut.println("Path to  ");

        Iterable<DirectedEdge> shortestPath3 = Ex33.shortestPathInGridAll4Directions(matrix3);
        for (DirectedEdge e : shortestPath3){
            StdOut.print(e  + " ");
        }
        StdOut.println();
        StdOut.println("Moving only right and down: ");
        StdOut.println("Path to  ");
        Iterable<DirectedEdge> path4 = Ex33.shortestPathInGridOnlyRightOrDown(matrix3);
        for (DirectedEdge e : path4){
            StdOut.print(e + " ");
        }
        StdOut.println();

    }

}

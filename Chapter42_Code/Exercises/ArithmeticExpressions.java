import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Bag;


public class ArithmeticExpressions {

    public double evaluateDAG(Digraph digraph, String[] values) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (directedCycle.hasCycle())
            throw new IllegalArgumentException("Digraph is not a DAG");

        return dfs(digraph, 0, values);
    }

    private double dfs(Digraph digraph, int source, String[] values) {
        if (!values[source].equals("+")
                &&!values[source].equals("-")
                &&!values[source].equals("*")
                &&!values[source].equals("/")) {
            return Double.parseDouble(values[source]);
                }
        double result = Double.MIN_VALUE;
        for (int neighbor : digraph.adj(source)) {
            if (values[source].equals("+")){
                if (result == Double.MIN_VALUE)
                    result = 0;
                result += dfs(digraph, neighbor, values);
            } else if (values[source].equals("-")){
                if (result == Double.MIN_VALUE)
                    result = 0;
                result -= dfs(digraph, neighbor, values);
            }
            else if (values[source].equals("*")){
                if (result == Double.MIN_VALUE)
                    result = 1;
                result *= dfs(digraph, neighbor, values);
            }
            else if (values[source].equals("/")){
                if (result == Double.MIN_VALUE)
                    result = dfs(digraph, neighbor, values);
                else
                    result /= dfs(digraph, neighbor, values);
            }
        }
        values[source] = String.valueOf(result);
        return result;
    }

    public static void main(String[] args) {
        ArithmeticExpressions ae = new ArithmeticExpressions();
        Digraph G = new Digraph(8);
        G.addEdge(0,2);
        G.addEdge(0,1);
        G.addEdge(1,4);
        G.addEdge(1,3);
        G.addEdge(4,7);
        G.addEdge(4,6);
        G.addEdge(2,5);
        G.addEdge(2,4);

        String[] values = {"+", "+", "/", "2", "*","5","3","4"};
        StdOut.println("2+(3*4)+(3*4)/5 = " + ae.evaluateDAG(G, values));
        StdOut.println("Expected: 16.4");
    }
}

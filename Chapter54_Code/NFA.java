import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;


public class NFA {
    protected char[] re;  // match transitions
    protected Digraph G; // epsilon transitons
    protected int M;      // number of states

    public NFA(String regexp) 
    { // Create the NFA for the given regular expression.
        Stack<Integer> ops = new Stack<Integer>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M+1);

        /*
        for (int j = 0; j < re.length; j++)
            StdOut.printf("%d: %c ", j, re[j]);
        StdOut.println();
        */

        for (int i = 0; i < M; i++)
        {
            int lp = i;
            if (re[i] == '(' || re[i] == '|')
                ops.push(i);
            else if (re[i] == ')')
            {
                int or = ops.pop();
                if (re[or] == '|')
                {
                    lp = ops.pop();
                    G.addEdge(lp, or+1);
                    G.addEdge(or, i);
                }
                else lp = or;
            }
            if (i < M-1 && re[i+1] == '*') // lookahead
            {
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i+1);

        }
        
    }

    public boolean recognizes(String txt)
    {
        // Does the NFA recognize txt?
        Bag<Integer> pc = new Bag<Integer>();
        DirectedDFS dfs = new DirectedDFS(G, 0);
        for (int v = 0; v < G.V(); v++)
            if (dfs.marked(v)) pc.add(v);

        ////debug print init states
        /*
        StdOut.println("init pc: ");
        for (int v : pc)
            StdOut.printf("%d ", v);
        StdOut.println("");
        */
        //////
        for (int i = 0; i < txt.length(); i++)
        {// Compute possible NFA states for txt[i+1].
            Bag<Integer> match = new Bag<Integer>();
            for (int v : pc)
                if (v < M)
                    if (re[v] == txt.charAt(i) || re[v] == '.')
                        match.add(v+1);
            pc = new Bag<Integer>();
            dfs = new DirectedDFS(G, match);
            for (int v = 0; v < G.V(); v++)
                if (dfs.marked(v)) pc.add(v);
            /////print state 
            /*
            StdOut.printf("%d %c state: \n", i, txt.charAt(i) );
            for (int v : pc)
                StdOut.printf("%d ", v);
            StdOut.println("");
            */
            /////
        }
        for(int v : pc) if (v == M) return true;
        return false;
    }
    public static void main(String[] args){
        String regexp = "(" + args[0] + ")";
        String txt = args[1];
        NFA nfa = new NFA(regexp);
        StdOut.println(nfa.recognizes(txt));
    }
}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.Bag;

public class NFASpecifiedSet extends NFA {
    private SeparateChainingHashST<Integer, Integer> setsMatchMap;
    public NFASpecifiedSet(String regexp) {
        super(regexp);

        Stack<Integer> ops = new Stack<Integer>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M+1);
        setsMatchMap = new SeparateChainingHashST<>();
        for (int i = 0; i < M; i++)
        {
            int lp = i;
            if (re[i] == '(' || re[i] == '|'
                    || re[i] == '[')
                ops.push(i);
            else if (re[i] == ')')
            {
                SET<Integer> orOperatorIndexes = new SET<>();

                while(re[ops.peek()] == '|'){
                    int or = ops.pop();
                    orOperatorIndexes.add(or);
                }
                lp = ops.pop();

                for (int orIndex : orOperatorIndexes){
                    G.addEdge(orIndex, i);
                    G.addEdge(lp, orIndex + 1);
                }
            }
            else if (re[i] == ']'){
                lp = ops.pop();

                for (int index = lp + 1; index < i; index++){
                    G.addEdge(lp, index);
                    // If a match occurs while checking the characters in this set, 
                    // the DFA will go to the right square bracket state.
                    setsMatchMap.put(index, i);
                }
            }
            if (i < M-1 )
            {
                if (re[i+1] == '*'){
                    G.addEdge(lp, i+1);
                    G.addEdge(i+1, lp);
                }
                else if (re[i+1] == '+'){
                    G.addEdge(i+1, lp);
                }
            }
            if (re[i] == '(' || re[i] == '*' || 
                    re[i] == ')'|| re[i] == '+' 
                    || re[i] == '[' || re[i] == ']')
                G.addEdge(i, i+1);
        }
    }
    @Override
    public boolean recognizes(String txt){
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
                    if (setsMatchMap.contains(v) &&
                             (re[v] == txt.charAt(i) || re[v] == '.'))
                    {
                        int index = setsMatchMap.get(v);
                        match.add(index);

                    } else if (re[v] == txt.charAt(i) || re[v] == '.')
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
        NFASpecifiedSet nfa = new NFASpecifiedSet(regexp);
        StdOut.println(nfa.recognizes(txt));

    }
}

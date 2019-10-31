import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.Digraph;

public class NFAMultiwayOr extends NFA {
    public NFAMultiwayOr (String regexp) {
        super(regexp);

        Stack<Integer> ops = new Stack<Integer>();
        re = regexp.toCharArray();
        M = re.length;
        G = new Digraph(M+1);
        for (int i = 0; i < M; i++)
        {
            int lp = i;
            if (re[i] == '(' || re[i] == '|')
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
            if (i < M-1 && re[i+1] == '*')
            {
                G.addEdge(lp, i+1);
                G.addEdge(i+1, lp);
            }
            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i+1);
        }
    }
    public static void main(String[] args){
        String regexp = "(" + args[0] + ")";
        String txt = args[1];
        NFAMultiwayOr nfa = new NFAMultiwayOr(regexp);
        StdOut.println(nfa.recognizes(txt));

    }
}

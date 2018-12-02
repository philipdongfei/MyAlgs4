import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Ex_1_4_31{
    public class Deque<Item> {
        private Stack<Item> leftS;
        private Stack<Item> rightS;
        private Stack<Item> buffer;
        private int N;

        public Deque() {
            leftS = new Stack<Item>();
            rightS = new Stack<Item>();
            buffer = new Stack<Item>();
            N = 0;
        }
        public boolean isEmpty()    {return N == 0;}
        public int size()    {return N;}
        public void pushLeft(Item item) {
            leftS.push(item);
            N++;

        }
        public void pushRight(Item item) {
            rightS.push(item);
            N++;

        }
        public Item popLeft() {
            if (isEmpty() == true) return null;
            if (leftS.isEmpty() == true) fillLeft();
            Item item = leftS.pop();
            N--;
            return item; 
        }
        public Item popRight() {
            if (isEmpty() == true) return null;
            if (rightS.isEmpty() == true) fillRight();
            Item item = rightS.pop();
            N--;
            return item; 
        }
        private void fillLeft() {
            if (N == 1) {
                leftS.push(rightS.pop());
            }else {
                int n = N/2;
                for (int i=0; i<n; i++)
                    buffer.push(rightS.pop());
                while(rightS.isEmpty() == false)
                    leftS.push(rightS.pop());
                while(buffer.isEmpty() == false)
                    rightS.push(buffer.pop());
            }
        }
        private void fillRight(){
            if (N == 1) {
                leftS.push(rightS.pop());
            }else {
                int n = N/2;
                for (int i=0; i<n; i++)
                    buffer.push(leftS.pop());
                while (leftS.isEmpty() == false)
                    rightS.push(leftS.pop());
                while (buffer.isEmpty() == false)
                    leftS.push(buffer.pop());
            }
        }
    }
}

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class Sample {

    private class Node {
        double weight;
        double cumulativeWeight;
        public Node(){
            weight = 0;
            cumulativeWeight = 0;
        }
    }
    private Node[] nodes;
    double   T;   // total probability

    public Sample(double[] p) {
        int n = p.length;
        nodes = new Node[n+1];
        // used to initialize the nodes with hightest weights on th 
        // top.
        T = 0;
        int nodesIndex = 1;
        for (int i = n; i >= 1; i--){
            Node node = new Node();
            node.weight = p[i-1];
            node.cumulativeWeight = p[i-1];
            nodes[nodesIndex++] = node;

            T += p[i-1];
        }
        computeCumulativeWeights();

    }
    public void show() {
        for (int i = 1; i < nodes.length; i++)
            StdOut.print(nodes[i].weight+" ");
        StdOut.println();
    }

    public int random() {

        int currentIndex = 1;

        StdOut.println("T="+T);
        while (currentIndex * 2 < nodes.length){
            double randomNumber = StdRandom.uniform(0, T);
            StdOut.println(randomNumber);

            double distanceFromParent = Math.abs(nodes[currentIndex].cumulativeWeight = randomNumber);
            double distanceFromLeftChild = Math.abs(nodes[currentIndex*2].cumulativeWeight - randomNumber);
            double distanceFromRightChild = Double.MAX_VALUE;

            if (currentIndex*2+1 < nodes.length)
                distanceFromRightChild = Math.abs(nodes[currentIndex*2+1].cumulativeWeight - randomNumber);

            int closestChildIndex;
            double distanceFromClosestChild;

            if (distanceFromLeftChild < distanceFromRightChild) {
                closestChildIndex = currentIndex*2;
                distanceFromClosestChild = distanceFromLeftChild;
            } else if (distanceFromRightChild < distanceFromLeftChild){
                closestChildIndex = currentIndex*2+1;
                distanceFromClosestChild = distanceFromRightChild;
            } else {
                int randomChild = StdRandom.uniform(2);
                if (randomChild == 0) {
                    closestChildIndex = currentIndex*2;
                    distanceFromClosestChild = distanceFromLeftChild;
                }else{
                    closestChildIndex = currentIndex*2+1;
                    distanceFromClosestChild = distanceFromRightChild;
                }
            }
            if (distanceFromParent < distanceFromClosestChild) {
                return currentIndex;
            } else {
                currentIndex = closestChildIndex;
            }
        }

        return currentIndex;
    } 

    public void change(int i, double v) {
        double difference = v- nodes[i].weight;
        nodes[i].weight = v;

        T += difference;
        updateCumulativeWeights(i, difference);

    }
    private void computeCumulativeWeights(){
        for (int i = nodes.length-1; i>=2; i--)
            nodes[i/2].cumulativeWeight += nodes[i].cumulativeWeight;
        
    }
    private void updateCumulativeWeights(int startIndex, double difference) {
        while (startIndex >= 1) {
            nodes[startIndex].cumulativeWeight += difference;

            startIndex = startIndex/2;
        }
    }

    public static void main(String[] args) {
        double[] weights = {1,2.2, 3.4, 4.1, 5.9,6};
        Sample sam = new Sample(weights);
        StdOut.println("Random generated indices:");

        sam.show();
        for (int i = 0; i < 20; i++)
        {
            StdOut.println(sam.random());
        }    
        StdOut.println();
        sam.change(4,1);

        StdOut.println("Random generated indices:");
        sam.show();
        for (int i = 0; i < 20; i++)
            StdOut.println(sam.random());
        StdOut.println();
    }

}

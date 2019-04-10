import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
//import java.util.Constants;
//import java.util.StatsUtil;

import java.awt.*;


public class Ex4_1_22 {
    public static void main(String[] args)
    {
        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        final int MAX_BACON = 30;
        int gram_len = MAX_BACON;//G.V()/2 + 1;
        int[] histogram = new int[gram_len];
        int maxFrequency = 0;


        String source = args[2];
        if (!sg.contains(source))
        { return; }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        //while (!StdIn.isEmpty())
        for (int v = 0; v < G.V(); v++)
        {
            //String nominee = sg.name(v);
            //if (sg.contains(nominee))
            {
                int t = v; //sg.index(nominee);
                int Number = bfs.distTo(t)/2;
                //StdOut.println("Number: " + Number);
                int f; 
                if (Number == Integer.MAX_VALUE)
                    f = (++histogram[gram_len-1]);
                else
                    f = (++histogram[Number]);
                if (f > maxFrequency)
                    maxFrequency = f;
            }
        }
        drawBaconHistogram(histogram, gram_len, maxFrequency);
        printHistogramValues(histogram, gram_len);

    }
    private static void drawBaconHistogram(int[] histogram, int INFINITY_ID,
            int maxFreq) {
        StdDraw.setCanvasSize(1024, 512);

        int minX = -3;
        int maxX = histogram.length + 2;
        int middleX = minX + (maxX - minX)/2;

        int minY = -7000;
        int maxY = maxFreq + 6000;
        double middleY = minY + (maxY - minY)/2;

        StdDraw.setXscale(minX, maxX);
        StdDraw.setYscale(minY, maxY);

        //labels
        String fontName = "Verdana";
        Font titlesFont = new Font(fontName, Font.PLAIN, 14);
        StdDraw.setFont(titlesFont);

        StdDraw.text(middleX, maxFreq + 3000, "Bacon Histogram");
        StdDraw.text(-2, middleY, "Frequency", 90);
        StdDraw.text(middleX, -5000, "Kevin Bacon Number");

        Font graphLablesFont = new Font(fontName, Font.PLAIN, 10);
        StdDraw.setFont(graphLablesFont);

        int N = histogram.length;
        // Y
        for (int y = 0; y <= maxFreq; y += 2000){
            StdDraw.text(-0.8, y, String.valueOf(y));
        }
        // X
        for (int x = 0; x < N; x++){
            String label;
            if (x != INFINITY_ID)
                label = String.valueOf(x);
            else
                label = "Infinite";
            StdDraw.text(x, -2000, label);
            double dbx = 1.0*x/N;
            double dby = histogram[x]*2000;
            double dbrw = 0.5/N;
            double dbrh = histogram[x]*2000;
            StdDraw.filledRectangle(dbx, dby, dbrw, dbrh);
        }
        //StatsUtil.plotBars(histogram, 0.25);


    }

    private static void printHistogramValues(int[] histogram, int INFINITY_ID){
        for (int i = 0; i < histogram.length; i++){
            if (histogram[i] == 0)
                break;
            StdOut.printf("Kevin Bacon number %3d: %8.0f\n", i, 
                    histogram[i]);
        }
        StdOut.printf("Infinite: %8.0f\n", histogram[INFINITY_ID]);
    }

}

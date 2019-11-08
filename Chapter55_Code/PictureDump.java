import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.Picture;
import java.awt.Color;

public class PictureDump {
    private PictureDump() {}

    public static void main(String[] args){
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        Picture picture = new Picture(width, height);
        int count = 0;
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                if (!BinaryStdIn.isEmpty()){
                    ++count;
                    boolean bit = BinaryStdIn.readBoolean();
                    if (bit) picture.set(col, row, Color.BLACK);
                    else     picture.set(col, row, Color.WHITE);
                }
                else {
                    picture.set(col, row, Color.RED);
                }
            }
        }
        picture.show();
        StdOut.println(count + " bits");
    }
}

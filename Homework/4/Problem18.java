/*
This is a program designed to take an integer N
and generate a N*N checkerboard tile of red and black
 sqaures, with the lower left tile being red.

Compile: javac -cp .:stdlib.jar Problem18.java

Run: java -cp .:stdlib.jar Problem18 N

*/

public class Problem18 {
    public static void main(String[] args) {

        // the user input for the size of the board
        int N = Integer.parseInt(args[0]);

        // sets the size of the image
        StdDraw.setXscale(-1,N+1);
        StdDraw.setYscale(-1,N+1);

        // generates the checkerboard
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(i,j,0.5);
                }
                else {
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.filledSquare(i,j,0.5);
                }
            }
        }
    }
}

/*
This is a program that takes an integer N and a
double p and generates N points evenly spaced
on the unit circle, then with probability p for
each point, draws a line connecting the points.

Compile: javac -cp .:stdlib.jar Problem19.java

Run: java -cp .:stdlib.jar Problem19 N p

*/

public class Problem19 {
    public static void main(String[] args) {

        // reads in the user inputs
        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);

        // sets the scale for the image
        StdDraw.setXscale(-1.5,1.5);
        StdDraw.setYscale(-1.5,1.5);

        // creates arrays for the x and y values
        double[] x = new double[N];
        double[] y = new double[N];

        // makes the pen larger for the points
        StdDraw.setPenRadius(.01);

        // enables double buffering to draw all points at once
        StdDraw.enableDoubleBuffering();

        // generates all of the points with basic trig
        for (int i = 0; i < N; i++) {
            x[i] = Math.cos(2*Math.PI/N * i);
            y[i] = Math.sin(2*Math.PI/N * i);
            StdDraw.point(x[i],y[i]);
        }

        // draws all the points at once
        StdDraw.show();

        // resets the pen size
        StdDraw.setPenRadius();

        // generates lines between points based on p
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    double r = Math.random();
                    if (r <= p) {
                        StdDraw.line(x[i],y[i],x[j],y[j]);
                        StdDraw.pause(45);
                        StdDraw.show();
                    }
                }
            }
        }

    }
}

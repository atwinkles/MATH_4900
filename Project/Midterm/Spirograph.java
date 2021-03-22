/*
* Spirograph
* Alexander Winkles
*
* This is a program that draws curves based on the concept of a 
* spirograph, a drawing toy.
*
* Input:
*   g - the type of image created (0, 1, or 2)
*   R - the radius of the fixed circle
*   r - the radius of the moving circle
*   a - the length of the line for drawing
*   t - the elapsed time of the drawing
*
* Output: An animation of the spirograph drawing curves.
*
* Compile: javac -cp .:stdlib.jar Spirograph.java
*
* Run: java -cp .:stdlib.jar Spirograph g R r a t
*
* Examples:
*   g == 0
*   180 55 20
*   20 100 20
*   200 100 59
*   100 175 99
*   100 131 50
*
*   g == 1
*   5 3 2    
*   3 1 2
*
*/
public class Spirograph {

    public static void main(String[] args) {
        int g = Integer.parseInt(args[0]); // type of image created
        double R = Double.parseDouble(args[1]); // fixed circle radius
        double r = Double.parseDouble(args[2]); // moving circle radius
        double a = Double.parseDouble(args[3]); // length of line for drawing
        int t = Integer.parseInt(args[4]); // time elapsed

        if (g == 0) { // epicycloid (spirograph)

            // sets the scale of the drawing based on input values
            StdDraw.setXscale(-(R+2*r+a),R+2*r+a);
            StdDraw.setYscale(-(R+2*r+a),R+2*r+a);
            StdDraw.enableDoubleBuffering();

            // drawing iteration until time is exceeded
            for (int i = 0; i < t * 100; i += 1) {
                // draws fixed circle
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.circle(0,0,R);
                // draws moving circle
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.circle((R+r) * Math.cos(i/100.0),(R+r) * Math.sin(i/100.0),r);
                // computes points
                double x = (R+r) * Math.cos(i/100.0) - (r+a) * Math.cos(((R+r)/r)*(i/100.0));
                double y = (R+r) * Math.sin(i/100.0) - (r+a) * Math.sin(((R+r)/r)*(i/100.0));
                // draws line
                StdDraw.line((R+r) * Math.cos(i/100.0),(R+r) * Math.sin(i/100.0),x,y);
                // draws all points computed thus far
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.point(x,y);
                StdDraw.show();
                StdDraw.pause(1);
                StdDraw.clear(StdDraw.BLACK);
            }
        }
        else if (g == 1) { //hypotrochoid

            // essentially the same code as above, with different equations
            StdDraw.setXscale(-(R+2*r+a),R+2*r+a);
            StdDraw.setYscale(-(R+2*r+a),R+2*r+a);
            StdDraw.enableDoubleBuffering();

            double[][] points = new double[t * 100][2];
        
            for (int i = 0; i < t * 100; i += 1) {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.circle(0,0,R);
                StdDraw.setPenColor(StdDraw.BLACK);
                points[i][0] = (R-r) * Math.cos(i/100.0) + (r+a) * Math.cos((R-r)/r*(i/100.0)); 
                points[i][1] = (R-r) * Math.sin(i/100.0) - (r+a) * Math.sin((R-r)/r*(i/100.0)); 
                StdDraw.circle((R-r) * Math.cos(i/100.0),(R-r) * Math.sin(i/100.0),r);
                StdDraw.line((R-r) * Math.cos(i/100.0),(R-r) * Math.sin(i/100.0),points[i][0],points[i][1]);
                StdDraw.setPenColor(StdDraw.RED);
                for (int j = 0; j <= i; j += 1) {
                    StdDraw.point(points[j][0],points[j][1]);
                }
                StdDraw.show();
                StdDraw.pause(1);
                StdDraw.clear();
            }

        }

        else if (g == 2) { //epitrochoid

            StdDraw.setXscale(-(R+2*r+a),R+2*r+a);
            StdDraw.setYscale(-(R+2*r+a),R+2*r+a);
            StdDraw.enableDoubleBuffering();

            double[][] points = new double[t * 100][2];
        
            for (int i = 0; i < t * 100; i += 1) {
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.circle(0,0,R);
                StdDraw.setPenColor(StdDraw.BLACK);
                points[i][0] = (R+r) * Math.cos(i/100.0) - (a) * Math.cos((R+r)/r*(i/100.0)); 
                points[i][1] = (R+r) * Math.sin(i/100.0) - (a) * Math.sin((R+r)/r*(i/100.0)); 
                StdDraw.circle((R+r) * Math.cos(i/100.0),(R+r) * Math.sin(i/100.0),r);
                StdDraw.line((R+r) * Math.cos(i/100.0),(R+r) * Math.sin(i/100.0),points[i][0],points[i][1]); 
                StdDraw.setPenColor(StdDraw.RED);
                for (int j = 0; j <= i; j += 1) {
                    StdDraw.point(points[j][0],points[j][1]);
                }
                StdDraw.show();
                StdDraw.pause(1);
                StdDraw.clear();
            }

        }

    }

}
        

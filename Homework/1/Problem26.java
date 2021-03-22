/*
* Problem 1.2.26
*
* Author: Alexander Winkles
*
* Purpose: This program converts Cartesian to polar coordinates.
*
* Complie: javac Problem26.java
*
* Input: Takes two real numbers x and y (Cartesian coords.) from the command line
*
* Output: Returns the polar coordinates corresponding to inputs
*
* Run: java Problem26
*
* Examples:
*   1. (1.0, 0.0) --> (1.0, 3.1415)
*   2. (0.0, 1.0) --> (1.0, 1.57079)
*
*/

public class Problem26 {
    public static void main(String[] args) {
        
        // assigns values from the command line to x and y

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);

        // computes r and theta, the polar coordinates

        double r = Math.sqrt(x*x + y*y);
        double theta = Math.atan2(y,x);
    
        // adjusts theta to be in the range [0,2*PI] rather than [-PI,PI]
        
        if (theta < 0) {
            theta += 2*Math.PI;
        }

        // returns results nicely

        System.out.println("(" + x + ", " + y + ") in polor coordinates are (" + r + ", " + theta + ").");

    }
}

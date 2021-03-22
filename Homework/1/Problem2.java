/*
*   Problem 1.2.2
*
*   Author: Alexander Winkles
*
*   Purpose: This code computes the value of sin^2(theta)+sin^2(theta) and
*               returns its difference from 1 to confirm that Java approximates
*               trigonometric functions properly.
*
*   Compile: javac Problem2.java
*
*   Input: A command line argument of type double.
*
*   Output: A double value representing the difference of sin^2(theta)+sin^2(theta)
*           and 1.
*
*   Run: java Problem2 args[0]
*
*   Examples:
*       1. 3.1415 --> 0.0
*       2. 278 --> -1.1102e-16
*/

public class Problem2 {
    public static void main(String[] args) {

        // Reads in the command line value and assigns it to the variable theta

        double theta = Double.parseDouble(args[0]);

        // Performs a comparison of sin^2(theta)+cos^2(theta) and 1.

        double result = Math.sin(theta)*Math.sin(theta) + Math.cos(theta)*Math.cos(theta) - 1.0;

        System.out.println("1 - sin^2(theta)+cos^2(theta) = " + result);

    }
}

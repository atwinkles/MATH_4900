/*
* Problem 1.3.2
*
* Author: Alexander Winkles
*
* Purpose: To find roots to polynomials using the quadratic formula
*
* Complie: javac Problem2.java
*
* Input: doubles a,b,c representing ax^2+bx+c
*
* Output: the roots of the polynomail or an error message
*
* Run: java Problem2
*
*/

public class Problem2 {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        if (a != 0) {

            double determinent = b*b - 4*a*c;

            if (determinent < 0) {
                System.out.println("\nThis quadratic equation does not have real solutions.\n");
            }
            else if (determinent == 0) {
                double root = -1*b / (2.0*a);
                System.out.println("\nThe solution is " + root + ".\n");
            }
            else {
                double d = Math.sqrt(determinent);
                double root1 = (-b + d) / (2.0*a);
                double root2 = (-b - d) / (2.0*a);
            
                System.out.println("\nThe solutions are " + root1 + " and " + root2 + ".\n");
            }
        }

        else {

            System.out.println("\nThe solution is " + c/b + ".\n");

        }

    }
}


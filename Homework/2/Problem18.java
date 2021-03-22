/*
* Problem 1.3.18
*
* Author: Alexander Winkles
*
* Purpose: To use Newton's method and find the kth root of N.
*
* Complie: javac Problem18.java
*
* Input: int k, N, S representing the kth root desired, the number N, and the number S iterations; double x for initial guess
*
* Output: A print statement
*
* Run: java Problem18 k N S x
*
*/

public class Problem18 {
    public static void main(String[] args) {

        // command line inputes for k, N, S, and x

        int k = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        int S = Integer.parseInt(args[2]);
        double x = Double.parseDouble(args[3]);
    
        // T is the error threshold 

        double T = 1.0E-15;
        double error;

        int i = 1;

        // added for nicely printed results

        System.out.println("\nStep\t\tResult\n---\t\t-----------");

        // the loop that iterates through Newton's method until either the number of iterations allowed is passed
        // or the result error is smaller than T
        
        while (i <= S) {
            x = x - (Math.pow(x,k) - N)/(k*Math.pow(x,k-1));
            System.out.println(i + "\t\t" + x);
            if (Math.abs(Math.pow(x,k)-N) < T) {
                break;
            }
            i++;
        }
    
        error = N - Math.pow(x,k);

        System.out.println("\nThe " + k + "th root of " + N + " is " + x + " with an error of " + error + "\n");

    }
}

/*
* Problem 1.4.15
*
* Purpose: To perform array multiplication on random boolean arrays of size NxN
*
* Complie: javac Problem15.java
*
* Input: integer N for size of the NxN array
*
* Output: A print statement of boolean arrays
*
* Run: java Problem15
*
*/

// take in from command line using some parsing fun
import java.util.*;
public class Problem15 {
    public static void main(String[] args) {

        // command line argument for the size of the matrices
        int N = Integer.parseInt(args[0]); 

        boolean[][] a = randomarray(N);
        boolean[][] b = randomarray(N);

        // creates a new boolean array using "matrixmult" methods defined below
        boolean[][] c = matrixmult(a,b);

        printarray(a);        
        printarray(b);
        printarray(c);

    }

    // define a method to perform boolean array multiplication
    public static boolean[][] matrixmult(boolean[][] a, boolean[][] b) {

        //finds the size of the arrays being multiplied
        int N = a.length;
        //initializes a new boolean array of the proper size
        boolean[][] c = new boolean[N][N];

        // performs the boolean array multiplication with 
        // && for * and || for +
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    c[i][j] = (c[i][j] || (a[i][k] && b[k][j]));
                }
            }
        }

        return c; 

    }

    public static boolean[][] randomarray(int n) {
        
        // declares boolean arrays to use
        boolean[][] a = new boolean[n][n];

        // boolean arrays initialize with false elements
        // this goes through each element and randomly assigns
        // a true or false value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double randomize = Math.random();
                if (randomize < 0.5) {
                    a[i][j] = true;
                }
                else {
                    a[i][j] = false;
                }
            }
        }
        return a;

    }

    // a method designed to print the array nicely
    public static String printarray(boolean[][] a) {
        int N = a.length;

        System.out.print("[");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N-1) {
                    if (i != N-1) { 
                        System.out.println(a[i][j]);
                    }
                    else {
                        System.out.println(a[i][j] + "]\n");
                    }
                }
                else {
                    System.out.print(a[i][j] + ", ");
                }
            }
        }
        return "";
    }

}

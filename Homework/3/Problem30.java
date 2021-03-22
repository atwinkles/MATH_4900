/*
* Problem 1.4.30
*
* Purpose: Creates minesweeper arrays, with and without numbers
*
* Complie: javac Problem30.java
*
* Input: integer M and N for size of MxN array, integer p for probability of mine
*
* Output: print statements of arrays
*
* Run: java Problem30
*
*/

public class Problem30 {
    public static void main(String[] args) {
    
        // reads in M, N, and p
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        double p = Double.parseDouble(args[2]);

        // declares a minefield array
        boolean[][] minefield = new boolean[M+2][N+2];

        // goes through minefield array and randomly places bombs based on p
        for (int i = 1; i < M+1; i++) {
            for (int j = 1; j < N+1; j++ ) {
                double r = Math.random();
                if (r < p) {
                    minefield[i][j] = true;
                    if (j == N) {
                        System.out.println("* ");
                    }
                    else {
                        System.out.print("* ");
                    }
                }
                else {
                    if (j == N) {
                        System.out.println(". ");
                    }
                    else {
                        System.out.print(". ");
                    }
                }
            }
        }

        // prints minefield
        System.out.println();

        // prints minefield with numbers
        for (int i = 1; i < M+1; i++) {
            for (int j = 1; j < N+1; j++ ) {
                if (minefield[i][j] == false) {
                    int count = 0;
                    for (int k = i-1; k <= i+1; k++) {
                        for (int l = j-1; l <= j+1; l++) {
                            if (minefield[k][l] == true) {
                                count++;
                            }
                        }
                    }
                    if (j == N) {
                        System.out.println(count + " ");
                    }
                    else {
                        System.out.print(count + " ");
                    }
                }
                else {
                    if (j == N) {
                        System.out.println("* ");
                    }
                    else {
                        System.out.print("* ");
                    }
                }
            }
        }
        
    }
}

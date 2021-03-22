/*
* Problem 1.4.32
*
* Purpose: A three-dimensional self avoiding walk simulation
*
* Complie: javac Problem32.java
*
* Input: integer N for size of NxNxN lattice, T for number of trials
*
* Output: A print statement of results
*
* Run: java Problem32
*
*/

public class Problem32 {
    public static void main(String[] args) {

        // reads in the input values
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        
        // variables for computing statistics 
        int deadEnds = 0;
        int loseMoves = 0;
        int totalMoves = 0;
        int winMoves = 0;

        // performs the trials
        for (int t = 0; t < T; t++) {
            int moves = 0;
            boolean[][][] a = new boolean[N][N][N];
            int x = N/2, y = N/2, z = N/2;

            // lose conditions for walk
            while (x > 0 && x < N-1 && y > 0 && y < N-1 && z > 0 && z < N-1) {
                a[x][y][z] = true;
                if (a[x-1][y][z] && a[x+1][y][z] && a[x][y-1][z] && a[x][y+1][z] && a[x][y][z-1] && a[x][y][z+1]) {
                    deadEnds++;
                    loseMoves += moves;
                    break;
                }
                double r = Math.random();
                if (r < 0.16666666666666666) {
                    if (!a[x+1][y][z]) {
                        x++;
                        moves++;
                        totalMoves++;
                    }
                }
                else if (r < 0.3333333333333333) {
                    if (!a[x-1][y][z]) {
                        x--;
                        moves++;
                        totalMoves++;
                    }
                }
                else if (r < 0.50) {
                    if (!a[x][y+1][z]) {
                        y++;
                        moves++;
                        totalMoves++;
                    }
                }
                else if (r < 0.6666666666666666) {
                    if (!a[x][y-1][z]) {
                        y--;
                        moves++;
                        totalMoves++;
                    }
                }
                else if (r < 0.8333333333333333) {
                    if (!a[x][y][z+1]) {
                        z++;
                        moves++;
                        totalMoves++;
                    }
                }
                else if (r < 1.0) {
                    if (!a[x][y][z-1]) {
                        z--;
                        moves++;
                        totalMoves++;
                    }
                }
            }
        }
        
        // prints results
        winMoves = totalMoves - loseMoves;
        System.out.println(100*deadEnds/T + "% dead ends");
        System.out.println(winMoves/(T-deadEnds) + " moves on average for a win");
        System.out.println(loseMoves/deadEnds + " moves on average for a dead end");
    }
}

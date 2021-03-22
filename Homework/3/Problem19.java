/*
* Problem 1.4.19
*
* Purpose: A modification of SelfAvoidingWalk that calculates the
*           average rectangle size containing the path
*
* Complie: javac Problem19.java
*
* Input: integer N for size of grid and integer T for number of trials
*
* Output: print statements of results
*
* Run: java Problem19
*
*/

public class Problem19 {
    public static void main(String[] args) {

        // reads in the size of grid and number of trials
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);

        // variables needed to obtain results
        int deadEnds = 0;
        int winArea = 0;
        int deadEndArea = 0;
        int loseMoves = 0;
        int totalMoves = 0;
        int winMoves = 0;

        // creates a boolean array for each trial
        for (int t = 0; t < T; t++) {
            int moves = 0;
            boolean[][] a = new boolean[N][N];
            int distMaxX = N/2, distMaxY = N/2, distMinX = N/2, distMinY = N/2;
            int x = N/2, y = N/2;
            while (x > 0 && x < N-1 && y > 0 && y < N-1) {
                a[x][y] = true;

                // declares lose conditions
                if (a[x-1][y] && a[x+1][y] && a[x][y-1] && a[x][y+1]) {
                    deadEnds++;
                    deadEndArea += (distMaxX-distMinX)*(distMaxY-distMinY);
                    loseMoves += moves;
                    break;
                }

                // generates a random move while the trial has not lost
                double r = Math.random();
                if (r < 0.25) {
                    if (!a[x+1][y]) {
                        x++;
                        moves++;
                        totalMoves++;
                        if (x > distMaxX) {
                            distMaxX += 1;
                        }
                    }
                }
                else if (r < 0.50) {
                    if (!a[x-1][y]) {
                        x--;
                        moves++;
                        totalMoves++;
                        if (x < distMinX) {
                            distMinX -= 1;
                        }
                    }
                }
                else if (r < 0.75) {
                    if (!a[x][y+1]) {
                        y++;
                        moves++;
                        totalMoves++;
                        if (y > distMaxY) {
                            distMaxY += 1;
                        }
                    }
                }
                else if (r < 1.00) {
                    if (!a[x][y-1]) {
                        y--;
                        moves++;
                        totalMoves++;
                        if (y < distMinY) {
                            distMinY -= 1;
                        }
                    }
                }
                if (x == 0 || x == N-1 || y == 0 || y == N-1) {
                    winArea += (distMaxX-distMinX)*(distMaxY-distMinY);
                }      
            }

        }

        // calculates total win moves
        winMoves = totalMoves - loseMoves;

        // prints results
        System.out.println(100*deadEnds/T + "% dead ends");
        if (T - deadEnds != 0) {
            System.out.println(winMoves/(T-deadEnds) + " moves on average for a win");
        }
        else {
            System.out.println("There are not enough wins for meaningful statistics");
        }
        System.out.println(loseMoves/deadEnds + " moves on average for a dead end");
        if (T - deadEnds != 0) {
            System.out.println("The average size of the rectangle that encloses the win path is " + winArea/(T-deadEnds));
        }
        System.out.println("The average size of the rectangle that encloses a dead end is " + deadEndArea/deadEnds);

        
    }
}

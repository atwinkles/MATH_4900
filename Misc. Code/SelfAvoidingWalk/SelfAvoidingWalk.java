public class SelfAvoidingWalk {
    public static void main(String[] args) {
        int gridSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int deadEnd = 0;

        boolean[][] walk = new boolean[gridSize-1][gridSize-1];

        int x = gridSize/2, y = gridSize/2;

        walk[x][y] = true;

        while ( !(walk[x+1][y]) && !(walk[x-1][y]) && !(walk[x][y+1]) & !(walk[x][y-1])) {
            
            

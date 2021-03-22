import java.awt.Color;

public class Tile {

    public static void main(String[] args) {
    
        String filename = args[0];
        int m = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        Picture original = new Picture(filename);
        Picture mini = new Picture(20,30);
        Picture tile = new Picture(m,n);

        for (int targetCol = 0; targetCol < 20; targetCol++) {
            for (int targetRow = 0; targetRow < 30; targetRow++) {
                int sourceCol = targetCol * original.width() / 20;
                int sourceRow = targetRow * original.height() / 30;
                Color color = original.get(sourceCol,sourceRow);
                mini.set(targetCol, targetRow, color);
            }
        }

        mini.save("tile.jpg");

        StdDraw.setXscale(0,m*20);
        StdDraw.setYscale(0,n*30);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StdDraw.picture(i*3,j*3,"tile.jpg");
            }
        }

    } 
}

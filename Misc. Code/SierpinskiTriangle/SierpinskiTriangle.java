public class SierpinskiTriangle {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        StdDraw.setXscale(0.0,1.0);
        StdDraw.setYscale(0.0,1.0);

        double[] cx = {0.0, 0.5, 1.0};
        double[] cy = {0.0, 0.833, 0.0};

        double x = 0.0, y = 0.0;

        for (int i = 0; i < N; i++) {
            int s = (int) (Math.random()*3);
            x = (x + cx[s])/2.0;
            y = (y + cy[s])/2.0;
            StdDraw.point(x,y);
        }
    }
}     

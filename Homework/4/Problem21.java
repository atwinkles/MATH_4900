public class Problem21 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);

        StdDraw.setXscale(-1,1);
        StdDraw.setYscale(-1,1);

        for (double i = 0.0; i < 2*Math.PI; i+= 0.001) {
            StdDraw.point(Math.sin(N*i)*Math.cos(i),Math.sin(N*i)*Math.sin(i));
        }
    }
}

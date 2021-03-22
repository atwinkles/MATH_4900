public class Problem26 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        double p = Double.parseDouble(args[1]);
        double r = Double.parseDouble(args[2]);
        double R = Double.parseDouble(args[3]);

        for (int i = 0; i < N; i++) {
            double x = randomWithRange(0,1);
            double y = randomWithRange(0,1);
            double radius = randomWithRange(r,R);
            double color = Math.random();
            if (color <= p) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledCircle(x,y,radius);
            }
            else {
                StdDraw.setPenColor(StdDraw.WHITE);
                StdDraw.filledCircle(x,y,radius);
            }
                
        }
    }

    public static double randomWithRange(double min, double max) {
        double range = (max - min);
        return ((Math.random() * range) + min);
    }
}

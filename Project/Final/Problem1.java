
public class Problem1 {

    // this method generates an array of N random points in a square of length 10
    public static double[][] generateArray(int N) {
        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) { 
            points[i][0] = Math.random()*10;
            points[i][1] = Math.random()*10;
        }
        return points;
    }

    // this method finds the largest/smallest x/y value in a 2D array
    //
    // if q1 == 0, method finds max value -- otherwise finds min
    // if q2 == 0, method searches through y values -- otherwise x
    public static double arrayValue(double[][] points, int q1, int q2) {
        int N = points.length;
        double value;
        // max value
        if (q1 == 0) {
            value = Double.NEGATIVE_INFINITY;
            // y value
            if (q2 == 0) {
                for (int i = 0; i < N; i++) {
                    if (points[i][1] > value) value = points[i][1];
                }
            }
            // x value
            else {
                for (int i = 0; i < N; i++) {
                    if (points[i][0] > value) value = points[i][1];
                }
            }
        }
        // min value
        else {
            value = Double.POSITIVE_INFINITY;
            // y value
            if (q2 == 0) {
                for (int i = 0; i < N; i++) {
                    if (points[i][1] < value) value = points[i][1];
                }
            }
            // x value
            else {
                for (int i = 0; i < N; i++) {
                    if (points[i][0] < value) value = points[i][1];
                }
            }
        }
        return value;
    }

    // this method reads in an array of points then orders them in a certain
    // way that will be used to draw a simple polygon from them
    public static double[][] generatePolygon(double[][] points) {

        // finds how many points there are
        int N = points.length;
    
        // generates two arrays, one to hold the ordered points
        // and another to check which points have already been used
        double[][] polyPoints = new double[N][2];
        boolean[] pointsUsed = new boolean[N];

        /*
        // finds the point closest to the coordinate (0,0)
        int minPoint = 0;
        for (int i = 1; i < N; i++) {
            if (Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]) < Math.sqrt(points[minPoint][0]*points[minPoint][0] + points[minPoint][1]*points[minPoint][1])) minPoint = i;
        }
        polyPoints[0][0] = points[minPoint][0];
        polyPoints[0][1] = points[minPoint][1];
        pointsUsed[minPoint] = true;
        */

        int tmpNum = 0;
        for (int i = 1; i < N; i++) {
            if (points[i][1] < points[tmpNum][1]){
                tmpNum = i;
            }
        }   

        int minPoint = tmpNum;
        polyPoints[0][0] = points[minPoint][0];
        polyPoints[0][1] = points[minPoint][1];
        pointsUsed[minPoint] = true;

        // sets the current point
        int current = minPoint;

        // starts a count to know where to place ordered points
        int count = 0;

        // variable set to false until all points have been ordered
        boolean finish = false;

        // first iteration, starts on the bottom left and goes up the left side of points
        while (points[current][1] < arrayValue(points,0,0)) {
            int tmp = 0;
            //double tmpN = Double.POSITIVE_INFINITY;
            double tmpN = Double.NEGATIVE_INFINITY;
            for (int i = 0; i < N; i++) { // i think it breaks here?
                if (i != current && points[i][1] > points[current][1] && points[i][0] < points[current][0] && points[i][0] > tmpN) {
                //if (i != current && points[i][1] > points[current][1] && points[i][0] < tmpN) {
                    tmp = i;
                    tmpN = points[i][0];
                }
            }
            current = tmp;
            count++;
            polyPoints[count][0] = points[current][0]; //issues arise here
            polyPoints[count][1] = points[current][1];
            pointsUsed[current] = true;
        }

        // second iteration - goes from highest point down until all points have been ordered
        while(!finish) {
            double tmp = Double.NEGATIVE_INFINITY;
            int tmpN = 0;
            for (int i = 0; i < N; i++) {
                if (i != current && points[i][1] < points[current][1] && pointsUsed[i] != true && points[i][1] > tmp) {
                    tmp = points[i][1];
                    tmpN = i;
                }
            }
            current = tmpN;
            count++;
            polyPoints[count][0] = points[current][0]; //issues arise here
            polyPoints[count][1] = points[current][1];
            pointsUsed[current] = true;
            boolean tmpFinish = true;
            for (int i = 0; i < N; i++) {
                tmpFinish = tmpFinish && pointsUsed[i];
            }
            finish = tmpFinish;
        }

        return polyPoints;

    }

    // method that takes in an array of points and returns a nice graphic
    // of the points, then draws lines connecting them all
    public static void drawArray(double[][] points) {
        int N = points.length;
        StdDraw.setScale(0,10);
        StdDraw.setPenRadius(.02);
        for (int i = 0; i < N; i++) {
            StdDraw.point(points[i][0],points[i][1]);
        }

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.setPenRadius(.001);
        StdDraw.line(0,5,10,5);
        StdDraw.line(5,0,5,10);
        StdDraw.setPenRadius(.005);
        for(int i = 0; i <= 10; i++){
            StdDraw.point(i,5);
            StdDraw.point(5,i);
        }

        StdDraw.pause(200);
        //StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.005);
        for (int i = 0; i < N-1; i++) {
            StdDraw.line(points[i][0],points[i][1],points[i+1][0],points[i+1][1]);
            StdDraw.pause(100);
        }
        StdDraw.line(points[points.length-1][0],points[points.length-1][1],points[0][0],points[0][1]);

    }

    // main method
    public static void main(String[] args) {
//        int N = Integer.parseInt(args[0]);
//        double[][] values = generateArray(N);

//        double[][] values = {{1.848,0.713},{6.767,5.889},{5.382,8.464},{7.639,9.113},{4.381,6.605},{9.523,6.338},{9.281,1.065},{4.959,3.750},{8.126,4.146},{6.611,5.089}};
        double[][] values = {{9.514,4.369},{1.357,3.151},{1.188,3.523},{9.917,1.380},{8.324,8.315},{3.059,0.434},{1.009,6.891},{8.337,5.073},{2.926,2.943},{6.833,6.603}};
        int N = values.length;

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++){
                System.out.printf("%.3f  ",values[j][i]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        double[][] result = generatePolygon(values);

        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++){
                System.out.printf("%.3f  ",result[j][i]);
            }
            System.out.println();
        }
//        drawArray(values);
        drawArray(result);


    }
}

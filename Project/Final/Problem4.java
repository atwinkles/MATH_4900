/*
A Java program that reads in an integer N and changes a string "0" N times
by turning 0s into 01 and and 1s into 10, then displays a graphic of the
final string.

Compile: javac -cp .:stdlib.jar Problem4.java
Run: java -cp .:stdlib.jar Problem4 N
*/
public class Problem4 {

    // method that reads in a string of 0s and 1s and converts them
    // to a new string by replacing the 0s with 01 and the 1s with 10
    public static String stringConvert(String s) {
        int N = s.length();
        String result = "";
        for(int i = 0; i < N; i++) {
            if (s.charAt(i) == '0') result += "01";
            else result += "10";
        }
        return result;
    }

    // method that draws the results of the final string based on
    // moving forward by a unit if there is a 1 and rotating by
    // -pi/3 if there is a 0
    public static void drawResult(String s,int N) {
        double x = 0;
        double y = 0;
        double angle = 0;
        StdDraw.setXscale(-1,s.length()/(N*N/4));
        StdDraw.setYscale(-s.length()/(N*N/4),1);
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(x,y);
        StdDraw.setPenColor(StdDraw.BLACK);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') angle -= Math.PI/3.;
            else {
                x += Math.cos(angle);
                y += Math.sin(angle);
                StdDraw.point(x,y);
            }
        }

    }

    // the main method, starting with a string of 0
    public static void main(String[] args) {
        String number = "0";

        // reads in the number of iterations to do
        int N = Integer.parseInt(args[0]);

        int count = 0;
        while (count <= N-1) {
            System.out.println(number);
            number = stringConvert(number);
            count++;
        }

        drawResult(number,N);

    }
}

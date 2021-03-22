/*
A Java program that uses Newton's method to find the zeros of
sin(x^2)-cos(x^3) in the domain [0,pi]

Compile: javac Problem5.java
Run: java Problem5
*/
import java.util.Arrays;
public class Problem5 {

    // method that runs Newton's method on a double until either the number 
    // converges or the number of max iterations is exceeded
    // if exceeded, returns negative infinity
    public static double NewtonIteration(double x) {
        double tolerance = 1e-14;
        int maxCount = 1000;
        int count = 0;
        while (Math.abs(Math.sin(Math.pow(x,2)) - Math.cos(Math.pow(x,3))) > tolerance) {
            double func = Math.sin(Math.pow(x,2)) - Math.cos(Math.pow(x,3));
            double dfunc = 2*x*Math.cos(Math.pow(x,2)) + 3*Math.pow(x,2)*Math.sin(Math.pow(x,3));
            x = x - func / dfunc;
            count++;
            if (count > maxCount) return Double.NEGATIVE_INFINITY;
        }
        return x;
    }

    // main method
    public static void main(String[] args) {

        // creates an initial array to store the values
        double[] zeros = new double[1];

        // iterates through all values between (0,pi] to find zeros
        for (double x = 0.01; x <= Math.PI; x += 0.01) {
            // for each value, runs Newton's method
            double z = NewtonIteration(x);
            int arrayCount = 0;
            // checks if the zero found is in the array already
            for(int i = 0; i < zeros.length; i++) {
                if(Math.abs(zeros[i] - z) < 1e-14) arrayCount++;
            }
            // if the zero is not in the array already and is in the
            // proper range, adds it to the array of zeros
            if (arrayCount != 1 && z <= Math.PI && z > 0) {
                if (zeros.length == 1 && zeros[0] == 0.0) {
                    zeros[0] = z;
                }
                else {
                    zeros = Arrays.copyOf(zeros,zeros.length+1);
                    zeros[zeros.length-1] = z;
                }
            }
        }
        System.out.println();
        // prints the values of the zeros
        for(int i = 0; i < zeros.length; i++) {
            System.out.println(zeros[i]);
        }

    }
}

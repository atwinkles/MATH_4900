/*
This is a Java program that will iterate through all odd numbers between
1 and 100 and compute how many times it takes each number to go to 1
under the iteration (3*n+1)/(2^k) where k is some integer.

Compile: javac -cp .:stdlib.jar Problem3.java
Run: java -cp .:stdlib.jar Problem3
*/
public class Problem3 {
    // a method that iterates through the function until it reaches an odd number
    public static int function(int n) {
        int k = 0;
        while ((3*n+1)/(int)(Math.pow(2,k)) % 2 != 1) {
            k++;
        }
        return (3*n+1)/(int)(Math.pow(2,k));
    }
    // main method
    public static void main(String[] args) {
        // creates a 2D array of odd points and how long it takes for them to reach 
        // a value of 1 using the function above
        int[][] result = new int[50][2];
        result[0][0] = 1;
        for (int i = 1; i < 50; i++) {
            result[i][0] = result[i-1][0] + 2;
        }
        // counts how long it takes each odd number to go to 1
        for (int i = 0; i < 50; i++) {
            int count = 0;
            int tmp = result[i][0];
            while (tmp != 1) {
                tmp = function(tmp);
                count++;
            }
            result[i][1] = count;
        }
        // graphs results nicely
        StdDraw.setXscale(-5,105);
        StdDraw.setYscale(-5,55);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.line(0,0,105,0);
        StdDraw.line(0,0,0,105);
        StdDraw.setPenRadius(0.001);
        for (int i = 1; i <= 10; i++) {
            if (i <= 5) StdDraw.line(0,i*10,105,i*10);
            StdDraw.line(i*10,0,i*10,55); 
        }
        StdDraw.setPenColor();
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < 50; i++) {
            StdDraw.point(result[i][0],result[i][1]); 
        }
    }
}

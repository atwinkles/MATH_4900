/*
* Problem 1.3.9
*
* Author: Alexander Winkles
*
* Purpose: To print random values between 0 and 1 as well as the average of them.
*
* Complie: javac Problem9.java
*
* Input: integer testNumber for how many uniform random values there will be
*
* Output: A print statement
*
* Run: java Problem9 testNumber
*
*/

public class Problem9 {
    public static void main(String[] args) {
        int testNumber = Integer.parseInt(args[0]);
    
        double randomValue;
        double result = 0;

        for (int i = 1; i <= testNumber; i++) {
            randomValue = Math.random();
            System.out.println(randomValue);
            result += randomValue;
        }
    System.out.println("\nThe average value for Math.random() after " + testNumber + " trials is: " + (result / testNumber));
    }
}

/*
* Problem 1.2.27
*
* Author: Alexander Winkles
*
* Purpose: This program generatesa random number from the 
*           Gaussian distribution based on the Box-Muller formula.
*
* Complie: javac Problem27.java
*
* Input: None
*
* Output: A random number w.
*
* Run: java Problem27
*
*/

public class Problem27 {
    public static void main(String[] args) {
        
        // Generates random numbers between 0 and 1

        double u = Math.random();
        double v = Math.random();

        // Computes a random number using Box-Muller

        double w = Math.sin(2*Math.PI*v)*Math.sqrt(-2*Math.log(u));

        System.out.println(w);

    }
}

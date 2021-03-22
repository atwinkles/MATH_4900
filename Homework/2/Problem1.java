/*
* Problem 1.3.1
*
* Author: Alexander Winkles
*
* Purpose: To check if three integers are equal or not.
*
* Complie: javac Problem1.java
*
* Input: integers a,b,c
*
* Output: A print statement
*
* Run: java Problem1
*
*/

public class Problem1 {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if ((a == b) && (b == c)) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }
}

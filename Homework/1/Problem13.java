/*
* Problem 1.2.13
*
* Author: Alexander Winkles
*
* Purpose: To demonstrate that methods such as Math.sqrt() return approximate
*           answers rather than exact values.
*
* Complie: javac Problem13.java
*
* Input: None
*
* Output: A print statement
*
* Run: java Problem13
*
*/
public class Problem13 {
    public static void main(String[] args) {

        boolean result = (Math.sqrt(2)*Math.sqrt(2) == 2);

        System.out.println("The result of Math.sqrt(2)*Math.sqrt(2) == 2 is " + result);

    }
}

/*
* Problem 1.3.8
*
* Author: Alexander Winkles
*
* Purpose: Prints integers from 1001 to 2000 five at a time
*
* Complie: javac Problem8.java
*
* Input: none
*
* Output: print statements
*
* Run: java Problem8
*
*/

public class Problem8 {
    public static void main(String[] args) {
        for (int i = 1001; i <= 2000; i++) {
            if ((i % 5 == 0) && (i != 1000)) {
                System.out.println(i + " ");
            }
            else {
                System.out.print(i + " ");
            }
        }
    }
} 

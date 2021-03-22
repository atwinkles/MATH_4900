/*
* Problem 1.2.19
*
* Author: Alexander Winkles
*
* Purpose: This program takes two integers from the command line and returns a
*           random interger between them.
*
* Complie: javac Problem19.java
*
* Input: int a, b
*
* Output: An integer between a and b
*
* Run: java Problem19
*
*/

public class Problem19 {
    public static void main(String[] args) {

        // takes integers from the command line and assigns them to a and b
        
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // creates a new variable that generates a random double between a and b

        double randomGenerator = (b-a)*Math.random() + a;

        // rounds the result from above to an integer

        long result = Math.round(randomGenerator);

        System.out.println(result);

    }
}

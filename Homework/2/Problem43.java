/*
* Problem 1.3.43
*
* Author: Alexander Winkles
*
* Purpose: To study a simple model for population growth wtih a fecundity parameter.
*
* Complie: javac Problem43.java
*
* Input: doubles x, r standing for initial population and fecundity; int t for time passed.
*
* Output: print statements showing the population over time
*
* Run: java Problem43 x r t
*
*/

public class Problem43 {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double r = Double.parseDouble(args[1]);
        int t = Integer.parseInt(args[2]);

        System.out.println("Time\t\tPopulation\n----\t\t------------------\n" + 0 + "\t\t" + x);
        
        for (int i = 0; i <= t; i++) {
            x = r*x*(1-x);
            if (x < 0) {
                System.out.println(i + "\t\t" + 0);
                break;
            }
            System.out.println(i + "\t\t" + x);
            
            if ((x == (1-1/r))) {
                System.out.println("\nFor value " + r + " the system stabilizes!\n");
                break;
            }

        }
    }
}

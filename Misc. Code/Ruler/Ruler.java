/**
This is a program written by Alexander Winkles that takes an
integer from the command line and produces a "ruler" of values.
Ruler takes a command line argument of either 0 or 1. If 0 is given, 
the values of the ruler are returned. If 1 is given, a visual
representation is returned of the ruler.
*/

import java.util.Scanner;

public class Ruler {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n == 0) {
            System.out.println("\nPlease input the integer you would like to use for your ruler: ");

            Scanner keyboard = new Scanner(System.in);

            int rulerLength = keyboard.nextInt();

            System.out.println("");

            String ruler  = " 1 ";

            final long startTime = System.currentTimeMillis();

            for (int i=2; i<=rulerLength; i++) {
            System.out.println(ruler);
            ruler = ruler + " " + Integer.toString(i) + " " + ruler;
            }
            System.out.println(ruler);

            final long endTime = System.currentTimeMillis();

            System.out.println("\nTotal excecution time: " + (endTime - startTime) + " milliseconds.\n");
        }
    }
}

/*
This program is designed to take an input N and then a sequence of N-1 distinct
integers between 1 and N and find the missing integer.

Compile: javac -cp .:stdlib.jar Problem7.java

Run: java -cp .:stdlib.jar Problem7 N
(input sequence)

Example:
Input: 5
        2 4 5 3
Output: You are missing 1!
*/

public class Problem7 {
    public static void main(String[] args) {
    
        int N = Integer.parseInt(args[0]);
        int[] range = new int[N];
        for (int i = 1; i <= N; i++) {
            range[i-1] = i;
        }

        System.out.println("Please type N-1 distinct integers between 1 and " + N + ":");

        while (!StdIn.isEmpty()) {
            int t = StdIn.readInt();
            for (int i = 0; i < N; i++) {
                if (t == range[i]) { 
                    range[i] = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (range[i] != 0) {
                System.out.println("You are missing " + range[i] + "!");
                System.exit(0);
            }
        }
    }
}

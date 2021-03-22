/*
This is a program designed to take a sequence of integers and 
find the longest consecutive list of them.

Compile: javac -cp .:stdlib.jar Problem5.java

Run: java -cp .:stdlib.jar Problem5
(input sequence)

Example:
Input: 1 2 2 1 5 1 1 7 7 7 7 1
Output: Longest run: 4 consecutive 7s
*/

public class Problem5 {
    public static void main(String[] args) {

        // Reads in first value of sequence and starts a count
        int count = 1;
        int totalCount = 0;
        int value = StdIn.readInt();
        int totalValue = value;
        
        // runs until all inputs have been read
        while (!StdIn.isEmpty()) {
            int t = StdIn.readInt();

            // if new input is the same as previous, adds to counter
            if (t == value) {
                count++; 
            }
            // otherwise, changes value and resets counter
            else {
                // if current counter is bigger than the overall counter, replaces value with new one
                if (count > totalCount) {
                    totalValue = value;
                    totalCount = count;
                }
                value = t;
                count = 1;
            }
        }

        // prints results
        System.out.println("Longest run: " + totalCount + " consecutive " + totalValue + "s");
    }
}

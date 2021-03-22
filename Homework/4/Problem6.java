/*
This is a program designed to take a sequence
of integers and return the sequence with no
repeats.

Compile: javac -cp .:stdlib.jar Problem6.java

Run: java -cp .:stdlib.jar Problem6
(input sequence)

Example:
Input: 1 2 2 1 5 1 1 7 7 7 7 1 1 1 1 1 1 1 1 1 1
Output: 1 2 1 5 1 7 1
*/
public class Problem6 {
    public static void main(String[] args) {

        String result = "";
        int valueOne = StdIn.readInt(); 
        result += valueOne + " ";

        while (!StdIn.isEmpty()) {
            int valueTwo = StdIn.readInt();
            if (valueTwo == valueOne) {
                continue;
            }
            else {
                result += valueTwo + " ";
                valueOne = valueTwo;
            }
        }

        System.out.println(result);

    }
} 

/* An example of a program which takes an argument and prints it out as follows:

    java CommandLine args[0]

*/

public class CommandLine {
    public static void main(String[] args) {
        System.out.println("Hi, what is your name? ");
        System.out.print(args[0]);
        System.out.println(", how are you?");

    }
}

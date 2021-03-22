/* This is a Java program that demonstrates how variables interact with each other. */ 

public class TraceExample {
    public static void main(String[] args) {
	System.out.println("\nOpperation \ta \t\t b \t\t c");
	System.out.println("-----------------------------------------------------");
	int a,b;
	System.out.println("int a,b;\tUndefined\tUndefined\t");
	a = 1234;
	System.out.println("a = 1234;\t" + a + "\t\tUndefined\t");
	b = 99;
	System.out.println("b = 99;\t\t" + a +"\t\t" + b + "\t\t");
	int c = a;
	System.out.println("int c = a;\t" + a + "\t\t" + b + "\t\t" + c);
	a = b;
	System.out.println("a = b;\t\t" + a + "\t\t" + b + "\t\t" + c);
	b = c;
	System.out.println("b = c;\t\t" + a + "\t\t" + b + "\t\t" + c + "\n");

    }
}

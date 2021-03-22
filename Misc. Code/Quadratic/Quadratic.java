public class Quadratic {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double determinent = b*b - 4*a*c;

        if (a != 0) {

            if (determinent < 0) {
                System.out.println("\nThis quadratic equation does not have real solutions.\n");
            }
            else if (determinent == 0) {
                double root = -1*b / (2.0*a);
                System.out.println("\nThe solution is " + root + ".\n");
            }
            else {
                double d = Math.sqrt(determinent);
                double root1 = (-b + d) / (2.0*a);
                double root2 = (-b - d) / (2.0*a);
            
                System.out.println("\nThe solutions are " + root1 + " and " + root2 + ".\n");
            }
        }

        else {

            System.out.println("\nThe solution is " + c/b + ".\n");

        }

    }
}


public class Romberg {

    static double function(double x) {
        double result;

        result = 1.0/x;

        return result;

    }
    static double[][] rombergMethod(double a, double b, int N) {
        double h = b - a;
        

        double[][] rombergArray = new double[N][N];

        rombergArray[0][0] = 0.5*h*(function(a) + function(b));

        for (int i=1; i < N; i++) {
            h *= 0.5;
            double sum = 0;
            for (int u = 0; u < Math.pow(2,i-1); u++) {
                sum += function(a+(2*u-1)*h);
            }
            rombergArray[i][0] = 0.5*rombergArray[i-1][0] + h*sum;
            for (int j = 1; j < i-1; j++) {
                rombergArray[i][j] = rombergArray[i][j-1] + (rombergArray[i][j-1] - rombergArray[i-1][j-1]/(Math.pow(4,j-1) - 1));
            }
        }

        return rombergArray;
    }

    public static String printarray(double[][] a) {
        int N = a.length;

        System.out.print("[");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N-1) {
                    if (i != N-1) { 
                        System.out.println(a[i][j]);
                    }
                    else {
                        System.out.println(a[i][j] + "]\n");
                    }
                }
                else {
                    System.out.print(a[i][j] + ", ");
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        int N = Integer.parseInt(args[2]);

        double result[][] = rombergMethod(a,b,N);

        StdDraw.setYscale(0,3);
        for (double x = a; x < b; x += 0.01) {
            StdDraw.point(x,function(x));
        }

        printarray(result);

    }
}
            

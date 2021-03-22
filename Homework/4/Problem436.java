/*
This program is designed to test the accuracy of
the coupon collector based on the expectation
value of N*log(N)+N*0.5772156649+0.5. It takes an
integer N of cards and integer T for trials run
then outputs the result of each trial and graphs
them in a nice manner.

Compile: javac -cp .:stdlib.jar Problem436.java

Run: java -cp .:stdlib.jar Problem436 N T

*/

public class Problem436 {
    public static void main(String[] args) {

        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        
        int count = 0;
        int[] trials = new int[T];

        double expectation = N*Math.log(N) + N*0.5772156649 + 0.5;

        while (count < T) {
            boolean[] found = new boolean[N];
            int cardcnt = 0, valcnt = 0;
            while (valcnt < N) {
                int val = (int) (Math.random() * N);
                cardcnt++;
                if (!found[val])
                {
                    valcnt++;
                    found[val] = true;
                }
            }
            trials[count] = cardcnt;
            count++;
            System.out.println(cardcnt);
        }

        StdDraw.setXscale(0,T);
        StdDraw.setYscale(0,2*expectation);
        StdDraw.enableDoubleBuffering();
        StdDraw.line(0,expectation,T,expectation);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < T; i++) {
            StdDraw.point(i,trials[i]);
        }
        StdDraw.show(); 
         
    
    }
}

/*
* Problem 1.4.25
*
* Purpose: Takes a series of numbers and returns an inverse permutaiton
*
* Complie: javac Problem25.java
*
* Input: integer N for number of elements in original list on numbers
            after N list each number desired in the original array with
            whitespace between them
*
* Output: A print statement of permutation
*
* Run: java Problem25
*
*/

public class Problem25 {
    public static void main(String[] args) {

        // reads the size of the list being permuted
        int N = Integer.parseInt(args[0]);

        // generates an array of original values
        int[] perm = new int[N];
        boolean[] track = new boolean[N];
        for (int i = 0; i < N; i++) {
            perm[i] = Integer.parseInt(args[i+1]);
        }
    
        // performs the inverse permutation
        for (int i = 0; i < N; i++) {
            int s = (int) (Math.random()*N);
            System.out.println(s);
            if (track[i] == false && track[s] == false) {
                int t = perm[i];
                perm[i] = perm[s];
                perm[s] = t;
                track[i] = true;
                track[s] = true;
            }
        }

        // prints results
        for (int i = 0; i < N; i++) {
            System.out.print(perm[i]);
        }

        System.out.println();
        
    }
}
        


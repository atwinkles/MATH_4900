/*
* Problem 1.3.19
*
* Author: Alexander Winkles
*
* Purpose: To take any base 10 number and convert it to base k, where 2 <= k <= 16.
*
* Complie: javac Problem19.java
*
* Input: long i - the original base 10 number; int k - the new base 2 through 16 value
*
* Output: A print statement
*
* Run: java Problem19 i k
*
*/

public class Problem19 {
    public static void main(String[] args) {
        long i = Long.parseLong(args[0]);
        int k = Integer.parseInt(args[1]); 
        int index = 0;

        String result = "";

        while (i != 0) {
            long remainder = i % k;
            if (remainder < 10) {
                result = result.concat(String.valueOf(remainder));    
            }
            else if (remainder < 11) {
                result = result.concat("A");
            }
            else if (remainder < 12) {
                result = result.concat("B");
            }
            else if (remainder < 13) {
                result = result.concat("C");
            }
            else if (remainder < 14) {
                result = result.concat("D");
            }
            else if (remainder < 15) {
                result = result.concat("E");
            }
            else {
                result = result.concat("F");
            }
            i = i / k;
            index++;
        }

        String finalResult = new StringBuffer(result).reverse().toString();

        System.out.println(finalResult);
    }
}

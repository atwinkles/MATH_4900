/*
* Problem 1.2.7
*
* Author: Alexander Winkles
*
* Purpose: This program is designed to check the ways System.out.println 
*           converts types of data depending on the order they are presented.
*
* Compile: javac Problem7.java
*
* Input: None
* 
* Output: Five print statements
*
* Run: java Problem7
*
*/
public class Problem7 {
    public static void main(String[] args){
        System.out.println(2 + "bc");
        System.out.println(2+3+"bc");
        System.out.println((2+3)+"bc");
        System.out.println("bc"+(2+3));
        System.out.println("bc"+2+3);
    }
}

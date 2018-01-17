/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

/**
 *
 * @author manji
 * 
 * Q12. A magic number is defined as a number which can be expressed as a power of
5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25),
125, 130(125 + 5), ….

Write a function to find the nth Magic number.

Example:

Input: n = 2
Output: 25

Input: n = 5
Output: 130
 * 
 * Main Function:
 * for(int i = 1; i <= 10; i++){
            System.out.println(nthMagicNumber(i));   
        }
 */
public class findNthMagicNumber {
    public static int nthMagicNumber(int n){
        int res = 0, cur = 1;
        while(n != 0){
            cur *= 5;
            if((n&1) == 1){
                res += cur;
            }
            n /= 2;
        }
        return res;
    }
}

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
 * Q17. Given a positive integer n, count the total number of set bits in binary representation of all numbers from 1 to n.

Examples:

Input: n = 3
Output:  4

Input: n = 6
Output: 9

Input: n = 7
Output: 12

Input: n = 8
Output: 13
 * 
 * Main Function:
 * for(int i = 0; i < 15; i++){
            System.out.println(countSetBits(i));
        }
 */
public class countTotalSetBitsInAllNumbersFrom1ToN {
    public static int countSetBits(int n){
        int m = n, cnt = 0, cur = 2, a = 0, b = 0, c = 0;
        while(m != 0){
            a = (n/cur)*(cur/2);
            b = ((n%cur)/(cur/2));
            c = 0;
            if(b != 0)
                c = ((n%cur)%(cur/2));
            cnt += (a+b+c);
            cur *= 2;
            m /= 2;
        }
        return cnt;
    }
}

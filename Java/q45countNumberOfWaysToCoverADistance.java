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
 * Q45. Given a distance ‘dist, count total number of ways to cover the distance with
1, 2 and 3 steps.

Examples:

Input:  n = 3
Output: 4
Below are the four ways
 1 step + 1 step + 1 step
 1 step + 2 step
 2 step + 1 step
 3 step

Input:  n = 4
Output: 7
 * 
 * 
 * 
 * Main Function:
 * for(int i = 0; i <= 7; i++)
            System.out.println(i+": "+numberOfWays(i));
 * 
 */
public class q45countNumberOfWaysToCoverADistance {
    public static int numberOfWays(int n){
        int[] fib = new int[]{1, 1, 2};
        if(n <= 2)
            return fib[n];
        int cur = 0;
        for(int f: fib)
            cur += f;
        for(int i = 4; i <= n; i++){
            int residue = fib[0];
            fib[0] = fib[1];
            fib[1] = fib[2];
            fib[2] = cur;
            cur += fib[2];
            cur -= residue;
        }
        return cur;
    }
}

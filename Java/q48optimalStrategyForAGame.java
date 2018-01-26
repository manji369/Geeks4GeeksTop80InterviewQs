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
 * 
 * Q48. Problem statement: Consider a row of n coins of values v1 . . . vn, where
n is even. We play a game against an opponent by alternating turns. In each
turn, a player selects either the first or last coin from the row, removes it
from the row permanently, and receives the value of the coin. Determine the
maximum possible amount of money we can definitely win if we move first.

Note: The opponent is as clever as the user.
 * 
 * 
 * Main Function:
 * System.out.println(optimalStrategyminimaxRec(new int[] {5, 3, 7, 10}));
        System.out.println(optimalStrategyminimaxRec(new int[] {8, 15, 3, 7}));
        System.out.println(optimalStrategyminimaxDP(new int[] {5, 3, 7, 10}));
        System.out.println(optimalStrategyminimaxDP(new int[] {8, 15, 3, 7}));
 * 
 * 
 */
public class q48optimalStrategyForAGame {
    
    public static int optimalStrategyminimaxDP(int[] arr){
        int n = arr.length, gap, i, j, x, y, z;
        int[][] dp = new int[n][n];
        for(gap = 0; gap < n; gap++){
            for(i = 0, j = gap; j < n; i++, j++){
                x = (i+2) <= j ? dp[i+2][j] : 0;
                y = (i+1) <= (j-1) ? dp[i+1][j-1] : 0;
                z = i <= j-2 ? dp[i][j-2] : 0;
                dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return dp[0][n-1];
    }
    
    private static int optimalStrategyminimaxRecUtil(int[] arr, int i, int j){
        if(i == j)
            return arr[i];
        if(j == i+1)
            return Math.max(arr[i], arr[j]);
        return Math.max(arr[i] + 
                Math.min(optimalStrategyminimaxRecUtil(arr, i+2, j), optimalStrategyminimaxRecUtil(arr, i+1, j-1)),
                arr[j] + 
                        Math.min(optimalStrategyminimaxRecUtil(arr, i+1, j-1), optimalStrategyminimaxRecUtil(arr, i, j-2)));
    }
    
    public static int optimalStrategyminimaxRec(int[] arr){
        return optimalStrategyminimaxRecUtil(arr, 0, arr.length-1);
    }
}

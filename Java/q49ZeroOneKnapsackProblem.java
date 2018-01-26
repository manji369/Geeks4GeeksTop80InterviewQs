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
 * Q49. Given weights and values of n items, put these items in a knapsack of
capacity W to get the maximum total value in the knapsack. In other words,
given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
weights associated with n items respectively. Also given an integer W which
represents knapsack capacity, find out the maximum value subset of val[] such
that sum of the weights of this subset is smaller than or equal to W. You
cannot break an item, either pick the complete item, or don’t pick it
(0-1 property).
eg.
value = 60, 100, 120    weight = 10, value = 60
weight = 10, 20, 30     weight = 20, value = 100
W = 50                  weight = 30, value = 120
                        weight = (20+10), value = (100+60)
Solution: 220           weight = (30+10), value = (60+120)
                        weight = (20+30), value = (100+120)
                        weight = (10+20+30), value = (60+100+120)
 * 
 * 
 * Main Function:
 * System.out.println(knapsackRec(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
        System.out.println(knapsackDP(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
 * 
 */
public class q49ZeroOneKnapsackProblem {
    
    public static int knapsackDP(int[] values, int[] weights, int W){
        int n = values.length;
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= W; w++){
                if(i == 0 || w == 0)
                    dp[i][w] = 0;
                else if(weights[i-1] > w)
                    dp[i][w] = dp[i-1][w];
                else
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1]+dp[i-1][w-weights[i-1]]);
            }
        }
        return dp[n][W];
    }
    
    private static int knapsackRecUtil(int[] values, int[] weights, int W, int n){
        if(n == 0 || W == 0)
            return 0;
        if(weights[n-1] > W)
            return knapsackRecUtil(values, weights, W, n-1);
        return Math.max(knapsackRecUtil(values, weights, W, n-1), 
                values[n-1] + knapsackRecUtil(values, weights, W-weights[n-1], n-1));
    }
    
    public static int knapsackRec(int[] values, int[] weights, int W){
        return knapsackRecUtil(values, weights, W, values.length);
    }
}

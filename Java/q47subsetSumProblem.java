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
 * Q47. Given a set of non-negative integers, and a value sum, determine if there
is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
 * 
 * 
 * Main Function:
 * System.out.println(isSubsetSumRec(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(isSubsetSumRec(new int[]{3, 34, 3, 12, 5, 2}, 9));
        System.out.println(isSubsetSumDP(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(isSubsetSumDP(new int[]{3, 34, 3, 12, 5, 2}, 9));
 * 
 */
public class q47subsetSumProblem {
    private static boolean isSubsetSumDPUtil(int[] s, int sm, int n){
        boolean[][] dp = new boolean[n+1][sm+1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;
        for(int j = 1; j <= sm; j++)
            dp[0][j] = false;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sm; j++){
                dp[i][j] = dp[i-1][j];
                if(s[i-1] <= j)
                    dp[i][j] |= dp[i-1][j-s[i-1]];
            }
        }
        return dp[n][sm];
    }
    
    public static boolean isSubsetSumDP(int[] s, int sm){
        return isSubsetSumDPUtil(s, sm, s.length);
    }
    
    private static boolean isSubsetSumRecUtil(int[] s, int sm, int n){
        if(sm == 0)
            return true;
        if(n == 0 && sm != 0)
            return false;
        if(s[n-1] > sm)
            return isSubsetSumRecUtil(s, sm, n-1);
        return isSubsetSumRecUtil(s, sm, n-1) || isSubsetSumRecUtil(s, sm-s[n-1], n-1);
    }
    
    public static boolean isSubsetSumRec(int[] s, int sm){
        return isSubsetSumRecUtil(s, sm, s.length);
    }
}

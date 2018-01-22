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
 * Q46. Given a n*n matrix where all numbers are distinct and less than n^2,
find the maximum length path (starting from any cell) such that all cells along
the path are in increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to
(i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the
adjacent cells have a difference of 1.

Example:

Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9.
 * 
 * 
 * Main Function:
 * int[][] arr = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        System.out.println(longestPath(arr));
        arr = new int[][]{{1, 2, 9}, {5, 3, 8}, {4, 6, 7}};
        System.out.println(longestPath(arr));
 * 
 */
public class q46findTheLongestPathInAMatrixWithGivenConstraints {
    private static int longestPathUtil(int[][] arr, int i, int j, int[][] dp, int n){
        if(i < 0 || i >= n || j < 0 || j >= n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(i > 0 && arr[i][j] + 1 == arr[i-1][j])
            dp[i][j] = longestPathUtil(arr, i-1, j, dp, n) + 1;
        else if(i < n-1 && arr[i][j] + 1 == arr[i+1][j])
            dp[i][j] = longestPathUtil(arr, i+1, j, dp, n) + 1;
        else if(j > 0 && arr[i][j] + 1 == arr[i][j-1])
            dp[i][j] = longestPathUtil(arr, i, j-1, dp, n) + 1;
        else if(j < n-1 && arr[i][j] + 1 == arr[i][j+1])
            dp[i][j] = longestPathUtil(arr, i, j+1, dp, n) + 1;
        else
            dp[i][j] = 1;
        return dp[i][j];
    }
    
    public static int longestPath(int[][] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                dp[i][j] = -1;
        int res = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n ; j++){
                if(dp[i][j] == -1)
                    longestPathUtil(arr, i, j, dp, n);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}

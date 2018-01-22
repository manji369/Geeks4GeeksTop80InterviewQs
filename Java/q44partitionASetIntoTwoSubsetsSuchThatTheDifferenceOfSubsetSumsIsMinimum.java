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
 * Q44. Given a set of integers, the task is to divide it into two sets S1 and S2
such that the absolute difference between their sums is minimum.

If there is a set S with n elements, then if we assume Subset1 has m elements,
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2))
should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
 * 
 * Main Function:
 * int[] arr = new int[] {1, 6, 11, 5};
        System.out.println(findMinPartitionRec(arr));
        System.out.println(findMinPartitionDP(arr));
 * 
 */
public class q44partitionASetIntoTwoSubsetsSuchThatTheDifferenceOfSubsetSumsIsMinimum {
    public static int findMinPartitionDP(int[] arr){
        int sm = 0;
        for(int a: arr)
            sm += a;
        int n = arr.length;
        boolean[][] dp = new boolean[n+1][sm+1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = true;
        for(int j = 1; j <= sm; j++)
            dp[0][j] = false;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sm; j++){
                dp[i][j] = dp[i-1][j];
                if(arr[i-1] <= j)
                    dp[i][j] |= dp[i-1][j-arr[i-1]];
            }
        }
        for(int j = sm/2; j >= 0; j--){
            if(dp[n][j])
                return sm-2*j;
        }
        return sm;
    }
    
    private static int findMinPartitionRecUtil(int[] arr, int i, int cur_sum, int total_sum){
        if(i == 0)
            return Math.abs(cur_sum - (total_sum-cur_sum));
        return Math.min(findMinPartitionRecUtil(arr, i-1, cur_sum+arr[i-1], total_sum), 
                findMinPartitionRecUtil(arr, i-1, cur_sum, total_sum));
    }
    
    public static int findMinPartitionRec(int[] arr){
        int sm = 0;
        for(int a: arr)
            sm += a;
        return findMinPartitionRecUtil(arr, arr.length, 0, sm);
    }
}

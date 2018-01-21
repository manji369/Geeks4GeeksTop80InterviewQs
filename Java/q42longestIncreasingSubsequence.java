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
 * Q42. The Longest Increasing Subsequence (LIS) problem is to find the length of
the longest subsequence of a given sequence such that all elements of the
subsequence are sorted in increasing order. For example, the length of LIS for
{10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * 
 * Main Function:
 * int[] arr = new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(arr));
 * 
 */
public class longestIncreasingSubsequence {
    public static int lis(int[] arr){
        int n = arr.length;
        int[] L = new int[n];
        for(int i = 0; i < n; i++)
            L[i] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] >= arr[j] && L[j]+1 > L[i])
                    L[i] = L[j]+1;
            }
        }
        int mx = Integer.MIN_VALUE;
        for(int e: L)
            mx = Math.max(e, mx);
        return mx;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.Arrays;

/**
 *
 * @author manji
 * 
 * 
 * Q3. Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 4
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)
               * 
               * Main function:
               * System.out.println(countTriplets(new int[] {5, 1, 3, 4, 7}, 12));
 */
public class countTripletsWithSumSmallerThanGivenValue {
    public static int countTriplets(int[] arr, int target){
        Arrays.sort(arr);
        int n = arr.length, j, k, res = 0;
        for(int i = 0; i <= n-2; i++){
            j = i+1;
            k = n-1;
            while(j < k){
                if (arr[i] + arr[j] + arr[k] >= target){
                    k--;
                }else{
                    res += (k-j);
                    j++;
                }
            }
        }
        return res;
    }
}

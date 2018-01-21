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
 * Q7. Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.

Examples:

Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5
 * 
 * Main Function: 
 * System.out.println(longestContiguousSubarray(new int[] {1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
 */
public class lengthOfTheLargestSubarrayWithContiguousElements {
    public static int longestContiguousSubarray(int[] arr){
        int maxLength = 0, minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            minVal = Integer.MAX_VALUE;
            maxVal = Integer.MIN_VALUE;
            for(int j = i; j < arr.length; j++){
                minVal = Math.min(minVal, arr[j]);
                maxVal = Math.max(maxVal, arr[j]);
                if(maxVal-minVal == j-i){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}

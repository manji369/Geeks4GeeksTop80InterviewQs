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
 * Q9. Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.
* 
* Main Function:
* System.out.println(smallestSubarray(new int[] {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
 */
public class smallestSubarrayWithSumGreaterThanAGivenValue {
    public static int smallestSubarray(int[] arr, int x){
        int cur_sum = 0, low = 0, high = 0, min_length = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            cur_sum += arr[i];
            while(cur_sum > x){
                min_length = Math.min(min_length, high-low+1);
                cur_sum -= arr[low];
                low++;
            }
            high++;
        }
        return min_length;
    }
}

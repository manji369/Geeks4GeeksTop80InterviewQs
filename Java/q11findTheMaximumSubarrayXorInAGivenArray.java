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
 * Q11. Given an array of integers. find the maximum XOR subarray value in given array. Expected time complexity O(n).

Examples:

Input: arr[] = {1, 2, 3, 4}
Output: 7
The subarray {3, 4} has maximum XOR value

Input: arr[] = {8, 1, 2, 12, 7, 6}
Output: 15
The subarray {1, 2, 12} has maximum XOR value

Input: arr[] = {4, 6}
Output: 6
The subarray {6} has maximum XOR value
 * 
 * Main Function:
 * System.out.println(maxXorSubarrayN2(new int[] {8, 1, 2, 12, 7, 6}));
 */
public class findTheMaximumSubarrayXorInAGivenArray {
    // O(N^2)
    public static int maxXorSubarrayN2(int[] arr){
        int maxXor = Integer.MIN_VALUE, curXor = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            curXor = 0;
            for(int j = i; j < n; j++){
                curXor ^= arr[j];
                maxXor = Math.max(maxXor, curXor);
            }
        }
        return maxXor;
    }
    
    // O(N)
    public static int maxXorSubarrayN(int[] arr){
        int prefixIndex = 0, curXor = arr[0], i = 1, maxXor = Integer.MIN_VALUE;
        while(i < arr.length){
            if((curXor^arr[i]) > curXor){
                curXor ^= arr[i];
                i++;
            }else{
                curXor ^= arr[prefixIndex++];
            }
            if(maxXor < curXor){
                maxXor = curXor;
            }
        }
        if(maxXor == Integer.MIN_VALUE){
            maxXor = curXor;
        }
        return maxXor;
    }
}

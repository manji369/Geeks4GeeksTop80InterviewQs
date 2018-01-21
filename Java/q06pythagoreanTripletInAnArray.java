/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author manji
 * 
 * Q6. Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

Example:

Input: arr[] = {3, 1, 4, 6, 5}
Output: True
There is a Pythagorean triplet (3, 4, 5).

Input: arr[] = {10, 4, 6, 12, 5}
Output: False
There is no Pythagorean triplet.
 * 
 * 
 * Main Function:
 * System.out.println(hasTriplets(new Integer[] {3, 1, 4, 6, 5}));
 */
public class pythagoreanTripletInAnArray {
    public static boolean hasTriplets(Integer[] arr){
        int n = arr.length, a, start, end, bc;
        for(int i = 0; i < n; i++){
            arr[i] = arr[i]*arr[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            a = arr[i];
            start = i+1;
            end = n-1;
            while(start < end){
                bc = arr[start] + arr[end];
                if(bc == a){
                    return true;
                }else if(bc < a){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return false;
    }
}

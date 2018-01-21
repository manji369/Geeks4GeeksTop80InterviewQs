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
 * Q4. Convert array into Zig-Zag fashion
2.4
Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.

Example: 
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}
 * 
 * Main Function:
 * int[] arr = {4, 3, 7, 8, 6, 2, 1};
        convertArray(arr);
        for(int a: arr){
            System.out.println(a);
        }
 */
public class convertArrayIntoZigZagFashion {
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void convertArray(int[] arr){
        boolean bigFlag = true;
        for(int i = 1; i < arr.length-1; i++){
            if(bigFlag){
                if(arr[i] > arr[i-1] && arr[i] < arr[i+1]){
                    swap(arr, i, i+1);
                }else if(arr[i] < arr[i-1] && arr[i] > arr[i+1]){
                    swap(arr, i, i-1);
                }
            }else{
                if(arr[i] < arr[i-1] && arr[i] > arr[i+1]){
                    swap(arr, i, i+1);
                }else if(arr[i] > arr[i-1] && arr[i] < arr[i+1]){
                    swap(arr, i, i-1);
                }
            }
            bigFlag = !bigFlag;
        }
    }
}

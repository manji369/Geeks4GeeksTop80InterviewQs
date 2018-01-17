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
 * Q31. Binary Search
1.5
Given a sorted array arr[] of n elements, write a function to search a given
element x in arr[].
 * 
 * 
 * Main Function:
 * System.out.println(binarySearchIter(new int[] {1, 2, 4, 10, 14, 20, 50}, 10));
 * 
 */
public class binarySearch {
    private static int binarySearchUtil(int[] arr, int start, int end, int x){
        int mid = (start+end)/2;
        while(start <= end){
            if(arr[mid] == x)
                return mid;
            if(arr[mid] < x)
                return binarySearchUtil(arr, mid+1, end, x);
            else
                return binarySearchUtil(arr, start, mid-1, x);
        }
        return -1;
    }
    
    public static int binarySearchRec(int[] arr, int x){
        return binarySearchUtil(arr, 0, arr.length-1, x);
    }
    
    public static int binarySearchIter(int[] arr, int x){
        int mid = 0, start = 0, end = arr.length;
        while(start <= end){
            mid = (start+end)/2;
            if(arr[mid] == x)
                return mid;
            if(arr[mid] < x)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}

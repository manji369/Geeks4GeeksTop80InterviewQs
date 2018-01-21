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
 * Q39. Given an array and a number k where k is smaller than size of array, we
need to find the kth smallest element in the given array. It is given that all
array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 4
Output: 10
 * 
 * 
 * Main Function:
 * int[] arr = new int[] {-2, 5, 0, 3, 1};
        System.out.println(kthSmallest(arr, 3));
 * 
 */
public class kthsmallestlargestelementinunsortedarrayset2expectedlineartime {
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int partition(int[] arr, int low, int high){
        int i = low, pivot = arr[high];
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }
    
    private static int randomPartition(int[] arr, int low, int high){
        int n = high-low+1;
        int pi = low + (int)(Math.random())%n;
        swap(arr, pi, high);
        return partition(arr, low, high);
    }
    
    private static int kthSmallestUtil(int[] arr, int low, int high, int k){
        if(k > 0 && k <= high-low+1){
            int pi = randomPartition(arr, low, high);
            if(pi-low == k-1)
                return arr[pi];
            if(pi-low > k-1)
                return kthSmallestUtil(arr, low, pi-1, k);
            return kthSmallestUtil(arr, pi+1, high, k-(pi+1-low));
        }
        return Integer.MAX_VALUE;
    }
    
    public static int kthSmallest(int[] arr, int k){
        return kthSmallestUtil(arr, 0, arr.length-1, k);
    }
}

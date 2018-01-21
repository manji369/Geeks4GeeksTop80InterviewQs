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
 * Q37. Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an
element as pivot and partitions the given array around the picked pivot. There
are many different versions of quickSort that pick pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an
array and an element x of array as pivot, put x at its correct position in
sorted array and put all smaller elements (smaller than x) before x, and put
all greater elements (greater than x) after x. All this should be done in
linear time.
 * 
 * Main Function:
 * int[] arr = new int[] {2, 14, 2, -1, 7, 5, 7, 8};
        quickSort(arr);
        for(int a: arr)
            System.out.print(a + " ");
        System.out.println("");
 * 
 */
public class quickSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high], i = low-1;
        for(int j = low; j < high; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }
    
    private static void quickSortUtil(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSortUtil(arr, low, pi-1);
            quickSortUtil(arr, pi+1, high);
        }
    }
    
    public static void quickSort(int[] arr){
        quickSortUtil(arr, 0, arr.length-1);
    }
}

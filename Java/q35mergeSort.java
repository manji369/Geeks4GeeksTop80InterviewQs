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
 * Q35. Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides
input array in two halves, calls itself for the two halves and then merges the
two sorted halves. The merge() function is used for merging two halves.
 * 
 * 
 * Main Function:
 * int[] arr = new int[] {4, 2, 1, 5, 3, -1};
        mergeSort(arr);
        for(int a: arr)
            System.out.print(a + " ");
        System.out.println("");
 * 
 */
public class mergeSort {
    private static void merge(int[] arr, int start, int mid, int end){
        int n1 = mid-start+1, n2 = end-mid;
        int[] L = new int[n1], R = new int[n2];
        for(int i = 0; i < n1; i++)
            L[i] = arr[start+i];
        for(int i = 0; i < n2; i++)
            R[i] = arr[mid+i+1];
        int i = 0, j = 0, k = start;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    private static void mergeSortUtil(int[] arr, int start, int end){
        if(start < end){
            int mid = (start+end)/2;
            mergeSortUtil(arr, start, mid);
            mergeSortUtil(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    
    public static void mergeSort(int[] arr){
        mergeSortUtil(arr, 0, arr.length-1);
    }
}

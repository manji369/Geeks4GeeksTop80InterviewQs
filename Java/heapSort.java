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
 * Q36. Heap sort is a comparison based sorting technique based on Binary Heap data
structure. It is similar to selection sort where we first find the maximum
element and place the maximum element at the end. We repeat the same process
for remaining element.

Heap Sort Algorithm for sorting in increasing order:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace
it with the last item of the heap followed by reducing the size of heap by 1.
Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.
 * 
 * 
 * Main Function:
 * int[] arr = new int[] {2, 5, 1, 4, 3, 6};
        heapSort(arr);
        for(int a: arr)
            System.out.print(a + " ");
        System.out.println("");
 * 
 */
public class heapSort {
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void heapify(int[] arr, int n, int i){
        int mx = i, l = 2*i+1, r = 2*i+2;
        if((l < n) && (arr[mx] < arr[l]))
            mx = l;
        if((r < n) && (arr[mx] < arr[r]))
            mx = r;
        if(mx != i){
            swap(arr, i, mx);
            heapify(arr, n, mx);
        }
    }
    
    public static void heapSort(int[] arr){
        int n = arr.length;
        for(int i = (n/2)-1; i >= 0; i--)
            heapify(arr, n, i);
        for(int i = n-1; i > 0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
}

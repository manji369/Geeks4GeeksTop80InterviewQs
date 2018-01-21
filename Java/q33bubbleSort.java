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
 * 
 * Q33. Bubble Sort is the simplest sorting algorithm that works by repeatedly
swapping the adjacent elements if they are in wrong order.
 * 
 * 
 * Main Function:
 * int[] arr = bubbleSort(new int[] {2, 1, 5, 3, 6, 4});
        for(int a: arr)
            System.out.print(a + " ");
 * 
 */
public class bubbleSort {
    private static void swap(int[] arr, int i){
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;
    }
    
    public static int[] bubbleSort(int[] arr){
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    flag = true;
                    swap(arr, i);
                }
            }
        }
        return arr;
    }
}

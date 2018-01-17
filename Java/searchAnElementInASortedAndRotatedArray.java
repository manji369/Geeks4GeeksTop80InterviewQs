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
 * Q32. An element in a sorted array can be found in O(log n) time via binary
search. But suppose we rotate an ascending order sorted array at some pivot
unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
Devise a way to find an element in the rotated array in O(log n) time.

sortedPivotedArray

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10
Output : Found at index 3
 * 
 * 
 * Main Function:
 * System.out.println(binarySearchRotatedArray(new int[] {5, 6, 7, 8, 9, 10, 1, 2, 3}, 3));
 * 
 */
public class searchAnElementInASortedAndRotatedArray {
    public static int binarySearchRotatedArray(int[] arr, int x){
        int start = 0, end = arr.length-1, mid = 0;
        while(start <= end){
            mid = (start+end)/2;
            if(arr[mid] == x)
                return mid;
            if(arr[start] <= arr[mid]){
                if(arr[start] <= x && x < arr[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }else{
                if(arr[mid] < x && x <= arr[end])
                    start = mid+1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }
}

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
 * Q34. Insertion sort is a simple sorting algorithm that works the way we sort
playing cards in our hands.
Example:
12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13
 * 
 * 
 * Main Function:
 * int[] arr = insertionSort(new int[] {2, 5, 1, 9, 13, -1});
        for(int a: arr)
            System.out.print(a + " ");
 * 
 */
public class insertionSort {
    public static int[] insertionSort(int[] arr){
        int cur = 0, j = 0;
        for(int i = 1; i < arr.length; i++){
            cur = arr[i];
            j = i-1;
            while(j >= 0 && cur < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = cur;
        }
        return arr;
    }
}

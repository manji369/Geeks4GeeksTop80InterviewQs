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
 * Q8. Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of elements of any subset of given set.
Expected time complexity is O(n).

Examples:

Input:  arr[] = {1, 3, 6, 10, 11, 15};
Output: 2

Input:  arr[] = {1, 1, 1, 1};
Output: 5

Input:  arr[] = {1, 1, 3, 4};
Output: 10

Input:  arr[] = {1, 2, 5, 10, 20, 40};
Output: 4

Input:  arr[] = {1, 2, 3, 4, 5, 6};
Output: 22
 * 
 * 
 * Main Function:
 * System.out.println(smallestValue(new int[] {1, 2, 3, 4}));
 */
public class findTheSmallestPositiveIntegerValueThatCannotBeRepresentedAsSumOfAnySubsetOfAGivenArray {
    public static int smallestValue(int[] arr){
        int smallestVal = 1;
        for(int a: arr){
            if(a > smallestVal){
                return smallestVal;
            }else{
                smallestVal += a;
            }
        }
        return smallestVal;
    }
}

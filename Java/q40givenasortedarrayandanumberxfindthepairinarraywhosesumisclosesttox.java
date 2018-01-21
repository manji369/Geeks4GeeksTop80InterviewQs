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
 * Q40. Given a sorted array and a number x, find a pair in array whose sum is
closest to x.

Examples:

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
 * 
 * Main Function:
 * int[] arr = new int[] {10, 22, 28, 29, 30, 40};
        int[] res = closestSumPair(arr, 54);
        System.out.println(res[0] + " " + res[1]);
 * 
 */
public class givenasortedarrayandanumberxfindthepairinarraywhosesumisclosesttox {
    public static int[] closestSumPair(int[] arr, int x){
        int low = 0, n = arr.length, high = n-1, absMinDiff = Integer.MAX_VALUE,
                indl = high-1, indh =low-1;
        while(low < high){
            int sm = arr[low] + arr[high];
            if(sm == x)
                return new int[]{arr[low], arr[high]};
            if(Math.abs(sm-x) < absMinDiff){
                absMinDiff = Math.abs(sm-x);
                indl = low;
                indh = high;
            }
            if(sm < x)
                low++;
            else
                high--;
        }
        return new int[]{arr[indl], arr[indh]};
    }
}

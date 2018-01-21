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
 * Q15. Given an array where every element occurs three times, except one element
which occurs only once. Find the element that occurs once. Expected time
complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2
 * 
 * Main Function:
 * System.out.println(singleElement(new int[] {1, 2, 3, 1, 2, 1, 2}));
 */
public class findTheElementThatAppearsOnce {
    public static int singleElement(int[] arr){
        int res = 0, pw = 1, cnt = 0;
        for(int i = 0; i < 32; i++){
            cnt = 0;
            for(int j = 0; j < arr.length; j++){
                cnt += (arr[j]&1);
                arr[j] /= 2;
            }
            res += (cnt%3)*pw;
            pw *= 2;
        }
        return res;
    }
}

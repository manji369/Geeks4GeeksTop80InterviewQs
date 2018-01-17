/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

/**
 *
 * @author manji
 * Q1. Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.

Examples:

Input:   str = "a,b$c"
Output:  str = "c,b$a"
Note that $ and , are not moved anywhere.  
Only subsequence "abc" is reversed

Input:   str = "Ab,c,de!$"
Output:  str = "ed,c,bA!$"
* 
* 
* Main function: 
* char[] arr = "a!!!b.c.d,e'f,ghi".toCharArray();
        reverse(arr);
        for(char ch: arr){
            System.out.print(ch);
        }
 */
public class reverseArrayWithoutAffectingSpecialChars {
    public static boolean isAlpha(char ch){
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
    }
    
    public static void swap(char[] arr, int start, int end){
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    
    public static void reverse(char[] arr){
        int start = 0, end = arr.length - 1;
        while(start < end){
            if(!isAlpha(arr[start])){
                start++;
            }else if(!isAlpha(arr[end])){
                end--;
            }else{
                swap(arr, start, end);
                start++;
                end--;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manji
 * 
 * Q2 Given a string, print all possible palindromic partitions

Given a string, find all possible palindromic partitions of given string.

Example:
input: nitin
output:
n i t i n
n iti n
nitin
* 
* Main function:
* printPalPartitions("nitin");
 */
public class printAllPalindromicPartitions {
    
    private static boolean isPalindrome(String str, int low, int high){
        while(low < high){
            if(str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
    
    private static void printPalPartitionsUtil(List<List<String>> 
            allPart, List<String> curPart, int start, int end, String str){
        if(start >= end){
            allPart.add(new ArrayList<>(curPart));
            return;
        }
        for(int i = start; i < end; i++){
            if(isPalindrome(str, start, i)){
                curPart.add(str.substring(start, i+1));
                printPalPartitionsUtil(allPart, curPart, i+1, end, str);
                curPart.remove(curPart.size()-1);
            }
        }
    }
    
    public static void printPalPartitions(String str){
        int n = str.length();
        List<List<String>> allPart = new ArrayList<>();
        List<String> curPart = new ArrayList<>();
        printPalPartitionsUtil(allPart, curPart, 0, n, str);
        for(List<String> presPart: allPart){
            for(String presStr: presPart){
                System.out.print(presStr + ' ');
            }
            System.out.println("");
        }
    }
}

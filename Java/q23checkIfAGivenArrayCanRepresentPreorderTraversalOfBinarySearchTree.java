/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.Stack;

/**
 *
 * @author manji
 * 
 * Q23. Given an array of numbers, return true if given array can represent
preorder traversal of a Binary Search Tree, else return false. Expected time
complexity is O(n).

Examples:

Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2

      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /
 30    80

  35     100


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.
 * 
 * Main Function:
 * System.out.println(isPreBSTN(new int[] {40, 30, 35, 80, 100}));
 * 
 */
public class checkIfAGivenArrayCanRepresentPreorderTraversalOfBinarySearchTree {
    public static boolean isPreBSTN(int [] arr){
        int root = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<Integer>();
        for(int a: arr){
            if(a < root)
                return false;
            while(!s.isEmpty() && s.peek() < a){
                root = s.pop();
            }
            s.push(a);
        }
        return true;
    }
    
    private static boolean isPreBSTN2Util(int[] arr, int i, int j){
        if(j-i < 2){
            return true;
        }
        int k = i+1, cur = arr[i];
        while(arr[k] < cur){
            k++;
        }
        int l = k+1;
        boolean flag = true;
        while(l <= j){
            if(arr[l] < cur){
                flag = false;
                break;
            }
            l++;
        }
        return flag && isPreBSTN2Util(arr, i+1, l-1) && isPreBSTN2Util(arr, l+1, j-1);
    }
    
    public static boolean isPreBSTN2(int[] arr){
        return isPreBSTN2Util(arr, 0, arr.length-1);
    }
}

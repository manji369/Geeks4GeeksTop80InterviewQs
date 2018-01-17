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
 * Q5. Given two sorted arrays A and B, generate all possible arrays such that first element is taken from A then from B then from A and so on in increasing order till the arrays exhausted. The generated arrays should end with an element from B.

For Example
A = {10, 15, 25}
B = {1, 5, 20, 30}

The resulting arrays are:
  10 20
  10 20 25 30
  10 30
  15 20
  15 20 25 30
  15 30
  25 30
  * 
  * Main Function:
  * generate(new int[]{10, 15, 25}, new int[]{1, 5, 20, 30});
 */
public class generateArrays {
    private static void generateUtil(int[] A, int[] B, int[] C, boolean AorB, int i, int j, 
            int m, int n, int len){
        if(AorB){
            if(len != 0)
                printArray(C, len+1);
            for(int k = i; k < m; k++){
                if(len == 0){
                    C[0] = A[k];
                    generateUtil(A, B, C, false, k+1, j, m, n, len);
                }else if(A[k] > C[len]){
                    C[len+1] = A[k];
                    generateUtil(A, B, C, false, k+1, j, m, n, len+1);
                }
            }
        }else{
            for(int l = j; l < n; l++){
                if(B[l] > C[len]){
                    C[len+1] = B[l];
                    generateUtil(A, B, C, true, i, l+1, m, n, len+1);
                }
            }
        }
    }
    
    public static void generate(int[] A, int[] B){
        int m = A.length, n = B.length;
        int[] C = new int[m+n];
        generateUtil(A, B, C, true, 0, 0, m, n, 0);
    }
    
    private static void printArray(int[] C, int n){
        for(int i = 0; i < n; i++){
            System.out.print(C[i] + " ");
        }
        System.out.println("");
    }
}

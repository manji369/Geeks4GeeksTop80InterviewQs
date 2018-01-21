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
 * Q20. A number is Sparse if there are no two adjacent 1s in its binary
representation. For example 5 (binary representation: 101) is sparse, but 6
(binary representation: 110) is not sparse.
Given a number x, find the smallest Sparse number which greater than or equal
to x.

Examples:

Input: x = 6
Output: Next Sparse Number is 8

Input: x = 4
Output: Next Sparse Number is 4

Input: x = 38
Output: Next Sparse Number is 40

Input: x = 44
Output: Next Sparse Number is 64
 * 
 * Main Function:
 * System.out.println(nextSparseNum(44));
 */
public class findNextSparseNumber extends binaryRepresentationOfAGivenNumber{
    public static int nextSparseNum(int n){
        System.out.println(n);
        char[] binN = toBinary(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        int maxInd = -1;
        for(int i = binN.length-1; i > 0; i--){
            if(binN[i] == '1'){
                if(binN[i-1] == '1'){
                    if(i == 1){
                        sb.append('1');
                        maxInd = 0;
                        binN[0] = '0';
                        binN[1] = '0';
                    }else{
                        binN[i-2] = '1';
                        maxInd = i-2;
                        binN[i-1] = '0';
                        binN[i] = '0';
                    }
                }
            }
        }
        if(maxInd != -1){
            for(int i = 0; i < maxInd+1; i++){
                sb.append(binN[i]);
            }
            for(int i = maxInd+1; i < binN.length; i++){
                sb.append('0');
            }
        }else{
            for(int i = 0; i < binN.length; i++){
                sb.append(binN[i]);
            }
        }
        return toInt(sb.toString());
    }
}

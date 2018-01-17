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
 * Q41. LCS Problem Statement: Given two sequences, find the length of longest
subsequence present in both of them. A subsequence is a sequence that appears
in the same relative order, but not necessarily contiguous. For example, “abc”,
 “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a
 string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison
program that outputs the differences between two files), and has applications
in bioinformatics.
 * 
 * 
 * Main Function:
 * System.out.println(lcs("AGGTAB", "GXTXAYB"));
 * 
 */
public class longestCommonSubsequence {
    public static String lcs(String a, String b){
        int m = a.length(), n = b.length();
        int[][] lcs = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    lcs[i][j] = 0;
                else if(a.charAt(i-1) == b.charAt(j-1))
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                else
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        int llcs = lcs[m][n], ind = llcs, i = m, j = n;
        char[] res = new char[llcs];
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                res[ind-1] = a.charAt(i-1);
                i--; j--; ind--;
            }else{
                if(lcs[i-1][j] > lcs[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return new String(res);
    }
}

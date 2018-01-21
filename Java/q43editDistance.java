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
 * 
 * Q43. Given two strings str1 and str2 and below operations that can performed on
str1. Find minimum number of edits (operations) required to convert ‘str1’ into
‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations.
Replace 'n' with 'r', insert t, insert a
 * 
 * 
 * Main Function:
 * System.out.println(editDistance("sunday", "saturday"));
 * 
 */
public class editDistance {
    public static int editDistance(String a, String b){
        int m = a.length(), n = b.length();
        int[][] L = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0)
                    L[i][j] = j;
                else if(j == 0)
                    L[i][j] = i;
                else if(a.charAt(i-1) == b.charAt(j-1))
                    L[i][j] = L[i-1][j-1];
                else
                    L[i][j] = 1 + Math.min(Math.min(L[i-1][j-1], L[i-1][j]), L[i][j-1]);
            }
        }
        return L[m][n];
    }
}

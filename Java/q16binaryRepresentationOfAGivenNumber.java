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
 * Q16. Write a program to print Binary representation of a given number.
 * 
 * Main Function:
 * for(int i = 0; i < 32; i++){
            System.out.println(toBinary(i));
        }
 */
public class binaryRepresentationOfAGivenNumber {
    
    public static int toInt(String s){
        char[] binN = s.toCharArray();
        int cur = 0, pw = 1;
        for(int i = binN.length-1; i >= 0; i--){
            if(binN[i] == '1'){
                cur += pw;
            }
            pw *= 2;
        }
        return cur;
    }
    
    public static String toBinary(int n){
        if(n == 0)
            return "0";
        StringBuilder res = new StringBuilder("");
        while(n != 0){
            res.insert(0, Integer.toString((n&1)));
            n /= 2;
        }
        return res.toString();
    }
}

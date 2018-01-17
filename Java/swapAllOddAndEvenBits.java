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
 * Q14. Given an unsigned integer, swap all odd bits with even bits. For example,
if the given number is 23 (00010111), it should be converted to 43 (00101011).
Every even position bit is swapped with adjacent bit on right side (even
position bits are highlighted in binary representation of 23), and every
odd position bit is swapped with adjacent on left side.
 * 
 * Main Function: 
 * System.out.println(swapBits(23));
 * 
 */
public class swapAllOddAndEvenBits {
    public static int swapBits(int n){
        int e_bits = n & 0xAAAAAAAA, o_bits = n & 0x55555555;
        e_bits >>= 1;
        o_bits <<= 1;
        return (e_bits | o_bits);
    }
}

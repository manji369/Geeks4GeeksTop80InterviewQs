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
 * Q19. Given two numbers ‘a’ and b’. Write a program to count number of bits
needed to be flipped to convert ‘a’ to ‘b’.

Example :

Input : a = 10, b = 20
Output : 4
Binary representation of a is 00001010
Binary representation of b is 00010100
We need to flip highlighted four bits in a
to make it b.

Input : a = 7, b = 10
Output : 3
Binary representation of a is 00000111
Binary representation of b is 00001010
We need to flip highlighted three bits in a
to make it b.
 * 
 * Main Function:
 * System.out.println(countFlipped(7, 10));
 */
public class countNumberOfBitsToBeFlippedToConvertAToB {
    public static int countFlipped(int a, int b){
        int cnt = 0;
        while(a != 0 || b != 0){
            if((a&1) != (b&1)){
                cnt++;
            }
            a /= 2;
            b /= 2;
        }
        return cnt;
    }
}

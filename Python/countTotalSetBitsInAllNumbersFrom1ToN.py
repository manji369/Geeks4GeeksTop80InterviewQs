'''
Q17. Given a positive integer n, count the total number of set bits in binary representation of all numbers from 1 to n.

Examples:

Input: n = 3
Output:  4

Input: n = 6
Output: 9

Input: n = 7
Output: 12

Input: n = 8
Output: 13
'''

import sys

def countSetBits(n):
    cnt = 0
    m = n
    cur = 2
    while m:
        a = (n//cur)*(cur//2)
        b = (n%cur)//(cur//2)
        c = 0
        if b != 0:
            c = ((n%cur)%(cur//2))
        cnt += (a+b+c)
        cur *= 2
        m //= 2
    return cnt


# print(countSetBits(int(sys.argv[1])))
for i in range(15):
    print(countSetBits(i))

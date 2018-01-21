'''
Q12. A magic number is defined as a number which can be expressed as a power of
5 or sum of unique powers of 5. First few magic numbers are 5, 25, 30(5 + 25),
125, 130(125 + 5), ….

Write a function to find the nth Magic number.

Example:

Input: n = 2
Output: 25

Input: n = 5
Output: 130
'''

def nthMagicNumber(n):
    cur = 1
    res = 0
    while(n):
        cur *= 5
        if(n & 1):
            res += cur
        n //= 2
    return res

for i in range(10):
    print(nthMagicNumber(i))

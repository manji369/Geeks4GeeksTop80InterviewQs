'''
Q19. Given two numbers ‘a’ and b’. Write a program to count number of bits
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
'''

import sys

def countFilpped(a, b):
    cnt = 0
    while(a != 0 or b != 0):
        if((a&1) != (b&1)):
            cnt += 1
        a //= 2
        b //= 2
    return cnt

if len(sys.argv) > 2:
    print(countFilpped(int(sys.argv[1]), int(sys.argv[2])))
else:
    print(countFilpped(7, 10))

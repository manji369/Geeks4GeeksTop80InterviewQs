'''
Q16. Write a program to print Binary representation of a given number.
'''

import sys

def toInt(s):
    cur = 0
    s = s[::-1]
    pw = 1
    for c in s:
        if c == '1':
            cur += pw
        pw *= 2
    return cur

def toBinary(n):
    if n == 0:
        return '0'
    res = ''
    while n:
        res = str((n&1)) + res
        n //= 2
    return res

def toBinaryRecUtil(n, res):
    if n == 0:
        return res
    res = str((n&1)) + res
    n //= 2
    return toBinaryRecUtil(n, res)

def toBinaryRec(n):
    if n == 0:
        return '0'
    return toBinaryRecUtil(n, '')

def printUtil(i):
    print(str(i) + ": " + toBinaryRec(i))

if __name__ == "__main__":
    if len(sys.argv) == 2:
        printUtil(int(sys.argv[1]))
    elif len(sys.argv) == 3:
        a, b = map(int, sys.argv[1:])
        for i in range(a, b):
            printUtil(i)
    else:
        for i in range(32):
            printUtil(i)

'''
Q20. A number is Sparse if there are no two adjacent 1s in its binary
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
'''

from binaryRepresentationOfAGivenNumber import toBinary, toInt
import sys

def nextSparseNum(n):
    binN = list(toBinary(n))
    maxInd = -1
    for i in range(len(binN)-1, 0, -1):
        if binN[i] == '1':
            if binN[i-1] == '1':
                if i == 1:
                    binN = ['1'] + binN
                    maxInd = 0
                    binN[1:3] = ['0', '0']
                else:
                    binN[i-2] = '1'
                    maxInd = i-2
                    binN[i-1:i+1] = ['0', '0']
    if maxInd != -1:
        for i in range(maxInd+1, len(binN)):
            binN[i] = '0'
    return toInt(''.join(binN))


def printUtil(i):
    print("Next sparse number for " + str(i) + ": " + str(nextSparseNum(i)))

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

'''
Q2 Given a string, print all possible palindromic partitions

Given a string, find all possible palindromic partitions of given string.

Example:
input: nitin
output:
n i t i n
n iti n
nitin
'''

def isPalindrome(s, low, high):
    while(low < high):
        if s[low] != s[high]:
            return False
        low += 1
        high -= 1
    return True

def printPalindromesUtil(allPals, curPal, start, end, s):
    if(start >= end):
        allPals.append(curPal[:])
        return
    for i in range(start, end):
        if isPalindrome(s, start, i):
            curPal.append(s[start:i+1])
            printPalindromesUtil(allPals, curPal, i+1, end, s)
            curPal.pop()

def printPalindromes(s):
    n = len(s)
    allPals = []
    curPal = []
    printPalindromesUtil(allPals, curPal, 0, n, s)
    for presPal in allPals:
        for pal in presPal:
            print(pal + ' ', end='')
        print()

printPalindromes('nitin')

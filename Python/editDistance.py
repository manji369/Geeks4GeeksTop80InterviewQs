'''
Q43. Given two strings str1 and str2 and below operations that can performed on
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
'''

def editDistance(a, b):
    m = len(a); n = len(b)
    L = [[0]*(n+1) for i in range(m+1)]
    for i in range(m+1):
        for j in range(n+1):
            if i == 0:
                L[i][j] = j
            elif j == 0:
                L[i][j] = i
            elif a[i-1] == b[j-1]:
                L[i][j] = L[i-1][j-1]
            else:
                L[i][j] = 1+min(L[i-1][j-1], L[i-1][j], L[i][j-1])
    return L[m][n]

print(editDistance('sunday', 'saturday'))

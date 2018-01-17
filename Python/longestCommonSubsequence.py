'''
Q41. LCS Problem Statement: Given two sequences, find the length of longest
subsequence present in both of them. A subsequence is a sequence that appears
in the same relative order, but not necessarily contiguous. For example, “abc”,
 “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a
 string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison
program that outputs the differences between two files), and has applications
in bioinformatics.
'''

def lcs(a, b):
    m = len(a); n = len(b)
    lcs = [[None]*(n+1) for y in range(m+1)]
    for i in range(m+1):
        for j in range(n+1):
            if i == 0 or j == 0:
                lcs[i][j] = 0
            elif a[i-1] == b[j-1]:
                lcs[i][j] = lcs[i-1][j-1]+1
            else:
                lcs[i][j] = max(lcs[i-1][j], lcs[i][j-1])
    llcs = lcs[m][n]
    res = ['']*llcs
    i = m; j = n; ind = llcs
    while i > 0 and j > 0:
        if a[i-1] == b[j-1]:
            res[ind-1] = a[i-1]
            i -= 1; j -= 1; ind -= 1
        else:
            if lcs[i-1][j] > lcs[i][j-1]:
                i -= 1
            else:
                j -= 1
    return ''.join(res)


print(lcs('AGGTAB', 'GXTXAYB'))

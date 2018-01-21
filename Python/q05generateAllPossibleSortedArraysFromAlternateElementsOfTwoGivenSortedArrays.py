'''Q5. Given two sorted arrays A and B, generate all possible arrays such that first element is taken from A then from B then from A and so on in increasing order till the arrays exhausted. The generated arrays should end with an element from B.

For Example
A = {10, 15, 25}
B = {1, 5, 20, 30}

The resulting arrays are:
  10 20
  10 20 25 30
  10 30
  15 20
  15 20 25 30
  15 30
  25 30
'''

def generateArraysUtil(A, B, C, i, j, m, n, AorB, leng):
    if AorB:
        if leng != 0:
            print(C[:leng+1])
        for k in range(i, m):
            if leng == 0:
                C[0] = A[k]
                generateArraysUtil(A, B, C, k+1, j, m, n, False, leng)
            elif A[k] > C[leng]:
                C[leng+1] = A[k]
                generateArraysUtil(A, B, C, k+1, j, m, n, False, leng+1)
    else:
        for l in range(j, n):
            if B[l] > C[leng]:
                C[leng+1] = B[l]
                generateArraysUtil(A, B, C, i, l+1, m, n, True, leng+1)

def generateArrays(A, B):
    m, n = len(A), len(B)
    C = [0 for x in range(m+n)]
    generateArraysUtil(A, B, C, 0, 0, m, n, True, 0)


generateArrays([10, 15, 25], [1, 5, 20, 30])

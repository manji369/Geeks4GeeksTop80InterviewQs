'''
Q47. Given a set of non-negative integers, and a value sum, determine if there
is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
'''

# DP solution
def isSubsetSumDPUtil(s, sm, n):
    dp = [[False]*(sm+1) for i in range(n+1)]
    for i in range(n+1):
        dp[i][0] = True
    for j in  range(1, sm+1):
        dp[0][j] = False
    for i in range(1, n+1):
        for j in range(1, sm+1):
            dp[i][j] = dp[i-1][j]
            if s[i-1] <= j:
                dp[i][j] |= dp[i-1][j-s[i-1]]
    return dp[n][sm]

def isSubsetSumDP(s, sm):
    return isSubsetSumDPUtil(s, sm, len(s))

# Recursive Solution
def isSubsetSumRecUtil(s, sm, n):
    if sm == 0:
        return True
    if n == 0 and sm != 0:
        return False
    if s[n-1] > sm:
        return isSubsetSumRecUtil(s, sm, n-1)
    return isSubsetSumRecUtil(s, sm, n-1) or isSubsetSumRecUtil(s, sm-s[n-1], n-1)

def isSubsetSumRec(s, sm):
    return isSubsetSumRecUtil(s, sm, len(s))

print(isSubsetSumRec([3, 34, 4, 12, 5, 2], 9))
print(isSubsetSumRec([3, 34, 3, 12, 5, 2], 9))
print(isSubsetSumDP([3, 34, 4, 12, 5, 2], 9))
print(isSubsetSumDP([3, 34, 3, 12, 5, 2], 9))
print(isSubsetSumDP([1, 2, 3], 7))

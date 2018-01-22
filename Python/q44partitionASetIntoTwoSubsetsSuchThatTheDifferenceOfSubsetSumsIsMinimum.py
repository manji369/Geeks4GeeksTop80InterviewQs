'''
Q44. Given a set of integers, the task is to divide it into two sets S1 and S2
such that the absolute difference between their sums is minimum.

If there is a set S with n elements, then if we assume Subset1 has m elements,
Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2))
should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5}
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12
Subset2 = {11}, sum of Subset2 = 11
'''

# DP solution:
def findMinPartitionDP(arr):
    sm = sum(arr); n = len(arr)
    dp = [[0]*(sm+1) for x in range(n+1)]
    for i in range(n+1):
        dp[i][0] = True
    for j in range(1, sm+1):
        dp[0][j] = False
    for i in range(1, n+1):
        for j in range(1, sm+1):
            dp[i][j] = dp[i-1][j]
            if arr[i-1] <= j:
                dp[i][j] |= dp[i-1][j-arr[i-1]]
    for j in range(sm//2, -1, -1):
        if dp[n][j]:
            return sm-2*j
    return sm



# Recursive solution:
def findMinPartitionRecUtil(arr, i, curSum, totalSum):
    if i == 0:
        return abs(curSum - (totalSum-curSum))
    return min(findMinPartitionRecUtil(arr, i-1, curSum+arr[i-1], totalSum), \
    findMinPartitionRecUtil(arr, i-1, curSum, totalSum))

def findMinPartitionRec(arr):
    return findMinPartitionRecUtil(arr, len(arr), 0, sum(arr))



print(findMinPartitionRec([3, 1, 4, 2, 2, 1]))
print(findMinPartitionDP([3, 1, 4, 2, 2, 1]))

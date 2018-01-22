'''
Q46. Given a n*n matrix where all numbers are distinct and less than n^2,
find the maximum length path (starting from any cell) such that all cells along
the path are in increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to
(i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the
adjacent cells have a difference of 1.

Example:

Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9.
'''

def longestPathUtil(arr, i, j, dp, n):
    if i < 0 or i >= n or j < 0 or j >= n:
        return 0
    if dp[i][j] != -1:
        return dp[i][j]
    if i > 0 and arr[i][j] + 1 == arr[i-1][j]:
        dp[i][j] = longestPathUtil(arr, i-1, j, dp, n) + 1
    elif i < n-1 and arr[i][j] + 1 == arr[i+1][j]:
        dp[i][j] = longestPathUtil(arr, i+1, j, dp, n) + 1
    elif j > 0 and arr[i][j] + 1 == arr[i][j-1]:
        dp[i][j] = longestPathUtil(arr, i, j-1, dp, n) + 1
    elif j < n-1 and arr[i][j] + 1 == arr[i][j+1]:
        dp[i][j] = longestPathUtil(arr, i, j+1, dp, n) + 1
    else:
        dp[i][j] = 1
    return dp[i][j]

def longestPath(arr):
    n = len(arr)
    dp = [[-1]*n for i in range(n)]
    res = 1
    for i in range(n):
        for j in range(n):
            if dp[i][j] == -1:
                longestPathUtil(arr, i, j, dp, n)
            res = max(res, dp[i][j])
    return res

print(longestPath([[1, 2, 9], [5, 3, 8], [4, 6, 7]]))
print(longestPath([[1, 2, 3], [8, 9, 4], [7, 6, 5]]))

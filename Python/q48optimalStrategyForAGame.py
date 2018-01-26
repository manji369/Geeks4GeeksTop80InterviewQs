'''
Q48. Problem statement: Consider a row of n coins of values v1 . . . vn, where
n is even. We play a game against an opponent by alternating turns. In each
turn, a player selects either the first or last coin from the row, removes it
from the row permanently, and receives the value of the coin. Determine the
maximum possible amount of money we can definitely win if we move first.

Note: The opponent is as clever as the user.
'''

def optimalStrategyRecUtil(arr, low, high, sm):
    if low < high:
        high1 = high; low1 = low+1; high2 = high-1; low2 = low
        if arr[low+1] > arr[high]:
            low1 = low+2
        else:
            high1 = high-1
        if arr[high-1] > arr[low]:
            high2 = high-2
        else:
            low2 = low+1
        return max(optimalStrategyRecUtil(arr, low1, high1, sm+arr[low]),\
        optimalStrategyRecUtil(arr, low2, high2, sm+arr[high]))
    return sm

def optimalStrategyRec(arr):
    return optimalStrategyRecUtil(arr, 0, len(arr)-1, 0)

def optimalStrategyminimaxDP(arr):
    n = len(arr)
    dp = [[0]*n for i in range(n)]
    # diagonal up manner
    for gap in range(n):
        j = gap; i = 0
        while j < n:
            x = dp[i+2][j] if (i+2) <= j else 0
            y = dp[i+1][j-1] if (i+1) <= (j-1) else 0
            z = dp[i][j-2] if i <= (j-2) else 0
            dp[i][j] = max(arr[i]+min(x,y), arr[j]+min(y,z))
            j += 1; i += 1
    return dp[0][n-1]


def optimalStrategyminimaxRecUtil(arr, i, j):
    if i == j:
        return arr[i]
    if j == i+1:
        return max(arr[i], arr[j])
    return max(arr[i]+min(optimalStrategyminimaxRecUtil(arr, i+2, j), optimalStrategyminimaxRecUtil(arr, i+1, j-1)),\
    arr[j]+min(optimalStrategyminimaxRecUtil(arr, i, j-2), optimalStrategyminimaxRecUtil(arr, i+1, j-1)))

def optimalStrategyminimaxRec(arr):
    return optimalStrategyminimaxRecUtil(arr, 0, len(arr)-1)

print(optimalStrategyRec([5, 3, 7, 10]))
print(optimalStrategyRec([8, 15, 3, 7]))
print(optimalStrategyminimaxRec([5, 3, 7, 10]))
print(optimalStrategyminimaxRec([8, 15, 3, 7]))
print(optimalStrategyminimaxDP([5, 3, 7, 10]))
print(optimalStrategyminimaxDP([8, 15, 3, 7]))

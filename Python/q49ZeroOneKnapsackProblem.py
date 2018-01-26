'''
Q49. Given weights and values of n items, put these items in a knapsack of
capacity W to get the maximum total value in the knapsack. In other words,
given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
weights associated with n items respectively. Also given an integer W which
represents knapsack capacity, find out the maximum value subset of val[] such
that sum of the weights of this subset is smaller than or equal to W. You
cannot break an item, either pick the complete item, or don’t pick it
(0-1 property).
eg.
value = 60, 100, 120    weight = 10, value = 60
weight = 10, 20, 30     weight = 20, value = 100
W = 50                  weight = 30, value = 120
                        weight = (20+10), value = (100+60)
Solution: 220           weight = (30+10), value = (60+120)
                        weight = (20+30), value = (100+120)
                        weight = (10+20+30), value = (60+100+120)
'''

def knapsackRecUtil(values, weights, W, n):
    if n == 0 or W == 0:
        return 0
    if weights[n-1] > W:
        return knapsackRecUtil(values, weights, W, n-1)
    return max(knapsackRecUtil(values, weights, W, n-1), values[n-1] + knapsackRecUtil(values, weights, W-weights[n-1], n-1))

def knapsackRec(values, weights, W):
    return knapsackRecUtil(values, weights, W, len(values))

def knapsackDP(values, weights, W):
    n = len(values)
    dp = [[0]*(W+1) for x in range(n+1)]
    for i in range(n+1):
        for w in range(W+1):
            if i == 0 or w == 0:
                dp[i][w] = 0
            elif weights[i-1] > w:
                dp[i][w] = dp[i-1][w]
            else:
                dp[i][w] = max(dp[i-1][w], values[i-1]+dp[i-1][w-weights[i-1]])
    return dp[n][W]

print(knapsackRec([60, 100, 120], [10, 20, 30], 50))
print(knapsackDP([60, 100, 120], [10, 20, 30], 50))

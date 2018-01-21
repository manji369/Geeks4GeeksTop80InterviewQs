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


# Recursive solution:
def findMinPartitionRecUtil(arr, i, curSum, totalSum):
    if i == 0:
        return abs(curSum - (totalSum-curSum))
    return min(findMinPartitionRecUtil(arr, i-1, curSum+arr[i-1], totalSum), \
    findMinPartitionRecUtil(arr, i-1, curSum, totalSum))

def findMinPartitionRec(arr):
    return findMinPartitionRecUtil(arr, len(arr), 0, sum(arr))



print(findMinPartitionRec([1, 6, 11, 5]))

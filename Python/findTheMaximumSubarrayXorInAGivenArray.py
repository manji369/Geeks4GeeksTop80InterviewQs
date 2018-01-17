'''
Q11. Given an array of integers. find the maximum XOR subarray value in given array. Expected time complexity O(n).

Examples:

Input: arr[] = {1, 2, 3, 4}
Output: 7
The subarray {3, 4} has maximum XOR value

Input: arr[] = {8, 1, 2, 12, 7, 6}
Output: 15
The subarray {1, 2, 12} has maximum XOR value

Input: arr[] = {4, 6}
Output: 6
The subarray {6} has maximum XOR value
'''

# O(N^2)
def maxXorSubarrayN2(arr):
    n = len(arr)
    maxXor = -float('inf')
    for i in range(n):
        curXor = 0
        for j in range(i, n):
            curXor ^= arr[j]
            maxXor = max(maxXor, curXor)
    return maxXor

# O(N)
def maxXorSubarrayN(arr):
    prefixIndex = 0
    curXor = arr[0]
    maxXor = -float('inf')
    i = 1
    while i < len(arr):
        if(arr[i]^curXor > curXor):
            curXor ^= arr[i]
            i += 1
        else:
            curXor ^= arr[prefixIndex]
            prefixIndex += 1
        if maxXor < curXor:
            maxXor = curXor
    if maxXor == -float('inf'):
        maxXor = curXor
    return maxXor

print(maxXorSubarrayN([8, 2, 1, 12]))

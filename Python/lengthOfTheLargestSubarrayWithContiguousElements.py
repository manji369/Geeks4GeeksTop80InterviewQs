'''
Q7. Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.

Examples:

Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5
'''


def longestContiguousSubarray(arr):
    maxLength = 0
    for i in range(len(arr)):
        minVal = float('inf')
        maxVal = -minVal
        for j in range(i, len(arr)):
            minVal, maxVal = min(minVal, arr[j]), max(maxVal, arr[j])
            if maxVal-minVal == j-i:
                maxLength = max(j-i+1, maxLength)
            if maxLength == len(arr):
                return maxLength
    return maxLength

print(longestContiguousSubarray([1, 56, 58, 57, 90, 92, 94, 93, 91, 45]))

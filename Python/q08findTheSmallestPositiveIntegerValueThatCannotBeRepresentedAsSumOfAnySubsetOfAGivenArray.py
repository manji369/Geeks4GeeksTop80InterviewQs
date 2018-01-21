'''
Q8. Given a sorted array (sorted in non-decreasing order) of positive numbers, find the smallest positive integer value that cannot be represented as sum of elements of any subset of given set.
Expected time complexity is O(n).

Examples:

Input:  arr[] = {1, 3, 6, 10, 11, 15};
Output: 2

Input:  arr[] = {1, 1, 1, 1};
Output: 5

Input:  arr[] = {1, 1, 3, 4};
Output: 10

Input:  arr[] = {1, 2, 5, 10, 20, 40};
Output: 4

Input:  arr[] = {1, 2, 3, 4, 5, 6};
Output: 22
'''

def smallestValue(arr):
    smallestVal = 1
    for a in arr:
        if a > smallestVal:
            return smallestVal
        else:
            smallestVal += a
    return smallestVal

print(smallestValue([1, 2, 3, 4, 5, 6]))

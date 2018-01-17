'''
Q9. Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.
'''

def smallestSubArray(arr, x):
    cur_sum = 0
    low = 0
    high = 0
    min_length = float('inf')
    for i in range(len(arr)):
        cur_sum += arr[i]
        while cur_sum > x:
            min_length = min(min_length, high-low+1)
            cur_sum -= arr[low]
            low += 1
        high += 1
    if min_length == float('inf'):
        return 'Not Possible'
    return min_length

print(smallestSubArray([1, 2, 4], 8))

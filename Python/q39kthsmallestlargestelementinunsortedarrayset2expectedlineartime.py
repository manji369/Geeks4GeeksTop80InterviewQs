'''
Q39. Given an array and a number k where k is smaller than size of array, we
need to find the kth smallest element in the given array. It is given that all
array elements are distinct.

Examples:

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 3
Output: 7

Input: arr[] = {7, 10, 4, 3, 20, 15}
       k = 4
Output: 10
'''
import random

def kthSmallestUtil(arr, low, high, k):
    if k > 0 and k <= high-low+1:
        pos = randomPartition(arr, low, high)
        if pos-low == k-1:
            return arr[pos]
        if pos-low > k-1:
            return kthSmallestUtil(arr, low, pos-1, k)
        return kthSmallestUtil(arr, pos+1, high, k-(pos+1-low))
    return float('inf')

def kthSmallest(arr, k):
    return kthSmallestUtil(arr, 0, len(arr)-1, k)

def partition(arr, low, high):
    i = low; pivot = arr[high]
    for j in range(low, high):
        if arr[j] <= pivot:
            arr[j], arr[i] = arr[i], arr[j]
            i += 1
    arr[high], arr[i] = arr[i], arr[high]
    return i

def randomPartition(arr, low, high):
    pi = random.randint(low, high)
    arr[pi], arr[high] = arr[high], arr[pi]
    return partition(arr, low, high)

print(kthSmallest([7, 10, 4, 3, 20, 15], 3))

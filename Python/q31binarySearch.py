'''
Q31. Binary Search
1.5
Given a sorted array arr[] of n elements, write a function to search a given
element x in arr[].
'''

def binarySearchUtil(arr, start, end, x):
    mid = (start+end)//2
    while(start <= end):
        if arr[mid] == x:
            return mid
        if arr[mid] < x:
            return binarySearchUtil(arr, mid+1, end, x)
        else:
            return binarySearchUtil(arr, start, mid-1, x)
    return -1

def binarySearchRec(arr, x):
    return binarySearchUtil(arr, 0, len(arr)-1, x)

def binarySearchIter(arr, x):
    start = 0; end = len(arr)-1
    while(start <= end):
        mid = (start+end)//2
        if arr[mid] == x:
            return mid
        if arr[mid] < x:
            start = mid+1
        else:
            end = mid-1
    return -1

print(binarySearchIter([2, 3, 4, 10, 40], 10))

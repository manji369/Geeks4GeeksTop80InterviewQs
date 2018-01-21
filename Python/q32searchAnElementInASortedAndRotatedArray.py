'''
Q32. An element in a sorted array can be found in O(log n) time via binary
search. But suppose we rotate an ascending order sorted array at some pivot
unknown to you beforehand. So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
Devise a way to find an element in the rotated array in O(log n) time.

sortedPivotedArray

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10
Output : Found at index 3
'''

def binarySearchRotatedArray(arr, x):
    start = 0; end = len(arr)-1
    while(start <= end):
        mid = (start+end)//2
        if arr[mid] == x:
            return mid
        if arr[start] <= arr[mid]:
            if arr[start] <= x < arr[mid]:
                end = mid-1
            else:
                start = mid+1
        else:
            if arr[mid] < x <= arr[end]:
                start = mid+1
            else:
                end = mid-1
    return -1

print(binarySearchRotatedArray([5, 6, 7, 8, 9, 10, 1, 2, 3], 1))

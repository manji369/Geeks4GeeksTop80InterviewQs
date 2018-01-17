'''Q4. Convert array into Zig-Zag fashion
2.4
Given an array of distinct elements, rearrange the elements of array in zig-zag fashion in O(n) time. The converted array should be in form a < b > c < d > e < f.

Example:
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}'''

def convertArray(arr):
    bigFlag = True
    for i in range(1, len(arr)-1):
        if bigFlag:
            if arr[i] > arr[i-1] and arr[i] < arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]
            elif arr[i] < arr[i-1] and arr[i] > arr[i+1]:
                arr[i], arr[i-1] = arr[i-1], arr[i]
        else:
            if arr[i] < arr[i-1] and arr[i] > arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]
            elif arr[i] > arr[i-1] and arr[i] < arr[i+1]:
                arr[i], arr[i-1] = arr[i-1], arr[i]
        bigFlag = not bigFlag

arr = [4, 3, 7, 8, 6, 2, 1]
convertArray(arr)
print(arr)

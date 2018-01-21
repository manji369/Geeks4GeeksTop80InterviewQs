'''
Q37. Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an
element as pivot and partitions the given array around the picked pivot. There
are many different versions of quickSort that pick pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an
array and an element x of array as pivot, put x at its correct position in
sorted array and put all smaller elements (smaller than x) before x, and put
all greater elements (greater than x) after x. All this should be done in
linear time.
'''

def partition(arr, low, high):
    pivot = arr[high]
    i = low-1
    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    arr[i+1], arr[high] = arr[high], arr[i+1]
    return i+1

def quickSortUtil(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)
        quickSortUtil(arr, low, pi-1)
        quickSortUtil(arr, pi+1, high)

def quickSort(arr):
    quickSortUtil(arr, 0, len(arr)-1)

arr = [2, 14, 2, -1, 7, 5, 7, 8]
quickSort(arr)
print(arr)

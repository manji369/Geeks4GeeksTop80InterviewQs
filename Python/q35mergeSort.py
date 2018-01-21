'''
Q35. Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides
input array in two halves, calls itself for the two halves and then merges the
two sorted halves. The merge() function is used for merging two halves.
'''

def merge(arr, start, mid, end):
    n1 = mid-start+1; n2 = end-mid;
    L = [arr[start + i] for i in range(n1)]
    R = [arr[mid + i + 1] for i in range(n2)]
    i = 0; j = 0; k = start
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1
    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1
    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1

def mergeSortUtil(arr, start, end):
    if start < end:
        mid = (start+end)//2
        mergeSortUtil(arr, start, mid)
        mergeSortUtil(arr, mid+1, end)
        merge(arr, start, mid, end)

def mergeSort(arr):
    mergeSortUtil(arr, 0, len(arr)-1)

arr = [2, 5, 1, 4, 6, 3, -1]
mergeSort(arr)
print(arr)

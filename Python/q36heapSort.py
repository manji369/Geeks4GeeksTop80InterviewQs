'''
Q36. Heap sort is a comparison based sorting technique based on Binary Heap data
structure. It is similar to selection sort where we first find the maximum
element and place the maximum element at the end. We repeat the same process
for remaining element.

Heap Sort Algorithm for sorting in increasing order:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace
it with the last item of the heap followed by reducing the size of heap by 1.
Finally, heapify the root of tree.
3. Repeat above steps while size of heap is greater than 1.
'''

def heapify(arr, n, i):
    mx = i
    l = 2*i+1
    r = 2*i+2
    if l < n and arr[mx] < arr[l]:
        mx = l
    if r < n and arr[mx] < arr[r]:
        mx = r
    if mx != i:
        arr[i], arr[mx] = arr[mx], arr[i]
        heapify(arr, n, mx)

def heapSort(arr):
    n = len(arr)
    for i in range(n//2-1, -1, -1):
        heapify(arr, n, i)
    for i in range(n-1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)

arr = [3, 6, 2, 5, 4, 1]
heapSort(arr)
print(arr)

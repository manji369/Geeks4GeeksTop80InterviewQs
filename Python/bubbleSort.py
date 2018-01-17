'''
Q33. Bubble Sort is the simplest sorting algorithm that works by repeatedly
swapping the adjacent elements if they are in wrong order.
'''

def bubbleSort(arr):
    flag = True
    n = len(arr)
    while flag:
        flag = False
        for i in range(n-1):
            if arr[i] > arr[i+1]:
                flag = True
                arr[i], arr[i+1] = arr[i+1], arr[i]
    return arr

print(bubbleSort([2, 5, 1, 4, 3, 6]))

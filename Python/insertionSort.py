'''
Q34. Insertion sort is a simple sorting algorithm that works the way we sort
playing cards in our hands.
Example:
12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13
'''

def insertionSort(arr):
    for i in range(1, len(arr)):
        cur = arr[i]
        j = i-1
        while j >= 0 and cur < arr[j]:
            arr[j+1] = arr[j]
            j -= 1
        arr[j+1] = cur
    return arr

print(insertionSort([12, 11, 13, 5, 6]))

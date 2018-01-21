'''
Q40. Given a sorted array and a number x, find a pair in array whose sum is
closest to x.

Examples:

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10
'''

def sumClosest(arr, x):
    low = 0; high = len(arr)-1
    minAbsDiff = float('inf'); indl = high-1; indh = high
    while low < high:
        sm = arr[low] + arr[high]
        if sm == x:
            return (arr[low], arr[high])
        if abs(sm-x) < minAbsDiff:
            minAbsDiff = abs(sm-x)
            indl = low
            indh = high
        if sm < x:
            low += 1
        else:
            high -= 1
    return (arr[indl], arr[indh])


print(sumClosest([10, 22, 28, 29, 30, 40], 54))
print(sumClosest([1, 3, 4, 7, 10], 15))

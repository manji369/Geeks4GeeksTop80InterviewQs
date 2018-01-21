'''
38. Given a sorted array of n uniformly distributed values arr[], write a function
to search for a particular element x in the array.

Linear Search finds the element in O(n) time, Jump Search takes O(√ n) time and
Binary Search take O(Log n) time.
The Interpolation Search is an improvement over Binary Search for instances,
where the values in a sorted array are uniformly distributed. Binary Search
always goes to middle element to check. On the other hand interpolation search
may go to different locations according the value of key being searched. For
example if the value of key is closer to the last element, interpolation search
is likely to start search toward the end side.

To find the position to be searched, it uses following formula.

// The idea of formula is to return higher value of pos
// when element to be searched is closer to arr[hi]. And
// smaller value when closer to arr[lo]
pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]

arr[] ==> Array where elements need to be searched
x     ==> Element to be searched
lo    ==> Starting index in arr[]
hi    ==> Ending index in arr[]
'''

def interpolationSearch(arr, x):
    low = 0; n = len(arr); high = n-1
    while low <= high and x >= arr[low] and x <= arr[high]:
        pos = low + ((x-arr[low])*(high-low)//(arr[high]-arr[low]))
        if arr[pos] == x:
            return pos
        if arr[pos] < x:
            low = pos+1
        else:
            high = pos-1
    return -1

print(interpolationSearch([-2, 0, 1, 5, 8, 11, 32], 0))

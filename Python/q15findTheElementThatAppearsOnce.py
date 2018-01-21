'''
Q15. Given an array where every element occurs three times, except one element
which occurs only once. Find the element that occurs once. Expected time
complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2
'''

def singleElement(arr):
    res = 0
    pw = 1
    for i in range(32):
        cnt = 0
        for j in range(len(arr)):
            cnt += (arr[j]&1)
            arr[j] //= 2
        res += (cnt%3)*pw
        pw *= 2
    return res


print(singleElement([12, 1, 12, 3, 12, 1, 1, 2, 3, 3, 2, 2, 501]))

'''
Q6. Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.

Example:

Input: arr[] = {3, 1, 4, 6, 5}
Output: True
There is a Pythagorean triplet (3, 4, 5).

Input: arr[] = {10, 4, 6, 12, 5}
Output: False
There is no Pythagorean triplet.
'''

def hasTriplet(arr):
    arr = [x*x for x in arr]
    arr.sort(reverse=True)
    n = len(arr)
    for i in range(n):
        a = arr[i]
        end = n-1
        start = i+1
        while start < end:
            bc = arr[start] + arr[end]
            if bc == a:
                return True
            elif bc > a:
                start += 1
            else:
                end -= 1
    return False

print(hasTriplet([10, 4, 6, 12, 5]))

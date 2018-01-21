'''
Q42. The Longest Increasing Subsequence (LIS) problem is to find the length of
the longest subsequence of a given sequence such that all elements of the
subsequence are sorted in increasing order. For example, the length of LIS for
{10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
'''

def lis(arr):
    n = len(arr); L = [1]*len(arr)
    for i in range(1, n):
        for j in range(i):
            if arr[i] >= arr[j] and L[j]+1 > L[i]:
                L[i] = L[j]+1
    return max(L)

print(lis([3, 2, 6, 4, 5, 1]))

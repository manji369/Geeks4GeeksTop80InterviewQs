'''Q3. Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3)

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 4
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and
               (1, 4, 5)'''

def countTriplets(arr, target):
    arr.sort()
    n = len(arr)
    res = 0
    for i in range(n):
        j = i+1
        k = n-1
        while j < k:
            if arr[i] + arr[j] + arr[k] >= target:
                k -= 1
            else:
                res += (k-j)
                j += 1
    return res

print(countTriplets([5, 1, 3, 4, 7], 12))

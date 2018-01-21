'''Q1. Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.

Examples:

Input:   str = "a,b$c"
Output:  str = "c,b$a"
Note that $ and , are not moved anywhere.
Only subsequence "abc" is reversed

Input:   str = "Ab,c,de!$"
Output:  str = "ed,c,bA!$"'''

def isNotAlpha(ch):
    return not ((ch >= 'A' and ch <= 'Z') or (ch >= 'a' and ch <= 'z'))

def reverse(arr):
    start = 0; end = len(arr) - 1
    while(start < end):
        if isNotAlpha(arr[start]):
            start += 1
        elif isNotAlpha(arr[end]):
            end -= 1
        else:
            arr[start], arr[end] = arr[end], arr[start]
            start += 1
            end -= 1

arr = list('Ab,c,de!$')
reverse(arr)
print(arr)

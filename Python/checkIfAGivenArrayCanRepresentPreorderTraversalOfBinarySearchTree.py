'''
Q23. Given an array of numbers, return true if given array can represent
preorder traversal of a Binary Search Tree, else return false. Expected time
complexity is O(n).

Examples:

Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2

      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /
 30    80

  35     100


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.
'''

def isPreBSTN2(pre):
    if len(pre) < 2:
        return True
    i = 0
    cur = pre[i]
    i += 1
    while pre[i] < cur:
        i += 1
    j = i
    flag = True
    k = j+1
    while k < len(pre):
        if pre[k] < cur:
            flag = False
            break
        k += 1
    return flag and isPreBST(pre[1:j]) and isPreBST(pre[j+1:len(pre)])

def isPreBSTN(pre):
    root = -float('inf')
    s = []
    for a in pre:
        if a < root:
            return False
        while len(s) > 0 and s[-1] < a:
            root = s.pop()
        s.append(a)
    return True

print(isPreBSTN([40, 30, 35, 20, 80, 100]))

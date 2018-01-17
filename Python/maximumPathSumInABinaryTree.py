'''
Q12. Given a binary tree, find the maximum path sum. The path may start and end
at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6

'''

from Node import Node

def findMaxPathSumUtil(root):
    if root is None:
        return 0
    l = findMaxPathSumUtil(root.left)
    r = findMaxPathSumUtil(root.right)
    maxOneSide = max(max(l,r) + root.data, root.data)
    maxBothSides = max(maxOneSide, l+r+root.data)
    findMaxPathSumUtil.res = max(findMaxPathSumUtil.res, maxBothSides)
    return maxOneSide

def findMaxPathSum(root):
    findMaxPathSumUtil.res = float("-inf")
    findMaxPathSumUtil(root)
    return findMaxPathSumUtil.res

root = Node(10)
root.left = Node(2)
root.right   = Node(10);
root.left.left  = Node(20);
root.left.right = Node(1);
root.right.right = Node(-25);
root.right.right.left   = Node(3);
root.right.right.right  = Node(4);

print(findMaxPathSum(root))

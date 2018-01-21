'''
Q21. iven a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.

For example, minimum height of below Binary Tree is 2.
Example Tree

          1
        /  \
      2     3
     / \
    4   5
'''

from Node import Node

def minDepth(root):
    if root is None:
        return 0
    cnt = 1
    q = []
    q.append([root])
    while(len(q) > 0):
        curQ = []
        items = q.pop(0)
        for item in items:
            if item.left is None and item.right is None:
                return cnt
            if item.right is None:
                curQ.append(item.left)
            elif item.left is None:
                curQ.append(item.right)
            else:
                curQ.extend([item.left, item.right])
        q.append(curQ[:])
        cnt += 1
    return cnt

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.left.right.left = Node(6)
root.right.right = Node(7)
print(minDepth(root))

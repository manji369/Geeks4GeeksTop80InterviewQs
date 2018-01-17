'''
Q28. Given values of two values n1 and n2 in a Binary Search Tree, find the
Lowest Common Ancestor (LCA). You may assume that both the values exist in the
tree.
Example:
                20
               / \
              8   22
             / \
            4  12
              / \
             10  14
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20
'''
from Node import Node

def lca(root, n1, n2):
    if root is None:
        return None
    if root.data > n1 and root.data > n2:
        return lca(root.left, n1, n2)
    if root.data < n1 and root.data < n2:
        return lca(root.right, n1, n2)
    return root

root = Node(20)
root.left = Node(8)
root.right = Node(22)
root.left.left = Node(4)
root.left.right = Node(12)
root.left.right.left = Node(10)
root.left.right.right = Node(14)
print(lca(root, 22, 20).data)

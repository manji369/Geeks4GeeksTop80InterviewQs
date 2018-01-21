'''
q24. A full binary tree is defined as a binary tree in which all nodes have
either zero or two child nodes. Conversely, there is no node in a full binary
tree, which has one child node. More information about full binary trees can be
found here.
'''

from Node import Node

def isBinaryTree(root):
    if root is None:
        return True
    if root.left is None and root.right is None:
        return True
    if root.left is not None and root.right is not None:
        return isBinaryTree(root.left) and isBinaryTree(root.right)
    return False

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.right.left = Node(4)
root.right.right = Node(5)
print(isBinaryTree(root))

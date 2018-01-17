'''
Q27. Given a Binary Tree and a number k, remove all nodes that lie only on root
to leaf path(s) of length smaller than k. If a node X lies on multiple
root-to-leaf paths and if any of the paths has path length >= k, then X is
not deleted from Binary Tree. In other words a node is deleted if all paths
going through it have lengths smaller than k.

Consider the following example Binary Tree

               1
           /      \
         2          3
      /     \         \
    4         5        6
  /                   /
 7                   8
Input: Root of above Binary Tree
       k = 4

Output: The tree should be changed to following
           1
        /     \
      2          3
     /             \
   4                 6
 /                  /
7                  8
There are 3 paths
i) 1->2->4->7      path length = 4
ii) 1->2->5        path length = 3
iii) 1->3->6->8    path length = 4
There is only one path " 1->2->5 " of length smaller than 4.
The node 5 is the only node that lies only on this path, so
node 5 is removed.
Nodes 2 and 1 are not removed as they are parts of other paths
of length 4 as well.

If k is 5 or greater than 5, then whole tree is deleted.

If k is 3 or less than 3, then nothing is deleted.
'''

from Node import Node

def removeNodesUtil(root, l, k):
    if root is None:
        return None
    root.left = removeNodesUtil(root.left, l+1, k)
    root.right = removeNodesUtil(root.right, l+1, k)
    if root.left is None and root.right is None and l < k:
        return None
    return root

def removeNodes(root, k):
    return removeNodesUtil(root, 1, k)

def printInorder(root):
    if root is not None:
        printInorder(root.left)
        print(root.data, end=' ')
        printInorder(root.right)

root = Node(1)
root.left = Node(2)
root.left.left = Node(4)
root.left.left.left = Node(7)
root.right = Node(3)
root.right.right = Node(6)
root.right.right.left = Node(8)
root = removeNodes(root, 4)
printInorder(root)
print()

'''
Q29. Given two binary trees, check if the first tree is subtree of the second
one. A subtree of a tree T is a tree S consisting of a node in T and all of its
descendants in T.

The subtree corresponding to the root node is the entire tree; the subtree
corresponding to any other node is called a proper subtree.

For example, in the following case, Tree1 is a subtree of Tree2.


        Tree1
          2
        /    \
      4       5
       \
        7


        Tree2
              1
            /   \
          2      3
        /    \     \
      4       5      6
       \
        7
'''
from Node import Node

def traversePreOrder(t1, t2):
    if t1 is None:
        return True
    if t1 is not None and t2 is None:
        return False
    if t1.data != t2.data:
        return False
    return traversePreOrder(t1.left, t2.left) and traversePreOrder(t1.right, t2.right)


def isSubTreeN2(t1, t2):
    curQ = [t2]
    while len(curQ) > 0:
        items = curQ[:]
        curQ = []
        for item in items:
            if traversePreOrder(t1, item):
                return True
            if item.left is not None and item.right is not None:
                curQ.extend([item.left, item.right])
            elif item.left is not None:
                curQ.append(item.left)
            elif item.right is not None:
                curQ.append(item.right)
    return False

t1 = Node(2)
t1.left = Node(4)
t1.right = Node(5)
t1.left.right = Node(7)
# t1.left.left = Node(8)
t2 = Node(1)
t2.left = Node(2)
t2.left.left = Node(4)
t2.left.right = Node(5)
t2.left.left.right = Node(7)
t2.right = Node(3)
t2.right.right = Node(6)
print(isSubTreeN2(t1, t2))

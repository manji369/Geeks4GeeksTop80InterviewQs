'''
Q26. Top view of a binary tree is the set of nodes visible when the tree is
viewed from the top. Given a binary tree, print the top view of it. The output
nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance.
Horizontal distance of left child of a node x is equal to horizontal distance
of x minus 1, and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
'''

from Node import Node

# def updateLeftRightN(horD, data, l, flag, minD, maxD, mp):
#     if flag:
#         minMaxD = min(minD, horD)
#     else:
#         minMaxD = max(maxD, horD)
#     if horD in mp:
#         if mp[horD][1] <= l:
#             mp[horD] = (data, l)
#     else:
#         mp[horD] = (data, l)
#     return minMaxD

def updateLeftRight(horD, data, flag, minD, maxD, mp):
    if flag:
        minMaxD = min(minD, horD)
    else:
        minMaxD = max(maxD, horD)
    if horD not in mp:
        mp[horD] = data
    return minMaxD

def topView(root):
    if root == None:
        return
    minD = 0
    maxD = 0
    root.d = 0
    curQ = [root]
    mp = {root.d: root.data}
    while curQ:
        items = curQ[:]
        curQ = []
        for item in items:
            if item.left is not None and item.right is not None:
                item.left.d = item.d-1
                item.right.d = item.d+1
                minD = updateLeftRight(item.left.d, item.left.data, True, minD, maxD, mp)
                maxD = updateLeftRight(item.right.d, item.right.data, False, minD, maxD, mp)
                curQ.extend([item.left, item.right])
            elif item.left is not None:
                item.left.d = item.d-1
                minD = updateLeftRight(item.left.d, item.left.data, True, minD, maxD, mp)
                curQ.append(item.left)
            elif item.right is not None:
                item.right.d = item.d+1
                maxD = updateLeftRight(item.right.d, item.right.data, False, minD, maxD, mp)
                curQ.append(item.right)
    return [mp[i] for i in range(minD, maxD+1)]

root = Node(1)
root.left = Node(2)
root.right = Node(3)
# root.left.left = Node(4)
# root.left.right = Node(5)
root.left.right = Node(4)
root.left.right.right = Node(5)
root.left.right.right.right = Node(6)
# root.right.left = Node(6)
# root.right.right = Node(7)
# root.left.right.left = Node(10)
# root.left.right.right = Node(14)
print(topView(root))

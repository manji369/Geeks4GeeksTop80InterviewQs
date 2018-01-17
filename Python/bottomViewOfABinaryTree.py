'''
Q25. Given a Binary Tree, we need to print the bottom view from left to right.
A node x is there in output if x is the bottommost node at its horizontal
distance. Horizontal distance of left child of a node x is equal to horizontal
distance of x minus 1, and that of right child is horizontal distance of x plus
1.

Examples:

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root,
then print the later one in level traversal. For example, in the below diagram,
3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to
print 4.


                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25.
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
    mp[horD] = data
    return minMaxD

def bottomView(root):
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

root = Node(20)
root.left = Node(8)
root.right = Node(22)
root.left.left = Node(5)
root.left.right = Node(3)
root.right.left = Node(4)
root.right.right = Node(25)
root.left.right.left = Node(10)
root.left.right.right = Node(14)
print(bottomView(root))

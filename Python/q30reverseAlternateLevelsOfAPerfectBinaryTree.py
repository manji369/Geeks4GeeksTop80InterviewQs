'''
Q30. Given a Perfect Binary Tree, reverse the alternate level nodes of the
binary tree.


Given tree:
               1
            /     \
           2        3
         /  \      /  \
        4    5     6     7
       / \  / \   / \    / \
       8  9 10 11 12 13  14 15

Modified tree:
  	            1
             /     \
            3        2
          /  \      /  \
         4    5     6     7
        / \  / \   / \    / \
       15 14 13 12 11 10  9 8
'''
from Node import Node

def reverseAlternate(root):
    curQ = [root]
    l = 1
    while(curQ):
        prevQ = curQ[:]
        curQ = []
        for item in prevQ:
            if item.left is not None:
                curQ.append(item.left)
            if item.right is not None:
                curQ.append(item.right)
        if l%2 == 1:
            j = 0
            curQ = curQ[::-1]
            for item in prevQ:
                item.left = curQ[j]
                j += 1
                item.right = curQ[j]
                j += 1
            i = 0
            j = len(curQ)-1
            while(i < j):
                curQ[i].left, curQ[j].left = curQ[j].left, curQ[i].left
                curQ[i].right, curQ[j].right = curQ[j].right, curQ[i].right
                i += 1
                j -= 1
        l += 1

def printLevelOrder(root):
    curQ = [root]
    while(curQ):
        items = curQ[:]
        curQ = []
        for item in items:
            print(item.data, end=' ')
            if item.left is not None:
                curQ.append(item.left)
            if item.right is not None:
                curQ.append(item.right)
        print()

root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.left = Node(6)
root.right.right = Node(7)
root.left.left.left = Node(8)
root.left.left.right = Node(9)
root.left.right.left = Node(10)
root.left.right.right = Node(11)
root.right.left.left = Node(12)
root.right.left.right = Node(13)
root.right.right.left = Node(14)
root.right.right.right = Node(15)
printLevelOrder(root)
reverseAlternate(root)
print()
printLevelOrder(root)
print()

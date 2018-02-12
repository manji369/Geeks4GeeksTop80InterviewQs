'''
Q68. Write a function detectAndRemoveLoop() that checks whether a given Linked
List contains loop and if loop is present then removes the loop and returns
true. And if the list doesn’t contain loop then returns false.
'''
from Node import singlyConnectedNode as Node

def buildList(vals):
    l = Node()
    curL = l
    for i, val in enumerate(vals):
        curL.data = val
        if i != len(vals)-1:
            curL.next = Node()
            curL = curL.next
    curL.next = l.next
    return l

def printList(l):
    cur = l
    lSet = set()
    while cur:
        print(cur.data, end='->')
        if cur not in lSet:
            lSet.add(cur)
        else:
            print("loop")
            return
        cur = cur.next
    print('end')

def detectAndRemoveLoop(l):
    l1 = l; l2 = l
    hasLoop = False
    while l1 and l2 and l2.next:
        prev = l1
        l1 = l1.next
        l2 = l2.next.next
        if l1 == l2:
            hasLoop = True
            l1 = l
            if l1 == l2:
                prev.next = None
                return hasLoop, l
            while l1.next.data != l2.next.data:
                l1 = l1.next
                l2 = l2.next
            l2.next = None
            return hasLoop, l
    return hasLoop, l

l = buildList([1, 2, 3, 4, 5])
printList(l)
hasLoop, l = detectAndRemoveLoop(l)
if hasLoop:
    print("Has loop. Loop removed: ")
    printList(l)
else:
    print("No loop found")

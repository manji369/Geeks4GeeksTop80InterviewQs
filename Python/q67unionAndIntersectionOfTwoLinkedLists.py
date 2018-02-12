'''
Q67. Given two Linked Lists, create union and intersection lists that contain
union and intersection of the elements present in the given lists. Order of
elments in output lists doesn’t matter.

Example:

Input:
   List1: 10->15->4->20
   lsit2:  8->4->2->10
Output:
   Intersection List: 4->10
   Union List: 2->8->20->4->15->10
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
    return l

def printList(l):
    cur = l
    while cur:
        print(cur.data, end='->')
        cur = cur.next
    print('end')

def intersectionList(l1, l2):
    l1Set = set()
    result = Node()
    head = result
    while l1:
        l1Set.add(l1.data)
        l1 = l1.next
    while l2:
        if l2.data in l1Set:
            result.data = l2.data
            if l2.next:
                result.next = Node()
                result = result.next
        l2 = l2.next
    return head

def unionList(l1, l2):
    commonSet = set()
    result = Node()
    head = result
    while l1 and l2:
        if l1.data not in commonSet:
            commonSet.add(l1.data)
            result.data = l1.data
            if l1.next:
                result.next = Node()
                result = result.next
        if l2.data not in commonSet:
            commonSet.add(l2.data)
            result.data = l2.data
            if l2.next:
                result.next = Node()
                result = result.next
        l1 = l1.next
        l2 = l2.next
    return head

l1 = buildList([10, 15, 4, 20])
l2 = buildList([8, 4, 2, 10])
printList(l1)
printList(l2)
printList(intersectionList(l1, l2))
printList(unionList(l1, l2))

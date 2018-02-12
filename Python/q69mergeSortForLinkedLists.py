'''
Q69. Merge sort is often preferred for sorting a linked list. The slow
random-access performance of a linked list makes some other algorithms (such as
quicksort) perform poorly, and others (such as heapsort) completely impossible.
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

def sortedMergeRec(l1, l2):
    temp = None
    if l1 is None:
        return l2
    if l2 is None:
        return l1
    if l1.data <= l2.data:
        temp = l1
        temp.next = sortedMergeRec(l1.next, l2)
    else:
        temp = l2
        temp.next = sortedMergeRec(l1, l2.next)
    return temp

def splitList(head):
    if head is None:
        return head
    p1 = head.next; p2 = head
    while p2 and p1 and p1.next:
        p2 = p2.next
        p1 = p1.next.next
    return p2

def mergeSortLinkedList(head):
    if head is None or head.next is None:
        return head
    mid = splitList(head)
    p2 = mid.next
    mid.next = None
    left = mergeSortLinkedList(head)
    right = mergeSortLinkedList(p2)
    return sortedMergeRec(left, right)

head = buildList([2, 5, 1, 4, 7, 3, 6, 8])
l = mergeSortLinkedList(head)
printList(l)

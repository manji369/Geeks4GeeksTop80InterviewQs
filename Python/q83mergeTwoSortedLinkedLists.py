'''
Q83. Write a SortedMerge() function that takes two lists, each of which is
sorted in increasing order, and merges the two together into one list which is
in increasing order. SortedMerge() should return the new list. The new list
should be made by splicing
together the nodes of the first two lists.

For example if the first linked list a is 5->10->15 and the other linked list b
is 2->3->20, then SortedMerge() should return a pointer to the head node of the
merged list 2->3->5->10->15->20.

There are many cases to deal with: either ‘a’ or ‘b’ may be empty, during
processing either ‘a’ or ‘b’ may run out first, and finally there’s the problem
of starting the result list empty, and building it up while going through ‘a’
and ‘b’.
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

def sortedMergeIter(l1, l2):
    head = Node(0)
    cur = None
    while l1 or l2:
        if l1 is None:
            if cur is not None:
                cur.next = l2
            else:
                cur = l2
                head.next = cur
            return head.next
        if l2 is None:
            if cur is not None:
                cur.next = l1
            else:
                cur = l1
                head.next = cur
            return head.next
        if l1.data <= l2.data:
            if cur is None:
                cur = l1
                head.next = cur
            else:
                cur.next = l1
                cur = cur.next
            l1 = l1.next
        else:
            if cur is None:
                cur = l2
                head.next = cur
            else:
                cur.next = l2
                cur = cur.next
            l2 = l2.next
    return head.next

l1 = buildList([1, 5, 7, 8, 9, 10])
l2 = buildList([2, 3, 4, 6])
l = sortedMergeRec(l1, l2)
printList(l)
l1 = buildList([1, 5, 7, 8, 9, 10])
l2 = buildList([2, 3, 4, 6])
l = sortedMergeIter(l1, l2)
printList(l)

'''
Q65. Given two linked lists, insert nodes of second list into first list at
alternate positions of first list.
For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6,
the first list should become 5->12->7->10->17->2->13->4->11->6 and second list
should become empty. The nodes of second list should only be inserted when
there are positions available. For example, if the first list is 1->2->3 and
second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6
and second list to 7->8.

Use of extra space is not allowed (Not allowed to create additional nodes),
i.e., insertion must be done in-place. Expected time complexity is O(n) where n
is number of nodes in first list.
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

def mergeLists(l1, l2):
    curL1 = l1
    while curL1 and l2:
        tempL1 = curL1.next
        curL1.next = Node(l2.data)
        tempL2 = l2.next
        l2.next = None
        l2 = tempL2
        curL1.next.next = tempL1
        curL1 = curL1.next.next
    return l1, l2

l1 = buildList([1, 2, 3])
# l1 = buildList([1, 3])
l2 = buildList([4, 5, 6, 7, 8])
# l2 = buildList([2])
printList(l1)
printList(l2)
l1, l2 = mergeLists(l1, l2)
printList(l1)
printList(l2)

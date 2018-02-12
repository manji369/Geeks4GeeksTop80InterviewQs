'''
Q66. Given a linked list, write a function to reverse every k nodes (where k is
an input to the function).

Example:
Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
Output:  3->2->1->6->5->4->8->7->NULL.

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL.
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

def reverseEveryKNodes(l, k, prev = None):
    cur = l
    x = 0
    nxt = None
    while x < k and cur:
        nxt = cur.next
        cur.next = prev
        prev = cur
        cur = nxt
        x += 1
    head = prev
    if nxt:
        l.next = reverseEveryKNodes(nxt, k)
    return head

l = buildList([1, 2, 3, 4, 5, 6, 7, 8])
l = reverseEveryKNodes(l, 3)
printList(l)

'''
Q70. Given a singly linked list, select a random node from linked list (the
probability of picking a node should be 1/N if there are N nodes in list). You
are given a random number generator.
'''

from Node import singlyConnectedNode as Node
from random import randint as rdm

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

def pickRandom(l):
    if l is None:
        return None
    cnt = 0; cur = l
    while cur:
        cnt += 1
        cur = cur.next
    idx = rdm(1, cnt)
    cnt = 0
    while cnt < idx:
        res = l
        l = l.next
        cnt += 1
    return res

l = buildList([1, 2, 3, 4, 5])
n = pickRandom(l)
print(n.data)

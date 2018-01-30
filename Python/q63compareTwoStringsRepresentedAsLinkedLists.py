'''
Q63. Given two linked lists, represented as linked lists (every character is a
node in linked list). Write a function compare() that works similar to strcmp(),
i.e., it returns 0 if both strings are same, 1 if first linked list is
lexicographically greater, and -1 if second string is lexicographically greater.

Examples:

Input: list1 = g->e->e->k->s->a
       list2 = g->e->e->k->s->b
Output: -1

Input: list1 = g->e->e->k->s->a
       list2 = g->e->e->k->s
Output: 1

Input: list1 = g->e->e->k->s
       list2 = g->e->e->k->s
Output: 0
'''

from Node import singlyConnectedNode as Node

def compare(ll1, ll2):
    while ll1 and ll2 and ll1.data == ll2.data:
        ll1 = ll1.next
        ll2 = ll2.next
    if ll1 and ll2:
        return 1 if ll1.data > ll2.data else -1
    if ll1 and not ll2:
        return 1
    if ll2 and not ll1:
        return -1
    return 0

list1 = Node('g')
list1.next = Node('e')
list1.next.next = Node('e')
list1.next.next.next = Node('k')
list1.next.next.next.next = Node('s')
list1.next.next.next.next.next = Node('a')

list2 = Node('g')
list2.next = Node('e')
list2.next.next = Node('e')
list2.next.next.next = Node('k')
list2.next.next.next.next = Node('s')
list2.next.next.next.next.next = Node('b')

print(compare(list1, list2))

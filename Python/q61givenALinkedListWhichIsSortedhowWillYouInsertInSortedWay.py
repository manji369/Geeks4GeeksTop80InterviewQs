'''
Q61. Given a sorted linked list and a value to insert, write a function to insert
the value in sorted way.
'''

from Node import singlyConnectedNode

class LinkedList:

    def __init__(self):
        self.head = None

    def printList(self):
        cur = self.head
        while cur:
            print(cur.data, end='->')
            cur = cur.next
        print('end')

    def sortedInsert(self, node):
        if self.head is None:
            self.head = node
        elif node.data < self.head.data:
            node.next = self.head
            self.head = node
        else:
            cur = self.head
            while cur.next is not None and node.data > cur.next.data:
                cur = cur.next
            node.next = cur.next
            cur.next = node

ll = LinkedList()
ll.sortedInsert(singlyConnectedNode(5))
ll.sortedInsert(singlyConnectedNode(10))
ll.sortedInsert(singlyConnectedNode(7))
ll.sortedInsert(singlyConnectedNode(3))
ll.sortedInsert(singlyConnectedNode(1))
ll.sortedInsert(singlyConnectedNode(9))
ll.printList()

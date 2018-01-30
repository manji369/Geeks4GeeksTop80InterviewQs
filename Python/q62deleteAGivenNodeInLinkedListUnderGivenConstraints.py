'''
Q62. Given a Singly Linked List, write a function to delete a given node. Your
function must follow following constraints:
1) It must accept pointer to the start node as first parameter and node to be
deleted as second parameter i.e., pointer to head node is not global.
2) It should not return pointer to the head node.
3) It should not accept pointer to pointer to head node.
'''

from Node import singlyConnectedNode as Node
import gc

class LinkedList:

    def __init__(self):
        self.head = None

    def deleteNode(self, h, d):
        if(h == d):
            if not h.next:
                print("This is the only node. Cannot delete this node.")
            else:
                h.data = h.next.data
                h.next = h.next.next
                gc.collect()
        else:
            prev = h
            while prev.next != None and prev.next != d:
                prev = prev.next
            if prev.next == None:
                print("Given node is not in the list.")
            else:
                prev.next = prev.next.next
                gc.collect()

    def printList(self, h):
        # h = self.head
        while h:
            print(h.data, end='->')
            h = h.next
        print("end")

ll = LinkedList()
ll.head = Node(12)
ll.head.next = Node(15)
ll.head.next.next = Node(10)
ll.head.next.next.next = Node(11);
ll.head.next.next.next.next = Node(5);
ll.head.next.next.next.next.next = Node(6);
ll.head.next.next.next.next.next.next = Node(2);
ll.head.next.next.next.next.next.next.next = Node(3);

print("Given Linked List :")
ll.printList(ll.head)
print()

# Let us delete the node with value 10
print("Deleting node :" + str(ll.head.next.next.data))
ll.deleteNode(ll.head, ll.head.next.next)

print("Modified Linked list :")
ll.printList(ll.head)
print()

# Lets delete the first node
print("Deleting first Node")
ll.deleteNode(ll.head, ll.head)
print("Modified Linked List")
ll.printList(ll.head)

'''
Q64. Given two numbers represented by two linked lists, write a function that
returns sum list. The sum list is linked list representation of addition of two
input numbers. It is not allowed to modify the lists. Also, not allowed to use
explicit extra space (Hint: Use Recursion).

Example

Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
'''
from Node import singlyConnectedNode as Node

def lenLists(l1, l2):
    curL1, curL2 = l1, l2
    lenL1, lenL2 = 0, 0
    while curL1 or curL2:
        if curL1:
            lenL1 += 1
            curL1 = curL1.next
        if curL2:
            lenL2 += 1
            curL2 = curL2.next
    return lenL1, lenL2

def addNumbersUtil(l1, l2, c):
    if not l1:
        return None, Node()
    if not l1.next:
        val = l1.data + l2.data
        l = Node(val%10)
        return val//10, l
    pc, l = addNumbersUtil(l1.next, l2.next, c)
    newNode = Node()
    newNode.next = l
    l = newNode
    val = l1.data + l2.data + pc
    l.data = val%10
    return val//10, l

def remainingSum(l1, partSum, carry, diffLen):
    x = 0
    while x < diffLen:
        newNode = Node()
        newNode.next = partSum
        partSum = newNode
        val = l1.data + carry
        partSum.data = val%10
        carry = val//10
        x += 1
    if carry != 0:
        newNode = Node()
        newNode.next = partSum
        partSum = newNode
        partSum.data = carry
    return partSum


def addNumbers(l1, l2):
    lenL1, lenL2 = lenLists(l1, l2)
    curL1, curL2 = l1, l2
    if lenL1 == 0:
        return l2
    if lenL2 == 0:
        return l1
    if lenL1 == lenL2:
        carry, partSum = addNumbersUtil(l1, l2, Node())
        if carry != 0:
            finalSum = Node(carry)
            finalSum.next = partSum
        else:
            finalSum = partSum
        return finalSum
    if lenL1 > lenL2:
        diffLen = lenL1 - lenL2
        for i in range(diffLen):
            curL1 = curL1.next
        carry, partSum = addNumbersUtil(curL1, curL2, 0)
        finalSum = remainingSum(l1, partSum, carry, diffLen)
    else:
        diffLen = lenL2 - lenL1
        for i in range(diffLen):
            curL2 = curL2.next
        carry, partSum = addNumbersUtil(curL1, curL2, 0)
        finalSum = remainingSum(l2, partSum, carry, diffLen)
    return finalSum

def printList(l):
    cur = l
    while cur:
        print(cur.data, end='->')
        cur = cur.next
    print('end')

l1 = Node(1)
l2 = Node(2); l2.next = Node(3)
l = addNumbers(l1, l2)
printList(l)

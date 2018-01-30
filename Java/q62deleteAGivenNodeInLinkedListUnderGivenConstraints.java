/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

/**
 *
 * @author manji
 * 
 * Q62. Given a Singly Linked List, write a function to delete a given node. Your
function must follow following constraints:
1) It must accept pointer to the start node as first parameter and node to be
deleted as second parameter i.e., pointer to head node is not global.
2) It should not return pointer to the head node.
3) It should not accept pointer to pointer to head node.
 * 
 * 
 * 
 * Main Function:
 * q62deleteAGivenNodeInLinkedListUnderGivenConstraints ll = new q62deleteAGivenNodeInLinkedListUnderGivenConstraints();
        ll.head = new singlyConnectedNode(12);
        ll.head.next = new singlyConnectedNode(15);
        ll.head.next.next = new singlyConnectedNode(10);
        ll.head.next.next.next = new singlyConnectedNode(11);
        ll.head.next.next.next.next = new singlyConnectedNode(5);
        ll.head.next.next.next.next.next = new singlyConnectedNode(6);
        ll.head.next.next.next.next.next.next = new singlyConnectedNode(2);
        ll.head.next.next.next.next.next.next.next = new singlyConnectedNode(3);
 
        System.out.println("Given Linked List :");
        ll.printList(ll.head);
        System.out.println("");
         
        // Let us delete the node with value 10
        System.out.println("Deleting node :" + ll.head.next.next.data);
        ll.deleteNode(ll.head, ll.head.next.next);
 
        System.out.println("Modified Linked list :");
        ll.printList(ll.head);
        System.out.println("");
 
        // Lets delete the first node
        System.out.println("Deleting first Node");
        ll.deleteNode(ll.head, ll.head);
        System.out.println("Modified Linked List");
        ll.printList(ll.head);
 * 
 */

public class q62deleteAGivenNodeInLinkedListUnderGivenConstraints {
    static singlyConnectedNode head;
    
    void deleteNode(singlyConnectedNode h, singlyConnectedNode d){
        if(h == d){
            if(h.next == null)
                System.out.println("Only one item in this node. Can't delete this node");
            else{
                h.data = h.next.data;
                h.next = h.next.next;
                System.gc();
            }
        }else{
            singlyConnectedNode prev = h;
            while(prev.next != null && prev.next != d)
                prev = prev.next;
            if(prev.next == null)
                System.out.println("Could not find this element in the list");
            else{
                prev.next = prev.next.next;
                System.gc();
            }
        }
    }
    
    void printList(singlyConnectedNode h){
        while(h != null){
            System.out.print(h.data + "->");
            h = h.next;
        }
        System.out.println("end");
    }
}

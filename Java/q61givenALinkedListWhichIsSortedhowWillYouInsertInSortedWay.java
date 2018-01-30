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
 * Q61. Given a sorted linked list and a value to insert, write a function to insert
the value in sorted way.
 * 
 * 
 * Main Function:
 * q61givenALinkedListWhichIsSortedhowWillYouInsertInSortedWay ll = new q61givenALinkedListWhichIsSortedhowWillYouInsertInSortedWay();
        ll.sortedInsert(new singlyConnectedNode(5));
        ll.sortedInsert(new singlyConnectedNode(10));
        ll.sortedInsert(new singlyConnectedNode(7));
        ll.sortedInsert(new singlyConnectedNode(3));
        ll.sortedInsert(new singlyConnectedNode(1));
        ll.sortedInsert(new singlyConnectedNode(9));
        ll.printList();
 * 
 */

class singlyConnectedNode{
    int data;
    singlyConnectedNode next;
    singlyConnectedNode(int val){
        data = val;
        next = null;
    }
}

public class q61givenALinkedListWhichIsSortedhowWillYouInsertInSortedWay {
    
    singlyConnectedNode head = null;
    
    void printList(){
        singlyConnectedNode cur = head;
        while(cur != null){
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("end");
    }
    
    void sortedInsert(singlyConnectedNode node){
        if(head == null)
            head = node;
        else if(node.data < head.data){
            node.next = head;
            head = node;
        }else{
            singlyConnectedNode cur = head;
            while(cur.next != null && node.data > cur.next.data)
                cur = cur.next;
            node.next = cur.next;
            cur.next = node;
        }
    }
}

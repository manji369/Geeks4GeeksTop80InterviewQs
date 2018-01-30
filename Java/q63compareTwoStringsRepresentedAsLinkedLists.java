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
 * Q63. Given two linked lists, represented as linked lists (every character is a
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
 * 
 * 
 * Main Function:
 * singlyConnectedNode ll1 = new singlyConnectedNode('g');
        ll1.next = new singlyConnectedNode('e');
        ll1.next.next = new singlyConnectedNode('e');
        ll1.next.next.next = new singlyConnectedNode('k');
        ll1.next.next.next.next = new singlyConnectedNode('s');
        ll1.next.next.next.next.next = new singlyConnectedNode('b');
 
        singlyConnectedNode ll2 = new singlyConnectedNode('g');
        ll2.next = new singlyConnectedNode('e');
        ll2.next.next = new singlyConnectedNode('e');
        ll2.next.next.next = new singlyConnectedNode('k');
        ll2.next.next.next.next = new singlyConnectedNode('s');
        ll2.next.next.next.next.next = new singlyConnectedNode('a');
 
        int value;
        value = compare(ll1, ll2);
        System.out.println(value);
 * 
 */
public class q63compareTwoStringsRepresentedAsLinkedLists {
    public static int compare(singlyConnectedNode ll1, singlyConnectedNode ll2){
        while(ll1 != null && ll2 != null && ll1.data == ll2.data){
            ll1 = ll1.next;
            ll2 = ll2.next;
        }
        if(ll1 != null && ll2 != null)
            return ll1.data > ll2.data ? 1: 0;
        if(ll1 != null && ll2 == null)
            return 1;
        if(ll1 == null && ll2 != null)
            return -1;
        return 0;
    }
}

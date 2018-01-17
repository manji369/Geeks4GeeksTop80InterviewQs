/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.ArrayList;

/**
 *
 * @author manji
 * 
 * 
 * Q29. Given two binary trees, check if the first tree is subtree of the second
one. A subtree of a tree T is a tree S consisting of a node in T and all of its
descendants in T.

The subtree corresponding to the root node is the entire tree; the subtree
corresponding to any other node is called a proper subtree.

For example, in the following case, Tree1 is a subtree of Tree2.


        Tree1
          2
        /    \
      4       5
       \
        7


        Tree2
              1
            /   \
          2      3
        /    \     \
      4       5      6
       \
        7
 * 
 * 
 * Main Function:
 * Node t1 = new Node(2);
        t1.left = new Node(4);
        t1.right = new Node(5);
        t1.left.right = new Node(7);
//        t1.left.left = new Node(8);
        Node t2 = new Node(1);
        t2.left = new Node(2);
        t2.left.left = new Node(4);
        t2.left.right = new Node(5);
        t2.left.left.right = new Node(7);
        t2.right = new Node(3);
        t2.right.right = new Node(6);
        System.out.println(isSubtreeN2(t1, t2));
 * 
 */
public class checkIfABinaryTreeIsSubtreeOfAnotherBinaryTree {
    
    private static boolean traversePreOrder(Node t1, Node t2){
        if(t1 == null)
            return true;
        if(t1 != null && t2 == null)
            return false;
        if(t1.data != t2.data)
            return false;
        return traversePreOrder(t1.left, t2.left) && traversePreOrder(t1.right, t2.right);
    }
    
    public static boolean isSubtreeN2(Node t1, Node t2){
        ArrayList<Node> curQ = new ArrayList<Node>();
        curQ.add(t2);
        while(!curQ.isEmpty()){
            ArrayList<Node> items = new ArrayList<Node>(curQ);
            curQ = new ArrayList<Node>();
            for(Node item: items){
                if(traversePreOrder(t1, item))
                    return true;
                if(item.left != null)
                    curQ.add(item.left);
                if(item.right != null)
                    curQ.add(item.right);
            }
        }
        return false;
    }
}

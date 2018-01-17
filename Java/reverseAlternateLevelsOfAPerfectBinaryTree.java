/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author manji
 * 
 * 
 * Q30. Given a Perfect Binary Tree, reverse the alternate level nodes of the
binary tree.


Given tree:
               1
            /     \
           2        3
         /  \      /  \
        4    5     6     7
       / \  / \   / \    / \
       8  9 10 11 12 13  14 15

Modified tree:
  	            1
             /     \
            3        2
          /  \      /  \
         4    5     6     7
        / \  / \   / \    / \
       15 14 13 12 11 10  9 8
 * 
 * 
 * Main Function:
 * Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
        printLevelOrder(root);
        reverseAlternate(root);
        System.out.println("");
        printLevelOrder(root);
        System.out.println("");
 * 
 */
public class reverseAlternateLevelsOfAPerfectBinaryTree {
    public static void reverseAlternate(Node root){
        ArrayList<Node> curQ = new ArrayList<Node>();
        curQ.add(root);
        int l = 1;
        while(!curQ.isEmpty()){
            ArrayList<Node> prevQ = new ArrayList<Node>(curQ);
            curQ = new ArrayList<>();
            for(Node item: prevQ){
                if(item.left != null)
                    curQ.add(item.left);
                if(item.right != null)
                    curQ.add(item.right);
            }
            if(l%2 == 1){
                int j = 0;
                Collections.reverse(curQ);
                for(Node item: prevQ){
                    item.left = curQ.get(j);
                    j++;
                    item.right = curQ.get(j);
                    j++;
                }
                int i = 0;
                j = curQ.size()-1;
                while(i < j){
                    Node temp = curQ.get(i).left;
                    curQ.get(i).left = curQ.get(j).left;
                    curQ.get(j).left = temp;
                    temp = curQ.get(i).right;
                    curQ.get(i).right = curQ.get(j).right;
                    curQ.get(j).right = temp;
                    i++;
                    j--;
                }                    
            }
            l++;
        }
    }
    
    public static void printLevelOrder(Node root){
        ArrayList<Node> curQ = new ArrayList<Node>();
        curQ.add(root);
        while(!curQ.isEmpty()){
            ArrayList<Node> items = new ArrayList<Node>(curQ);
            curQ = new ArrayList<>();
            for(Node item: items){
                System.out.print(item.data + " ");
                if(item.left != null)
                    curQ.add(item.left);
                if(item.right != null)
                    curQ.add(item.right);
            }
            System.out.println("");
        }
    }
}

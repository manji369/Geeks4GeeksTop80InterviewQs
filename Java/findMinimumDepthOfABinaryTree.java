/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author manji
 * 
 * Q21. iven a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from root node down to the nearest leaf node.

For example, minimum height of below Binary Tree is 2.
Example Tree

          1
        /  \
      2     3
     / \
    4   5
 * 
 * 
 * Main Function:
 * Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(minDepth(root));
 * 
 */

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class findMinimumDepthOfABinaryTree {
    public static int minDepth(Node root){
        if(root == null){
            return 0;
        }
        int cnt = 1;
        ArrayList<ArrayList<Node>> q = new ArrayList<ArrayList<Node>>();
        ArrayList<Node> curQ = new ArrayList<Node>();
        curQ.add(root);
        q.add(curQ);
        while(q.size() > 0){
            curQ = new ArrayList<Node>();
            ArrayList<Node> items = q.remove(0);
            for(Node item: items){
                if(item.left == null && item.right == null){
                    return cnt;
                }
                if(item.left == null){
                    curQ.add(item.right);
                }else if(item.right == null){
                    curQ.add(item.left);
                }else{
                    curQ.add(item.left);
                    curQ.add(item.right);
                }
            }
            q.add(curQ);
            cnt += 1;
        }
        return cnt;
    }
}

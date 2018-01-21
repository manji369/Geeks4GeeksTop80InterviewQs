/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geeks4geekstop80interviewquestions;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author manji
 * 
 * 
 * Q26. Top view of a binary tree is the set of nodes visible when the tree is
viewed from the top. Given a binary tree, print the top view of it. The output
nodes can be printed in any order. Expected time complexity is O(n)

A node x is there in output if x is the topmost node at its horizontal distance.
Horizontal distance of left child of a node x is equal to horizontal distance
of x minus 1, and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
 * 
 * 
 * Main Function:
 * NodeWithHD root = new NodeWithHD(1);
        root.left = new NodeWithHD(2);
        root.right = new NodeWithHD(3);
        root.left.left = new NodeWithHD(4);
        root.left.right = new NodeWithHD(5);
        root.right.left = new NodeWithHD(6);
        root.right.right = new NodeWithHD(7);
        topView(root);
 * 
 */
public class printNodesInTopViewOfBinaryTree {
    public static void topView(NodeWithHD root){
       if(root == null)
            System.out.println("Tree is empty hence no bottom view");
       int minD = 0, maxD = 0;
       root.hd = 0;
       ArrayList<NodeWithHD> curQ = new ArrayList<NodeWithHD>();
       curQ.add(root);
       HashMap<Integer, Integer> mp = new HashMap<>();
       mp.put(root.hd, root.data);
       while(!curQ.isEmpty()){
           ArrayList<NodeWithHD> items = new ArrayList<>(curQ);
           curQ = new ArrayList<>();
           for(NodeWithHD item: items){
               if(item.left != null && item.right != null){
                   item.left.hd = item.hd-1;
                   item.right.hd = item.hd+1;
                   minD = Math.min(minD, item.left.hd);
                   maxD = Math.max(maxD, item.right.hd);
                   if(!mp.containsKey(item.left.hd))
                       mp.put(item.left.hd, item.left.data);
                   if(!mp.containsKey(item.right.hd))
                       mp.put(item.right.hd, item.right.data);
                   curQ.add(item.left);
                   curQ.add(item.right);
               }else if(item.left != null){
                   item.left.hd = item.hd-1;
                   minD = Math.min(minD, item.left.hd);
                   if(!mp.containsKey(item.left.hd))
                       mp.put(item.left.hd, item.left.data);
                   curQ.add(item.left);
               }else if(item.right != null){
                   item.right.hd = item.hd+1;
                   maxD = Math.max(maxD, item.right.hd);
                   if(!mp.containsKey(item.right.hd))
                       mp.put(item.right.hd, item.right.data);
                   curQ.add(item.right);
               }
           }
       }
       for(int i = minD; i <= maxD; i++){
           if(mp.containsKey(i)){
                System.out.print(mp.get(i) + " ");
           }
       }
    }
}

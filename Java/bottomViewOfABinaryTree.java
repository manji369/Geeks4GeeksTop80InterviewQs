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
 * Q25. Given a Binary Tree, we need to print the bottom view from left to right.
A node x is there in output if x is the bottommost node at its horizontal
distance. Horizontal distance of left child of a node x is equal to horizontal
distance of x minus 1, and that of right child is horizontal distance of x plus
1.

Examples:

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root,
then print the later one in level traversal. For example, in the below diagram,
3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to
print 4.


                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25.
 * 
 * 
 * Main Function:
 * NodeWithHD root = new NodeWithHD(1);
        root.left = new NodeWithHD(8);
        root.right = new NodeWithHD(22);
        root.left.left = new NodeWithHD(5);
        root.left.right = new NodeWithHD(3);
        root.right.left = new NodeWithHD(4);
        root.right.right = new NodeWithHD(25);
        root.left.right.left = new NodeWithHD(10);
        root.left.right.right = new NodeWithHD(14);
        bottomView(root);
 * 
 */

class NodeWithHD{
    int data, hd;
    NodeWithHD left, right;
    public NodeWithHD(int data){
        this.data = data;
        hd = 0;
        left = right = null;
    }
}

public class bottomViewOfABinaryTree {
    public static void bottomView(NodeWithHD root){
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
                   mp.put(item.left.hd, item.left.data);
                   mp.put(item.right.hd, item.right.data);
                   curQ.add(item.left);
                   curQ.add(item.right);
               }else if(item.left != null){
                   item.left.hd = item.hd-1;
                   minD = Math.min(minD, item.left.hd);
                   mp.put(item.left.hd, item.left.data);
                   curQ.add(item.left);
               }else if(item.right != null){
                   item.right.hd = item.hd+1;
                   maxD = Math.max(maxD, item.right.hd);
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

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
 * q24. A full binary tree is defined as a binary tree in which all nodes have
either zero or two child nodes. Conversely, there is no node in a full binary
tree, which has one child node. More information about full binary trees can be
found here.
 * 
 * 
 * Main Function:
 * Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(isBinaryTree(root));
 * 
 */
public class checkWhetherABinaryTreeIsAFullBinaryTreeOrNot {
    public static boolean isBinaryTree(Node root){
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        if(root.left != null && root.right != null)
            return true;
        return false;
    }
}

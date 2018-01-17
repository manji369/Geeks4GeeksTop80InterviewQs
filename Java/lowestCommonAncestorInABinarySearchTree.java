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
 * Q28. Given values of two values n1 and n2 in a Binary Search Tree, find the
Lowest Common Ancestor (LCA). You may assume that both the values exist in the
tree.
Example:
                20
               / \
              8   22
             / \
            4  12
              / \
             10  14
LCA of 10 and 14 is 12
LCA of 14 and 8 is 8
LCA of 10 and 22 is 20
 * 
 * 
 * Main Function:
 * Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        System.out.println(lca(root, 10, 22).data);
 * 
 */
public class lowestCommonAncestorInABinarySearchTree {
    public static Node lca(Node root, int n1, int n2){
        if(root == null)
            return null;
        if(root.data > n1 && root.data > n2)
            return lca(root.left, n1, n2);
        if(root.data < n1 && root.data < n2)
            return lca(root.right, n1, n2);
        return root;
    }
}

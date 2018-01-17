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
 * Q12. Given a binary tree, find the maximum path sum. The path may start and end
at any node in the tree.

Example:

Input: Root of below tree
       1
      / \
     2   3
Output: 6
 * 
 * Main Function:
 * Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println(findMaxPathSum(root));
 * 
 */

public class maximumPathSumInABinaryTree {
    
    public static int res = Integer.MIN_VALUE;
    
    private static int findMaxPathSumUtil(Node root){
        if(root == null){
            return 0;
        }
        int l = findMaxPathSumUtil(root.left);
        int r = findMaxPathSumUtil(root.right);
        int maxOneSide = Math.max(Math.max(l, r) + root.data, root.data);
        int maxBothSides = Math.max(maxOneSide, l+r+root.data);
        res = Math.max(res, maxBothSides);
        return maxOneSide;
    }
    
    public static int findMaxPathSum(Node root){
        findMaxPathSumUtil(root);
        return res;
    }
}

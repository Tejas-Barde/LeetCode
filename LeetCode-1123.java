/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return find(root);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }

    private TreeNode find(TreeNode root){
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if(leftDepth == rightDepth) return root;
        if(leftDepth > rightDepth){
            return find(root.left);
        }
        return find(root.right);
    }
}
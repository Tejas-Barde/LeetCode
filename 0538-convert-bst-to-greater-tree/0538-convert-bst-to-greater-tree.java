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
    int rootSum;
    public TreeNode convertBST(TreeNode root) {
        this.rootSum = 0;
        backtrack(root);
        return root;
    }

    private void backtrack(TreeNode root){
        if(root == null) return ;
        backtrack(root.right);
        rootSum += root.val;
        root.val = rootSum;
        backtrack(root.left);
    }
}
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
    List<Integer> result ;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.result = new ArrayList<>();
        helper(root);
        return result;
    }

    private void helper(TreeNode root){
        if(root == null) return;
        helper(root.left); 
        result.add(root.val);
        helper(root.right); 
    }
}
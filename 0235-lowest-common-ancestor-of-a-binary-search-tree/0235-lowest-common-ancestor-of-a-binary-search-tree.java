/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return backtrack(root,p.val,q.val);
    }

    private TreeNode backtrack(TreeNode root,int p,int q){
        if(root == null || root.val == p || root.val == q) return root;

        if(p > root.val && q > root.val){
            return backtrack(root.right,p,q);
        }
        if(p < root.val && q < root.val){
            return backtrack(root.left,p,q);
        }
        return root;
    }
}
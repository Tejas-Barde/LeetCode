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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String suffix) {
        if (node == null) return null;

        String curr = (char)('a' + node.val) + suffix;

        if (node.left == null && node.right == null) {
            return curr;
        }

        String left = dfs(node.left, curr);
        String right = dfs(node.right, curr);

        if (left == null) return right;
        if (right == null) return left;

        return left.compareTo(right) < 0 ? left : right;
    }
}

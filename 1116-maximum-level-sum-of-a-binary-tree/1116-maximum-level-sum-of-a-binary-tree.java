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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int max = Integer.MIN_VALUE;
        int result = 0;
        int depth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            int sum = 0;
            for(int i = 0;i<size;i++){
                TreeNode curr = que.poll();
                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
                sum += curr.val;
            }
            depth++;
            if(max < sum){
                max = sum;
                result = depth; 
            }
        }
        return result;
    }
}
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
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        this.target = targetSum;
        backtrack(root,0,new ArrayList<>());
        return this.result;
    }

    private void backtrack(TreeNode root,int sum,List<Integer> list){
        if(root == null) return ;
        list.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == target) 
                result.add(new ArrayList<>(list));
        }
        backtrack(root.left,sum,list);
        backtrack(root.right,sum,list);
        list.remove(list.size()-1);
    }
}
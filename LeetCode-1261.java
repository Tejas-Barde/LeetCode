import java.util.*;

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
class FindElements {
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        root.val = 0;
        fillSet(root);
    }
    
    public boolean find(int target) {
        return set.contains(target) || target == 0;
    }

    private void fillSet(TreeNode root){
        if(root.left == null && root.right == null) return;
        if(root.left != null) {
            root.left.val = root.val*2+1;
            set.add(root.val*2+1);
            fillSet(root.left);
        }
        if(root.right != null){
            root.right.val = root.val*2+2;
            set.add(root.val*2+2);
            fillSet(root.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
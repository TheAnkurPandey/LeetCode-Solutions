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
    public int maxDepth(TreeNode root) {
        // O(n) time & O(h) space
        
        // Base case
        if(root == null) return 0;
        
        // Recursive case
        int heightOfLeftSubtree = maxDepth(root.left);
        int heightOfRightSubtree = maxDepth(root.right);
        
        return Math.max(heightOfLeftSubtree, heightOfRightSubtree) + 1;
    }
}
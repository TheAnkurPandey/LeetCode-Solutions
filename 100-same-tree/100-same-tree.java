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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // O(min(m, n)) time & O(min(h1, h2)) space
        
        // Base case
        if (p == null && q == null) return true;  // Both are empty tree
        if (p == null && q != null) return false;  // Only 1 of them is empty
        if (p != null && q == null) return false;  // Only 1 of them is empty
        if (p.val != q.val) return false;  // Unequal values
        
        // Recursive case
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
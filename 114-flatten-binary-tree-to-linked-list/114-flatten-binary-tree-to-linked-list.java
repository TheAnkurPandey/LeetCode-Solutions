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
    public void flatten(TreeNode root) {
        flattenBinaryTreeToLLRec(root);
    }
    
    private TreeNode flattenBinaryTreeToLLRec(TreeNode root) {
        // Postorder traversal
        // O(n) time & O(h) space
        
        // Base case
        if (root == null) return null;
        
        // Recursive case
        // Storing heads of linked list
        TreeNode leftSubtree = root.left;  // head of Left LinkedList
        TreeNode rightSubtree = root.right;  // head of Right LinkedList
        
        // Storing tail of LinkedList
        TreeNode flattenedLeftEnd = flattenBinaryTreeToLLRec(root.left);  // Tail of left
        TreeNode flattenedRightEnd = flattenBinaryTreeToLLRec(root.right);  // Tail of right
        
        
        // Postorder
        root.left = null;  // Detach left subtree
        
        
        if (leftSubtree != null) {  // Has left subtree
            
            root.right = leftSubtree;  // Point rightPtr to Head of left LL
            flattenedLeftEnd.right = rightSubtree;  // Point Tail of left LL to Head of right LL
            
            // Return the Tail of Right LL, Otherwise Tail of left LL
            if (flattenedRightEnd != null) return flattenedRightEnd;
            else return flattenedLeftEnd;
            
        } else if (rightSubtree != null) {  // Has no Left subtree but has Right subtree
            
            root.right = rightSubtree;
            return flattenedRightEnd;
            
        } else {  // Leaf node (Leaf is always a flattened)
            return root;
        }
    }
}
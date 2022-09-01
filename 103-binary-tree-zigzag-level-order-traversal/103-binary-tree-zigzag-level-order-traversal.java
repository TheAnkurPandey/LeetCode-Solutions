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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // O(n) time & O(n) space
        
        List<List<Integer>> output = new ArrayList<>();
        
        if (root == null) return output;
        
        LinkedList<TreeNode> mainStack = new LinkedList<>();
        LinkedList<TreeNode> childStack = new LinkedList<>();
        boolean leftToRight = true;
        
        mainStack.addLast(root);
        
        ArrayList<Integer> nodesInLevel = new ArrayList<>();
        
        while (!mainStack.isEmpty()) {
            TreeNode node = mainStack.removeLast();
            
            nodesInLevel.add(node.val);
            
            TreeNode nodeA;
            TreeNode nodeB;
            
            if (leftToRight) {
                nodeA = node.left;
                nodeB = node.right;
            } else {
                nodeA = node.right;
                nodeB = node.left;
            }
            
            if (nodeA != null) childStack.addLast(nodeA);
            if (nodeB != null) childStack.addLast(nodeB);
            
            if (mainStack.isEmpty()) {
                
                mainStack = childStack;
                childStack = new LinkedList<>();
                
                output.add(nodesInLevel);
                
                nodesInLevel = new ArrayList<>();
                
                leftToRight = !leftToRight;
            }
        }
        
        return output;
    }
}
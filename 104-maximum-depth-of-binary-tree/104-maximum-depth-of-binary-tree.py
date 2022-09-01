# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # O(n) time & O(h) space
        
        # Base case
        if root == None: return 0
        
        # Recursive case
        left_depth = self.maxDepth(root.left)
        right_depth = self.maxDepth(root.right)
        
        node_depth = max(left_depth, right_depth) + 1
        
        return node_depth
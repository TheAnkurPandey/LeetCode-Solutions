# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return self.invertTreeHelperRec(root)
    
    def invertTreeHelperRec(self, 
                            root: Optional[TreeNode]) -> Optional[TreeNode]:
        # O(n) time & O(h) space
        
        # Base case
        if root == None:
            return root
        
        # Recursive case
        root.left, root.right = root.right, root.left
        
        root.left = self.invertTreeHelperRec(root.left)
        root.right = self.invertTreeHelperRec(root.right)
        
        return root
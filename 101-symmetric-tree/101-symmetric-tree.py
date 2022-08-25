# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.isSymmetricHelper(root.left, root.right)
    
    def isSymmetricHelper(self, 
                    root_a: Optional[TreeNode], 
                    root_b: Optional[TreeNode]):
        # O(n) time & O(h) space
        
        # Base case
        if root_a == None and root_b == None:
            return True
        elif root_a == None and root_b != None:
            return False
        elif root_a != None and root_b == None:
            return False
        elif root_a.val != root_b.val:
            return False
        
        # Recursive case
        is_outer_symmetric = self.isSymmetricHelper(root_a.left, root_b.right)
        is_inner_symmetric = self.isSymmetricHelper(root_a.right, root_b.left)
        
        return  is_outer_symmetric and is_inner_symmetric
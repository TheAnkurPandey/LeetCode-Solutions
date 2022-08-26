# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        # return self.invertTreeHelperRec(root)
        return self.invertTreeHelperIter(root)
    
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
    
    def invertTreeHelperIter(self, 
                             root: Optional[TreeNode]) -> Optional[TreeNode]:
        # O(n) time & O(n) space
        
        # Trivial case
        if root == None: return root
        
        # General case
        queue = deque()
        queue.append(root)
        
        while queue:
            node = queue.popleft()
            
            # Edge case
            if node == None: continue
            
            left_subtree = node.left
            right_subtree = node.right
            
            # Swap subtrees
            node.left, node.right = right_subtree, left_subtree
            
            queue.append(right_subtree)
            queue.append(left_subtree)
            
        return root
        